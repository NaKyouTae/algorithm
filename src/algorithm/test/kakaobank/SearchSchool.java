package algorithm.test.kakaobank;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CSV 파일 분석 및 결과
 * 1. 댓글에 있는 학교 이름은 빈칸이 없는 것을 기준으로 하였다.
 *    빈칸이 없는 것을 기준으로 한 이유는 부천 동여자중학교 또는 동여자중학교 인지 구분하는 것은 추측이기 때문이다.
 *    이 경우 진짜힘든우리고등학교, 진짜동두천여자중학교, 우리중학교와 같이 학교 이름으로 판단되지 않는 데이터가 추출될 가능성이 높다.
 *    해결책으로는 자주 사용되는 무의미한 단어(우리, 진짜, 힘든 등등)을 수집하여 판단 비교가 필요하다.
 *    이 과제에서는 데이터를 분석하여 무의미해 보이는 단어들을 정의하고 제거하는 방법으로 구현한다.
 * 2. 대구경북대학교사범대학부설중학교, 경북대학교사범대학부설중학교, 대구사대부중학교 처럼 같은 의미로 파악되지만 다른 단어는 다른 학교로 구분하였다.
 *    다른 학교로 구분한 이유는 작은 범위의 학교 이름을 큰 범위와 맞추는 것은 추측이기 때문이다.
 *    사대부라는 단어가 사범대학교부속 또는 사범대학교부설 둘중 어느 것이 맞는지 판단하는 것이 추측이기 때문이다.
 *
 * 학교 이름 추출 로직 설명
 * 1. '고등학교', '중학교' 단어 뒤의 문자들을 제거한다.
 * 2. 제거된 문자에서 첫 글자부터 특수문자, 한글 자음, 모음이 나오는 부분까지 제거한다.
 *
 * 파일 읽기 및 쓰기
 * 1. comments.csv 파일은 D 드라이브에 있다고 가정한다.
 * 2. result.txt 파일은 D 다르이브에 저장된다고 가정한다.
 *
 * 작성일 : 2021-10-05
 * 작성자 : 나규태
 */
public class SearchSchool {
    private static final String COMMENTS_FILE_PATH = "d:\\comments.csv";
    private static final String HIGH_SCHOOL = "고등학교";
    private static final String MIDDLE_SCHOOL = "중학교";

    /**
     * String 타입 한글을 한자씩 받아 char 타입으로 변환후 비교하여 정렬
     * */
    public static Comparator<Map.Entry<String, Integer>> compare = new Comparator<>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            int minLen = Math.min(o1.getKey().length(), o2.getKey().length());

            String o1Value = o1.getKey();
            String o2Value = o2.getKey();

            for (int i = 0; i < minLen; i++) {
                if (o1Value.charAt(i) > o2Value.charAt(i)) {
                    return 1;
                } else if (o1Value.charAt(i) < o2Value.charAt(i)) {
                    return -1;
                }
            }

            return 0;
        }
    };

    public static void main(String[] args) {
        BufferedReader br;

        try{
            br = Files.newBufferedReader(Paths.get(COMMENTS_FILE_PATH));

            String line = "";

            Map<String, Integer> highSchoolInfo = new HashMap<>();
            Map<String, Integer> middleSchoolInfo = new HashMap<>();

            while((line = br.readLine()) != null) {
                if(line.length() < 3) continue; // 길이가 3미만은 제외
                if(!line.contains(HIGH_SCHOOL) && !line.contains(MIDDLE_SCHOOL)) continue; // 텍스트 라인에 '고등학교', '중학교'가 포함되어 있지 않으면 제외

                List<String> words = Arrays.asList(line.split(" ")); // '고등학교', '중학교'가 포함된 문자를 공백 기준으로 분리

                for (int i = 0; i < words.size(); i++) {
                    String word = words.get(i);
                    if(word.contains(MIDDLE_SCHOOL) && word.indexOf(MIDDLE_SCHOOL) == 0) continue; // '중학교'가 포함되어 있지만 학교 이름이 없는 경우 제외
                    if(word.contains(HIGH_SCHOOL) && word.indexOf(HIGH_SCHOOL) == 0) continue; // '고등학교'가 포함되어 있지만 학교 이름이 없는 경우 제외
                    if(!word.contains(HIGH_SCHOOL) && !word.contains(MIDDLE_SCHOOL)) continue; // '고등학교', '중학교'가 포함되어 있지 않으면 제외

                    String refinedSchoolName = word.replaceAll("\"", ""); // 쌍따옴표 제거

                    refinedSchoolName = deleteNeedLessWord(refinedSchoolName); // 특수 문자 및 학교 이름 뒤의 글자와 첫 글자 부터 가장 마지막에 오는 특수문자까지 제거한다.

                    if(refinedSchoolName.contains(HIGH_SCHOOL)) {
                        if(refinedSchoolName.length() <= HIGH_SCHOOL.length()) continue;

                        String findHighSchoolName = findSchoolName(highSchoolInfo, refinedSchoolName); // 학교 이름을 포함하는 더 큰 범위의 학교 이름 찾기

                        highSchoolInfo.put(findHighSchoolName, highSchoolInfo.getOrDefault(findHighSchoolName, 1)+1);
                    }else {
                        if(refinedSchoolName.length() <= MIDDLE_SCHOOL.length()) continue;

                        String findMiddleSchoolName = findSchoolName(middleSchoolInfo, refinedSchoolName); // 학교 이름을 포함하는 더 큰 범위의 학교 이름 찾기

                        middleSchoolInfo.put(findMiddleSchoolName, middleSchoolInfo.getOrDefault(findMiddleSchoolName, 1)+1);
                    }
                }                
            }

            List<Map.Entry<String, Integer>> highSchoolList = new ArrayList<Map.Entry<String, Integer>>(highSchoolInfo.entrySet());
            List<Map.Entry<String, Integer>> middleSchoolList = new ArrayList<Map.Entry<String, Integer>>(middleSchoolInfo.entrySet());

            highSchoolList.sort(compare);
            middleSchoolList.sort(compare);

            OutputStream os = new FileOutputStream("d:\\result.txt");

            StringBuilder sb = new StringBuilder();

            for (Map.Entry<String, Integer> schoolInfo : middleSchoolList) {
                sb.append(schoolInfo.getKey()).append("\t").append(schoolInfo.getValue()).append("\n");
            }

            for (Map.Entry<String, Integer> schoolInfo : highSchoolList) {
                sb.append(schoolInfo.getKey()).append("\t").append(schoolInfo.getValue()).append("\n");
            }

            byte[] by = sb.toString().getBytes();

            os.write(by);
            os.flush();
            os.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 학교 이름으로 불필요한 문자 제거하는 함수
     *
     * Comments
     * '고등학교', '중학교' 단어 뒤의 문자들을 제거 후
     * 첫 글자부터 가장 마지막에 오는 특수문자, 한글 자음, 모음까지 제거한다.
     * 자주 사용되는 무의미한 학교이름으로 추출 되는 단어들 제거한다.
     * */
    public static String deleteNeedLessWord(String word) {
        String refinedSchoolName = deleteBackWord(word); // '고등학교', '중학교' 뒤의 단어 버리기

        String regex = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; // 특수문자, 한글 자음, 모음(한글, 숫자, 영문, 공백 제회) 정규식
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(refinedSchoolName);

        int firstLocation = 0;
        boolean isFind = false;

        while (matcher.find()) {
            firstLocation = matcher.start();
            isFind = true;
        }

        refinedSchoolName = refinedSchoolName.substring(!isFind ? 0 : firstLocation+1); // 첫 글자부터 가장 마지막에 오는 특수문자, 한글 자음, 모음까지 제거
        refinedSchoolName = deletePrefixWord(refinedSchoolName); // 무의미한 단어 제거

        return refinedSchoolName;
    }

    /**
     * '고등학교', '중학교' 단어 뒤의 문자들을 제거하는 함수
     *
     * Comments
     * '고등학교', '중학교' 단어 뒤의 문자들을 제거한다.
     * */
    public static String deleteBackWord(String word) {
        int lastLocation = 0;

        if(word.contains(HIGH_SCHOOL)) {
            lastLocation = word.indexOf(HIGH_SCHOOL) + HIGH_SCHOOL.length();
        }else {
            lastLocation = word.indexOf(MIDDLE_SCHOOL) + MIDDLE_SCHOOL.length();
        }

        return word.substring(0, lastLocation);
    }

    /**
     * 자주 사용되는 무의미한 학교이름으로 추출 되는 단어들 제거하는 함수
     * */
    public static String deletePrefixWord(String word) {
        String[] prefixWords = {"진짜", "힘든", "우리", "저희"};

        for(String prefixWord : prefixWords){
            if(word.contains(prefixWord)) {
                word = word.replaceAll(prefixWord, "");
            }
        }

        return word;
    }

    /**
     * 더 큰 범위의 학교 이름을 찾는 함수
     *
     * Comments
     * 더 큰 범위의 학교 이름을 여러개 찾았다면 입력 받은 학교 이름을 반환한다.
     * 더 큰 범위의 학교 이름이 하나 뿐이라면 큰 범위의 학교 이름을 반환한다.
     * */
    public static String findSchoolName(Map<String, Integer> schoolInfo, String schoolName) {
        String findSchoolName = "";
        int findSchoolNameCount = 0;

        Iterator<Map.Entry<String, Integer>> schoolIterator = schoolInfo.entrySet().iterator();

        while(schoolIterator.hasNext()) {
            Map.Entry<String, Integer> schoolEntry = schoolIterator.next();

            String schoolInfoKey = schoolEntry.getKey();

            if(schoolInfoKey.contains(schoolName)) {
                findSchoolName = schoolInfoKey;
                findSchoolNameCount++;
            }
        }

        findSchoolName = (findSchoolName.equals("") || findSchoolNameCount > 1) ? schoolName : findSchoolName;

        return findSchoolName;
    }
}
