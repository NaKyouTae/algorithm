package algorithm.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.Test;

public class DFS_연구소 {
    public static int[][] arr;
    public static int[][] brr;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int x, y, max;

    @Test
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);

        arr = new int[x][y];
        brr = new int[x][y];

        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

    public static void DFS(int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    brr[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (brr[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }

            countZero();
        } else {
            // 빽트래킹
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 1;
                        cnt++;
                        DFS(cnt);
                        arr[i][j] = 0;
                        cnt--;
                    }
                }
            }
        }
    }

    // DFS
    public static void virus(int h, int w) {
        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + h, yy = dy[i] + w;
            if (xx < x && yy < y && xx >= 0 && yy >= 0) {
                if (brr[xx][yy] == 0) {
                    brr[xx][yy] = 2;
                    virus(xx, yy);
                }
            }
        }
    }

    public static void countZero() {
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (brr[i][j] == 0) cnt++;
            }
        }
        if (cnt > max) max = cnt;
    }
}
