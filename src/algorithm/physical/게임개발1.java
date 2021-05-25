package algorithm.physical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//4 4
//1 1 0
//1 1 1 1
//1 0 0 1
//1 1 0 1
//1 1 1 1

public class 게임개발1 {
    public static class Node {
        int x, y, d;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static int N, M, cnt = 1;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N][M];
        visit = new boolean[N][M];

        String[] location = br.readLine().split(" ");

        int x = Integer.parseInt(location[0]);
        int y = Integer.parseInt(location[1]);
        int d = Integer.parseInt(location[2]);


        que.add(new Node(x, y, d));
        visit[x][y] = true;
        System.out.println("first xx : " + x + ", yy : " + y + ", d : " + d);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        while (!que.isEmpty()) {
            Node node = que.poll();
            int isVisit = 0;
            for (int i = 0; i < 4; i++) {
                int idx = (node.d + i) % 4;
                int xx = node.x + dx[idx], yy = node.y + dy[idx];
                if (xx < N && yy < N & xx >= 0 && yy >= 0) {
                    if (!visit[xx][yy] && arr[xx][yy] != 1) {
                        visit[xx][yy] = true;
                        cnt++;
                        que.add(new Node(xx, yy, idx));
                        System.out.println("front xx : " + xx + ", yy : " + yy + ", d : " + idx);
                    } else {
                        isVisit++;
                    }
                }
            }

            if (isVisit == 4) {
                int idx = (node.d + 2) % 4;
                int xx = node.x + dx[idx];
                int yy = node.y + dy[idx];
                if (arr[xx][yy] != 1) {
                    System.out.println("back xx : " + xx + ", yy : " + yy + ", d : " + node.d);
                    que.add(new Node(xx, yy, node.d));
                } else {
                    break;
                }
            }

        }
    }
}
