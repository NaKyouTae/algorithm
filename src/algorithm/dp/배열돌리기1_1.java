package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4 4 2
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16

//3 4 8 12
//2 11 10 16
//1 7 6 15
//5 9 13 14

//https://www.acmicpc.net/problem/16926

public class 배열돌리기1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int t = Integer.parseInt(str[2]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(n, m);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int z = 0; z < t; z++) {
            for (int i = 0; i < min / 2; i++) {
                int x = i;
                int y = i;
                int temp = map[x][y];
                int idx = 0;

                while (idx < 4) {
                    int xx = x + dx[idx], yy = y + dy[idx];

                    if (xx < i || yy < i || xx > n - i - 1 || yy > m - i - 1) {
                        idx++;
                    } else {
                        map[x][y] = map[xx][yy];
                        x = xx;
                        y = yy;
                    }
                }
                map[x + 1][y] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
