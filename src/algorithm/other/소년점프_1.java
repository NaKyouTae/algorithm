package algorithm.other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 소년점프_1 {
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
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] map = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String st = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j + 1] = st.charAt(j) - '0';
            }
        }
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        Queue<Node> q3 = new LinkedList<>();
        boolean[][] ck1 = new boolean[R + 1][C + 1];
        boolean[][] ck2 = new boolean[R + 1][C + 1];
        boolean[][] ck3 = new boolean[R + 1][C + 1];
        int a = sc.nextInt();
        int b = sc.nextInt();
        q1.add(new Node(a, b));
        ck1[a][b] = true;
        a = sc.nextInt();
        b = sc.nextInt();
        q2.add(new Node(a, b));
        ck2[a][b] = true;
        a = sc.nextInt();
        b = sc.nextInt();
        q3.add(new Node(a, b));
        ck3[a][b] = true;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        int cnt = 0;
        while (!q1.isEmpty() && !q2.isEmpty() && !q3.isEmpty()) {
            cnt++;
            int s1 = q1.size();
            int s2 = q2.size();
            int s3 = q3.size();
            for (int i = 0; i < s1; i++) {
                Node b1 = q1.poll();
                for (int d = 0; d < 4; d++) {
                    int r1 = b1.r + dr[d];
                    int c1 = b1.c + dc[d];
                    if (r1 <= 0 || c1 <= 0 || r1 > R || c1 > C || map[r1][c1] == 1 || ck1[r1][c1]) {
                    } else {
                        q1.add(new Node(r1, c1));
                        ck1[r1][c1] = true;
                    }
                }
            }
            for (int i = 0; i < s2; i++) {
                Node b2 = q2.poll();
                for (int d = 0; d < 4; d++) {
                    int r2 = b2.r + dr[d];
                    int c2 = b2.c + dc[d];
                    if (r2 <= 0 || c2 <= 0 || r2 > R || c2 > C || map[r2][c2] == 1 || ck2[r2][c2]) {
                    } else {
                        ck2[r2][c2] = true;
                        q2.add(new Node(r2, c2));
                    }
                }
            }
            for (int i = 0; i < s3; i++) {
                Node b3 = q3.poll();
                for (int d = 0; d < 4; d++) {
                    int r3 = b3.r + dr[d];
                    int c3 = b3.c + dc[d];
                    if (r3 <= 0 || c3 <= 0 || r3 > R || c3 > C || map[r3][c3] == 1 || ck3[r3][c3]) {
                    } else {
                        ck3[r3][c3] = true;
                        q3.add(new Node(r3, c3));
                    }
                }
            }
            int rs = 0;
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (ck1[i][j] && ck2[i][j] && ck3[i][j]) {
                        rs++;
                    }
                }
            }
            if (rs != 0) {
                System.out.println(cnt);
                System.out.println(rs);
                return;
            }
        }
        System.out.println(-1);
    }

}
