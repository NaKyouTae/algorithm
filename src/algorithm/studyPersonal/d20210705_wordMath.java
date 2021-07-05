package algorithm.studyPersonal;

//https://www.acmicpc.net/problem/1339

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class d20210705_wordMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ap = new int[26];

        for(int i = 0; i < n; i++) {
            char[] str = sc.next().toCharArray();

            for (int j = 0; j < str.length; j++) {
                int pow = (int) Math.pow(10, str.length - j - 1);
                char c = str[j];
                int s = str[j] - 'A';
                if(ap[s] != 0){
                    ap[s] += pow;
                }else {
                    ap[s] = pow;
                }
            }
        }

        int sum = 0;

        // 0 제거 후 내림차순으로 정렬
        List<Integer> list = Arrays.stream(ap).boxed().filter((item) -> item != 0).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i) * (9 - i);
        }

        System.out.println(sum);
    }
}
