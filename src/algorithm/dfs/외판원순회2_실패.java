package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//4
//0 10 15 20
//5 0 9 10
//6 13 0 12
//8 8 9 0

//35

//https://www.acmicpc.net/problem/10971
public class 외판원순회2_실패 {
    public static int min = Integer.MAX_VALUE;
    public static int[] res;
    public static int[][] arr;
    public static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        res = new int[n];
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int idx) {
        if (idx == arr.length) {
            int sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum += res[i];
            }
            System.out.println(Arrays.toString(res) + " = " + sum);
            min = Math.min(min, sum);
            return;
        }

        int cnt = 0;
        for (int j = 0; j < arr.length; j++) {
            if (cnt != arr.length - 2 && j == 0) continue;
            if (!visit[idx][j] && idx != j) {
                visit[idx][j] = true;
                cnt++;
                res[idx] = arr[idx][j];
                dfs(idx + 1);
                visit[idx][j] = false;
                cnt--;
            }
        }
    }
}
