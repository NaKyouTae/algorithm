package algorithm.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class DFS_모래성쌓기_ing {
    public static String[][] arr;
    public static int[][] brr;
    public static boolean[][] visit;
    public static int h, w, sum;

    @Test
    public void test() throws IOException {
        run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int e = Integer.parseInt(br.readLine());

        for (int p = 0; p < e; p++) {
            String[] str = br.readLine().split(" ");
            h = Integer.parseInt(str[0]);
            w = Integer.parseInt(str[1]);

            arr = new String[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String st = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = String.valueOf(st.charAt(j));
                }
            }

            int cnt = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    String val = arr[i][j];
                    if (!val.equals("9") && !val.equals(".")) {
                        brr = new int[h][w];
                        DFS(i, j);
                        cnt++;

                        for (int a = 0; a < h; a++) {
                            for (int b = 0; b < w; b++) {
                                if (!arr[a][b].equals(".") && !arr[a][b].equals("9")) {
                                    if (Integer.parseInt(arr[a][b]) <= brr[a][b]) {
                                        arr[a][b] = ".";
                                    }
                                }
                            }
                        }
                    }
                }
            }

            sb.append("#").append(p + 1).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    public static void DFS(int x, int y) {
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int i = 0; i < 8; i++) {
            int xx = dx[i] + x, yy = dy[i] + y;
            if (xx < h && yy < w && xx >= 0 && yy >= 0) {
                String val = arr[xx][yy];

                if (h == 5 && w == 6 && x == 2 && y == 3) {
                    if (brr[x][y] == 0) {
                        System.out.println();
                    }
                    System.out.println(" 점수 : " + brr[x][y] + " 아이템 : " + arr[xx][yy] + " xx : " + xx + " yy : " + yy);
                }

                if (val.equals(".")) {
                    brr[x][y] = brr[x][y] + 1;
                }

                if (!val.equals(".") && !val.equals("9")) {
                    if (!visit[xx][yy]) {
                        visit[xx][yy] = true;
                        DFS(xx, yy);
                    }
                }

            }
        }
    }
}
