package algorithm.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.Test;

public class DFS_회장뽑기 {

    public static int[][] arr;
    public static int[][] brr;
    public static boolean[] visit;
    public static int n;


    @Test
    public void test() throws IOException {
        run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        brr = new int[n][n];
        visit = new boolean[n];
        Integer[] res = new Integer[n];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == -1 && y == -1) break;
            brr[x - 1][y - 1] = 1;
            brr[y - 1][x - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            DFS(i, i, 0);
            Arrays.sort(arr[i]);
            res[i] = arr[i][arr[i].length - 1];
        }

        List<Integer> list = Arrays.asList(res).stream().sorted().collect(Collectors.toList());

        int min = list.get(0);
        long cnt = list.stream().filter(item -> item == min).count();

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(cnt).append("\n");
        for (int i = 0; i < res.length; i++) {
            if (min == res[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public void DFS(int st, int idx, int cnt) {
        arr[st][idx] = cnt;
        visit[idx] = true;

        for (int i = 0; i < n; i++) {
            if (brr[idx][i] == 1) {
                if (!visit[i] || cnt < arr[st][i]) {
                    DFS(st, i, cnt + 1);
                    System.out.print("st : " + st + " cnt : " + cnt + " i : " + (i + 1));
                }
            }
        }
        System.out.println();
    }
}
