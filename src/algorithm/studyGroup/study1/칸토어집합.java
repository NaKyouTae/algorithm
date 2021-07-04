package algorithm.studyGroup.study1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0
//1
//3
//2

//https://www.acmicpc.net/problem/4779

public class 칸토어집합 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";


        while (!(str = br.readLine()).equals("")) {
            int n = Integer.parseInt(str);
            if (n == 0) {
                System.out.println("-");
            } else {
                int len = (int) Math.pow(3, n);

                move(len);

                sb.append("\n");
            }

        }

        System.out.println(sb.toString());
    }

    public static void move(int s) {
        if (s == 1) {
            sb.append("-");
            return;
        }

        move(s / 3);
        delete(s / 3);
        move(s / 3);
    }

    public static void delete(int s) {
        for (int i = 0; i < s; i++) {
            sb.append(" ");
        }
    }
}
