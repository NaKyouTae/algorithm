package algorithm.physical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 문자열재정렬 {
    public static Comparator<String> compare = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return (s1.charAt(0) == s2.charAt(0)) ? 0 : (s1.charAt(0) > s2.charAt(0)) ? 1 : -1;

        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        List<String> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9') {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            } else {
                list.add(String.valueOf(str.charAt(i)));
            }
        }

        Collections.sort(list, compare);

        String result = "";
        for (String l : list) {
            result += l;
        }
        result += Integer.toString(sum);

        System.out.println(result);
    }
}
