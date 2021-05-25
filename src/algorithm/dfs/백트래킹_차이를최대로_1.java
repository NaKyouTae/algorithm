package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6
//20 1 15 8 4 10

//https://www.acmicpc.net/problem/10819
public class 백트래킹_차이를최대로_1 {
    public static int max;
    public static int[] map, res;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n];
        res = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int idx) {
        if (idx == map.length) {
            int sum = 0;
            for (int i = 1; i < res.length; i++) {
                sum += Math.abs(res[i - 1] - res[i]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                res[idx] = map[i];
                dfs(idx + 1);
                visit[i] = false;
            }
        }
    }
}
