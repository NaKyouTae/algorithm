package algorithm.other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class other_BFS_음료수얼려먹기 {
    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean[][] check = new boolean[N][M];
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !check[i][j]) {
                    cnt++;
                    //

                    check[i][j] = true;
                    Queue<Node> q = new LinkedList<>();

                    q.add(new Node(i, j));

                    while (!q.isEmpty()) {
                        Node buf = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int r = buf.r + dr[d];
                            int c = buf.c + dc[d];

                            if (r < 0 || c < 0 || r >= N || c >= M)
                                continue;

                            if (map[r][c] == 0 && !check[r][c]) {
                                check[r][c] = true;
                                q.add(new Node(r, c));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
