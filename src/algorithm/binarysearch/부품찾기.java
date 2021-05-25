package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부품찾기 {

    public static int N, M;
    public static String[] S, F;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 보유 물건 목록
        N = Integer.parseInt(br.readLine());
        S = br.readLine().split(" ");
        // 찾는 물건 목록
        M = Integer.parseInt(br.readLine());
        F = br.readLine().split(" ");


        for (int i = 0; i < M; i++) {
            int f = Integer.parseInt(F[i]);
            research(f);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void research(int target) {
        int left = 0;
        int right = N - 1;
        boolean isFind = false;

        while (left <= right) {
            int center = (left + right) / 2;
            int val = Integer.parseInt(S[center]);

            if (val == target) {
                isFind = true;
                break;
            } else if (val > target) {
                right = center - 1;
            } else if (val < target) {
                left = center + 1;
            }
        }

        if (isFind) sb.append("yes").append(" ");
        else sb.append("no").append(" ");
    }

}
//5
//8 3 7 9 2
//3
//5 7 9
