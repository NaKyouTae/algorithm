package algorithm.study1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//9
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1

//https://www.acmicpc.net/problem/1780

public class 종이의개수 {
    public static int[][] map;
    public static int[] res = new int[3];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int v = -2;
        if ((v = check(0, 0, n - 1, n - 1)) != -2) {
            slice(0, 0, n - 1, n - 1);
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append("\n");
            }
        } else {
            sb.append((v == -1) ? 1 : 0).append("\n");
            sb.append((v == 0) ? 1 : 0).append("\n");
            sb.append((v == 1) ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int check(int sx, int sy, int ex, int ey) {
        int cnt = 0, status = -2;
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (map[i][j] != status) {
                    cnt++;
                    status = map[i][j];
                }
            }
        }

        if (cnt > 3) return status;
        else {
            return -2;
        }
    }

    public static void slice(int sx, int sy, int ex, int ey) {
        if (sx == sy && ex == ey && sx == ey && sy == ex) return;
        int v = -2;
        if ((v = check(sx / 3, sy / 3, ex / 3, ey / 3)) == -2) {
            int idx = (v == -2) ? 2 : v;
            res[idx] += 1;
        } else {
            for (int i = sx; i < ex; i++) {
                for (int j = sy; j < ey; j++) {
                    int idx = (map[i][j] == -1) ? 2 : map[i][j];
                    res[idx] += 1;
                    slice(sx / 3, sy / 3, ex / 3, ey / 3);
                }
            }
        }
    }
}
