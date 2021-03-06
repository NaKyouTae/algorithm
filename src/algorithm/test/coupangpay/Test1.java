package algorithm.test.coupangpay;

import java.util.*;

public class Test1 {
//    어느 대학에서 일정 기준을 만족하는 일반 동아리를 중앙 동아리로 변경해주려 합니다. 그 기준은 다음과 같습니다.
//
//            2개 이상의 동아리에 소속된 학생을 제외하고 동아리 인원수가 n명 이상이어야 합니다.
//            즉, 여러 동아리에 속한 사람을 제외하고, 해당 동아리에만 속한 학생 수가 n명 이상이어야 합니다.
//    동아리원의 입학 연도(학번의 앞 두 자리) 종류가 m개 이상이어야 합니다.
//    마찬가지로, 2개 이상의 동아리에 소속된 학생은 제외하고 셉니다.
//    동아리원의 학과 종류가 k개 이상이어야 합니다.
//    마찬가지로, 2개 이상의 동아리에 소속된 학생은 제외하고 셉니다.
//    다음은 중앙동아리 변경 기준 n, m, k가 각각 인원수 n = 4, 입학 연도 수 m = 3, 학과 수 k = 3으로 가정한 예시입니다. 아래 표는 동아리에 가입된 학생들의 정보를 나타냅니다.
//
//    학번	학과	동아리
//13123820	BusinessManagement	AAA
//15047648	Economics	AAA
//17869244	ComputerScience	AAA
//19000000	ElectronicEngineering	AAA
//14281264	Law	AAA
//19000000	ElectronicEngineering	BBB
//16188768	BusinessManagement	BBB
//14634411	ElectronicEngineering	BBB
//16628760	Economics	BBB
//14863606	BusinessManagement	CCC
//13165700	Law	CCC
//15215218	ComputerScience	CCC
//    동아리 AAA의 경우 학번이 19000000인 학생은 동아리 BBB에도 속해 있으므로 제외하면 동아리 인원수는 총 4명입니다. 입학 연도의 경우 19000000 학번을 제외한 나머지 학번의 입학 연도가 13, 14, 15, 17년으로 총 4개입니다. 학과의 경우 1900000 학번을 제외한 나머지 학생들의 학과가 총 4종류이며, 인원수(4명), 입학 연도 수(4가지), 학과 수(4가지)로 모두 기준을 만족하므로 중앙동아리로 변경될 수 있습니다.
//
//    동아리 BBB의 경우 학번이 19000000인 학생은 동아리 BBB에도 속해 있으므로 제외하면 동아리 인원수는 총 3명입니다. 입학 연도의 경우 19000000 학번을 제외한 나머지 학번의 입학 연도가 14, 16년으로 총 2개입니다. 학과의 경우 19000000 학번을 제외한 나머지 학생들의 학과가 3종류이며, 인원수(3명), 입학 연도 수(2가지)가 기준을 만족하지 못합니다.
//
//    동아리 CCC의 경우 입학 연도 수와 학과 수가 모두 3이지만, 인원수가 3명으로 기준 인원수 4보다 작기 때문에 중앙동아리 기준을 만족하지 못합니다.
//
//    동아리에 가입되어 있는 모든 학생의 학번, 학과, 속한 동아리를 나타내는 문자열 배열 students와 최소 인원수 n, 최소 입학 연도 수 m, 최소 학과 수 k가 매개변수로 주어집니다. 중앙동아리가 될 수 있는 조건을 갖춘 동아리의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//    제한사항
//    students의 길이는 1 이상 100,000 이하입니다.
//    students의 원소는 "학번 학과 동아리" 형식의 문자열입니다.
//    학번은 길이가 8인 문자열입니다.
//    학번은 숫자로 이루어져 있습니다
//    학번에서 앞의 두 자리의 숫자는 입학 연도를 나타냅니다.
//    학과는 길이가 1 이상 30 이하인 문자열입니다.
//    학과는 알파벳 소문자 또는 대문자로 이루어져 있습니다.
//    학과는 대소문자를 구분합니다. 예를 들어 AbC와 Abc는 서로 다른 학과입니다
//    동아리는 길이가 3인 문자열입니다.
//    동아리는 알파벳 대문자로 이루어져 있습니다.
//    같은 원소가 중복되어 주어지지 않습니다.
//    모든 단어들은 공백(하나)으로 구분되어 있습니다.
//    학생 한 명은 하나의 학번과 하나의 학과를 갖습니다.
//    학번은 학생을 유일하게 인식할 수 있는 번호입니다.
//    학생 한 명이 2개 이상의 동아리에 속할 수 있습니다.
//    n은 1 이상 30 이하인 자연수입니다.
//    m은 1 이상 8 이하인 자연수입니다.
//    k는 1 이상 8 이하인 자연수입니다.
//    입출력 예
//    students	n	m	k	result
//["13123820 BusinessManagement AAA", "15047648 Economics AAA", "17869244 ComputerScience AAA", "19000000 ElectronicEngineering AAA", "14281264 Law AAA", "19000000 ElectronicEngineering BBB", "16188768 BusinessManagement BBB", "14634411 Law BBB", "16628760 Economics BBB", "14863606 BusinessManagement CCC", "13165700 Law CCC", "15215218 ComputerScience CCC"]	4	3	3	1
//    입출력 예 설명
//    입출력 예 #1
//
//    문제 예시와 같습니다.

//    "13123820 BusinessManagement AAA",
//    "15047648 Economics AAA",
//    "17869244 ComputerScience AAA",
//    "19000000 ElectronicEngineering AAA",
//    "14281264 Law AAA",
//    "19000000 ElectronicEngineering BBB",
//    "16188768 BusinessManagement BBB",
//    "14634411 Law BBB",
//    "16628760 Economics BBB",
//    "14863606 BusinessManagement CCC",
//    "13165700 Law CCC",
//    "15215218 ComputerScience CCC"

    public static class Club {
        private String club;
        private Set<String> department;
        private Set<String> students;

        Club(String club, Set<String> department, Set<String> students) {
            this.club = club;
            this.department = department;
            this.students = students;
        }
    }
    public static void main(String[] args) {
        String[] students = {"13123820 BusinessManagement AAA", "15047648 Economics AAA", "17869244 ComputerScience AAA", "19000000 ElectronicEngineering AAA", "14281264 Law AAA", "19000000 ElectronicEngineering BBB", "16188768 BusinessManagement BBB", "14634411 Law BBB", "16628760 Economics BBB", "14863606 BusinessManagement CCC", "13165700 Law CCC", "15215218 ComputerScience CCC"};

        int n = 4;
        int m = 3;
        int k = 3;

        int cnt = 0; // 중앙 동아리로 승급할 동아리 개수

        Map<String, String> clubMap = new HashMap<>(); // 학생의 동아리
        Map<String, String> departmentMap = new HashMap<>(); // 학생의 학과
        Map<String, Integer> studentMap = new HashMap<>(); // 학생

        Set<String> clubSet = new HashSet<>(); // 중복제거 된 동아리

        // 학생을 기준으로 동아리, 학과 정보 추출
        // 동아리를 여러개 가입한 학생들은 제거
        for (int i = 0; i < students.length; i++) {
            String[] studentInfo = students[i].split(" ");

            String id = studentInfo[0];
            String department = studentInfo[1];
            String club = studentInfo[2];

            if(studentMap.containsKey(id)) {
                studentMap.put(id, studentMap.get(id) + 1);
            }else {
                studentMap.put(id, 1);
            }

            clubMap.put(id, club);
            departmentMap.put(id, department);

            clubSet.add(club);
        }


        Iterator<String> clubIter = clubSet.iterator();

        while(clubIter.hasNext()){
            String club = clubIter.next();

            Set<String> departmentSet = new HashSet<>();
            Set<String> yearSet = new HashSet<>();

            int dupStudentCount = 0; // 클럽에 속해 있는 학과의 수

            Iterator<Map.Entry<String, Integer>> studentIter = studentMap.entrySet().iterator();

            while(studentIter.hasNext()){
                Map.Entry<String, Integer> student = studentIter.next();

                if(student.getValue() > 1) continue;

                String studentClub = clubMap.get(student.getKey());

                if(club.equals(studentClub)) {
                    dupStudentCount++;
                    departmentSet.add(departmentMap.get(student.getKey()));
                    yearSet.add(student.getKey().substring(0, 2));
                }
            }

            int dupYearCount = yearSet.size(); // 클럽에 속해 있는 학생의 년도 종류의 수
            int dupDepartmentCount = departmentSet.size(); // 클럽에 속해 있는 학과의 수

            if(dupStudentCount >= n && dupYearCount >= m && dupDepartmentCount >= k) cnt++;
        }

        System.out.println(cnt);
    }
}
