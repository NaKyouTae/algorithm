package algorithm.study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//5
//        ABCD
//        145C
//        A
//        A910
//        Z321

//https://www.acmicpc.net/problem/1431

public class SerialNumber {
    public static List<String> list = new ArrayList<>();
    public static Comparator<String> compare = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {

            if(o1.length() == o2.length()) {
                int a_sum = 0;
                int b_sum = 0;
                for(int i = 0; i < o1.length(); i++) {
                    int c1 = o1.charAt(i) - '0';
                    int c2 = o2.charAt(i) - '0';
                    if(c1 >= 1 && c1 <= 9) a_sum += c1;

                    if(c2 >= 1 && c2 <= 9) b_sum += c2;
                }

                if(a_sum == b_sum) {
                    for(int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) > o2.charAt(i)){
                            return 1;
                        }else if(o1.charAt(i) <o2.charAt(i)) {
                            return -1;
                        }
                    }
                }

                return a_sum - b_sum;
            }

            return o1.length() - o2.length();
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, compare);

        StringBuilder sb = new StringBuilder();
        list.forEach((item) -> {
            sb.append(item).append("\n");
        });

        System.out.println(sb.toString());
    }
}
