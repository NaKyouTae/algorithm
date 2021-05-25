package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//2
//3
//911
//97625999
//91125426
//5
//113
//12340
//123440
//12345
//98346

//https://www.acmicpc.net/problem/5052
public class 전화번호목록_1 {
    public static Comparator<String> compare = new Comparator<>() {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int e = 0; e < T; e++) {
            int c = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();

            for (int i = 0; i < c; i++) {
                list.add(br.readLine());
            }

            Collections.sort(list, compare);
            boolean is = false;
            for (int i = 1; i < c; i++) {
                if (list.get(i).startsWith(list.get(i - 1))) {
                    is = true;
                    break;
                }
            }

            System.out.println((is == true) ? "NO" : "YES");
        }
    }
}
