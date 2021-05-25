package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//3 1

//https://www.acmicpc.net/problem/15649
public class N과M1 {
    public static int N, L;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);

        arr = new int[N];
        visit = new boolean[N];

        dfs(0);

        System.out.println(sb.toString());
    }


    public static void dfs(int idx) {
        if (idx == L) {
            for (int a : arr) {
                if (a != 0) sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visit[j]) {
                visit[j] = true;
                arr[idx] = j + 1;
                dfs(idx + 1);
                visit[j] = false;
            }
        }
    }
}
