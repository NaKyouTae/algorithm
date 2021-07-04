package algorithm.studyGroup.study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0
//1
//3
//2

//https://www.acmicpc.net/problem/4779

public class 칸토어집합_1 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while (!(str = br.readLine()).equals("")) {
            int n = Integer.parseInt(str);

            if (n == 0) {
                sb.append("-").append("\n");
            } else {
                int pow = (int) Math.pow(3, n);
                print(pow);

                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void print(int n) {
        if (n == 1) {
            sb.append("-");
            return;
        }

        print(n / 3);
        space(n / 3);
        print(n / 3);
    }

    public static void space(int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }
}
