package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

//11 2 1 4 3 
//6 12 7 8 10 
//21 17 13 9 5 
//16 18 19 14 20 
//23 22 25 24 15 
//3 2 5 4 15 
//6 8 9 14 10 
//1 7 13 19 25 
//16 12 17 18 20 
//11 22 21 24 23 
//23 2 21 4 11 
//6 18 17 12 10 
//25 19 13 7 1 
//16 14 9 8 20 
//15 22 5 24 3 
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15 
//16 17 18 19 20
//21 22 23 24 25

//https://www.acmicpc.net/problem/17276

public class 배열돌리기_1 {
    public static int N;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++) {
            String[] str = br.readLine().split(" ");

            N = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (c % 360 != 0) {
                move(c / 45);
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j] <= 9 ? "0" + map[i][j] : map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }

    public static void move(int c) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int p = N / 2;

        if (c < 0) c += 8;

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < N / 2; j++) {
                int x = j;
                int y = j;
                int idx = 0;
                int temp = map[x][y];

                while (idx < 4) {
                    int mx = dx[idx] * (p - j);
                    int my = dy[idx] * (p - j);
                    int xx = x + mx, yy = y + my;

                    if (xx < j || yy < j || xx > N - j - 1 || yy > N - j - 1) {
                        idx++;
                    } else {
                        map[x][y] = map[xx][yy];
                        x = xx;
                        y = yy;
                    }
                }
                map[x][y + (p - j)] = temp;
            }
        }
    }
}
