package algorithm.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//4 8 4
//1 8
//4 5
//6 20
//9 12

//380

//https://www.acmicpc.net/problem/17224
public class APC1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int l = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        int easy = 0, hard = 0;
        for (int i = 0; i < n; i++) {
            String[] q = br.readLine().split(" ");
            int sub1 = Integer.parseInt(q[0]);
            int sub2 = Integer.parseInt(q[1]);

            if (sub2 <= l) {
                hard++;
            } else if (sub1 <= l) {
                easy++;
            }
        }

        if (hard > k) {
            System.out.println(k * 140);
        } else {
            System.out.println(hard * 140 + Math.min(k - hard, easy) * 100);
        }
    }
}
