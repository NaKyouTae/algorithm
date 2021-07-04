package algorithm.test.naverWebtoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문자열의 짝 찾기 s1 = s5, s2 = s4, s3
 */

public class Test2 {
    public static void main(String[] args) {
//        String s = "abcxyasdfasdfxyabc";
//        String s = "abcxyqwertyxyabc";
//        String s = "llttaattll";
        String s = "abcdef";
        String[] str = solution(s);

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

    public static String[] solution(String s) {
        List<String> str = new ArrayList<>();

        int start = 0;
        int end = s.length();
        boolean isEqual = false;
        String st = "", en = "";

        for (int i = 1; i <= s.length()/2; i++) {
            isEqual = false;
            st = s.substring(start, i);
            int es = s.length() - i;
            en = s.substring(es, end);

            if(st.equals(en)) {
                str.add(st);
                start = i;
                end = s.length() - i;
                isEqual = true;
            }
        }

        if(!isEqual) {
            str.add(st+en);
        }

        if(str.size() > 1){

            List<String> reverse = new ArrayList<>(str);
            Collections.reverse(reverse);

            if(!isEqual) {
                reverse.remove(0);
            }

            str.addAll(reverse);
        }


        String[] res = str.toArray(new String[str.size()]);
        return res;
    }
}
