package algorithm.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

public class other_아기상어 {

    static int N;
    static int[][] shark;
    static int max = 0;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static class Node {
        int i;
        int j;
        int t;

        Node(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        shark = new int[N][N];

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                shark[i][j] = sc.nextInt();
                if (shark[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }

        dfs(x, y, 2, 0, 0);
        System.out.println(max);

    }

    private static void dfs(int x, int y, int size, int timer, int eat) {

        //여기서부터
        int gx = N - 1;
        int gy = N - 1;
        int g = N * N - 1;
        LinkedList<Node> q1 = new LinkedList<>();
        //bfs

        //PriorityQueue로 관리
        boolean visited1[][] = new boolean[N][N];
        visited1[x][y] = true;
        q1.add(new Node(x, y, 0));
        boolean ok = false;
        while (!q1.isEmpty()) {
            Node buf = q1.poll();
            for (int d = 0; d < 4; d++) {
                int r = buf.i + dr[d];
                int c = buf.j + dc[d];

                if (r < 0 || c < 0 || r >= N || c >= N || shark[r][c] > size)
                    continue;
                if (r == x && y == c)
                    continue;

                if (shark[r][c] != 0 && shark[r][c] < size) {
                    ok = true;
                    //g 최소거리
                    //buf.t => 현재 찾은 먹이가 존재한 거리
                    if (buf.t < g) {
                        gx = r;
                        gy = c;
                        g = buf.t;
                    } else if (buf.t == g) {
                        if (gx > r) {
                            gx = r;
                            gy = c;
                        } else if (gx == r && gy > c) {
                            gx = r;
                            gy = c;
                        }
                    }
                } else {
                    if (!visited1[r][c]) {
                        visited1[r][c] = true;
                        q1.add(new Node(r, c, buf.t + 1));
                    }
                }
            }
        }

        if (ok == false) {
            if (max < timer)
                max = timer;
            return;
        }

        //여기까지

        LinkedList<Node> q = new LinkedList<>();
        //bfs
        boolean visited[][] = new boolean[N][N];
        visited[x][y] = true;
        q.add(new Node(x, y, 0));
        while (!q.isEmpty()) {
            Node buf = q.poll();
            for (int d = 0; d < 4; d++) {
                int r = buf.i + dr[d];
                int c = buf.j + dc[d];

                if (r < 0 || c < 0 || r >= N || c >= N || shark[r][c] > size)
                    continue;
                if (r == x && y == c)
                    continue;

                if (r == gx && c == gy) {
                    shark[r][c] = 9;
                    shark[x][y] = 0;
                    System.out.println("size: " + size + " gxgy: " + gx + " " + gy + " time: " + timer + buf.t);
                    print(shark);
                    if (size == eat + 1) {
                        dfs(gx, gy, size + 1, timer + buf.t + 1, 0);
                    } else {
                        dfs(gx, gy, size, timer + buf.t + 1, eat + 1);
                    }

                    if (max < timer)
                        max = timer;

                    return;
                } else if (!visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Node(r, c, buf.t + 1));
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
