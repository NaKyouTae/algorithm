package algorithm.studyPersonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//2
//10
//15

//20

//https://www.acmicpc.net/problem/2217
public class d20210701_rope {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int r = Integer.parseInt(br.readLine());
            list.add(r);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int r = list.get(i);

            max = Math.max(max, r * (list.size() - i));
        }

        System.out.println(max);
    }
}
