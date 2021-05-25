package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//3 5
//3 4 5
//2 3 9
//3 9 3
//4 5 1
//1 3 6

// 33
public class 문6_팝스토어_실패 {
    public static int N, M, ans = Integer.MIN_VALUE;
    public static int[][] map;
    public static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        move(0, 0);
        visit[0][0] = true;

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static void move(int x, int y) {

        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int j2 = 0; j2 < 2; j2++) {
                    int xx = i + dx[j2], yy = j + dy[j2];
                    if (xx < N && yy < M && xx >= 0 && yy >= 0) {
                        if (!visit[xx][yy]) {
                            visit[xx][yy] = true;
                            cnt += map[xx][yy];
                            move(xx, yy);
                            visit[xx][yy] = false;
                            cnt -= map[xx][yy];
                        }
                    }
                }
            }
        }

        ans = Math.max(ans, cnt);
    }
}
