package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4
//5 45
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25
//5 -45
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25
//5 135
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25
//5 360
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20
//21 22 23 24 25

//https://www.acmicpc.net/problem/17276
public class 배열돌리기_실패 {
    public static int N, C;
    public static int[][] map, res;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");

            N = Integer.parseInt(str[0]);
            C = Integer.parseInt(str[1]);

            map = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[i][j] = val;
                }
            }

            if (C % 360 != 0) {
                for (int i = 0; i < C / 45; i++) {
                    move(C / 45);
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void move(int c) {
        if (c > 0) {

            int[] dx = {0, -1, 0, 1};
            int[] dy = {1, 0, -1, 0};
            for (int k = 0; k < 2; k++) {
                for (int i = 1; i <= N / 2; i++) {

                    int x = i;
                    int y = i;
                    int temp = map[x][y];

                    int idx = 0;

                    while (idx < 4) {
                        int xx = x + dx[idx], yy = y + dy[idx];
                        if (xx < i || yy < i || xx > N - i + 1 || yy > N - i + 1) {
                            idx++;
                        } else {
                            map[x][y] = map[xx][yy];
                            x = xx;
                            y = yy;
                        }
                    }
                    map[i + 1][i] = temp;
                }
            }

        } else {
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            for (int k = 0; k < 2; k++) {
                for (int i = 1; i <= N / 2; i++) {

                    int x = i;
                    int y = i;
                    int temp = map[x][y];

                    int idx = 0;

                    while (idx < 4) {
                        int xx = x + dx[idx], yy = y + dy[idx];
                        if (xx < i || yy < i || xx > N - i + 1 || yy > N - i + 1) {
                            idx++;
                        } else {
                            map[x][y] = map[xx][yy];
                            x = xx;
                            y = yy;
                        }
                    }
                    map[i + 1][i] = temp;
                }
            }
        }
    }
}
