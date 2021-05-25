package algorithm.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//baekjoon

//https://www.acmicpc.net/problem/11656

public class 점미사배열 {
    public static Comparator<String> compare = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i, str.length()));
        }

        Collections.sort(list, compare);

        for (String s : list) System.out.println(s);
    }
}
