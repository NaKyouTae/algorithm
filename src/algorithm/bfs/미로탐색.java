package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//4 6
//101111
//101010
//101011
//111011


//https://www.acmicpc.net/problem/2178

public class 미로탐색 {
    public static class Node {
        int x, y, s;

        Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static int X, Y, cnt;
    public static int[][] arr, brr;
    public static boolean[][] visit;
    public static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        X = Integer.parseInt(str[0]);
        Y = Integer.parseInt(str[1]);

        arr = new int[X][Y];
        brr = new int[X][Y];
        visit = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < Y; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs();

        bw.write(Integer.toString(brr[X - 1][Y - 1]));
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        que.add(new Node(0, 0, 1));
        visit[0][0] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int xx = node.x + dx[i], yy = node.y + dy[i];
                if (xx < X && yy < Y && xx >= 0 && yy >= 0) {
                    if (!visit[xx][yy] && arr[xx][yy] == 1) {
                        visit[xx][yy] = true;
                        brr[xx][yy] = node.s + 1;
                        que.add(new Node(xx, yy, node.s + 1));
                    }
                }
            }
        }
    }
}
