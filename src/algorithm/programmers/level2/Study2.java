package algorithm.programmers.level2;

import java.util.Locale;

/**
 * JadenCase 첫 문자를 대문자로 출력하라
 * */
public class Study2 {

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(print(s));
    }
    public static String print(String s) {
        String[] srr = s.toLowerCase().split("");

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for(int i = 0; i < srr.length; i++) {
            String str = srr[i];
            if(str.equals(" ")) {
                sb.append(" ");
                isFirst = true;
                continue;
            }

            if(isFirst) {
                sb.append(str.toUpperCase());
                isFirst = false;
            }else {
                sb.append(str);
            }

        }
        return sb.toString();
    }
}

