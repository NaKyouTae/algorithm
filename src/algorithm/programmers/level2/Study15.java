package algorithm.programmers.level2;

import java.util.*;

public class Study15 {
    public static class Node {
        int x, y;
        Node(int x, int  y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean[][] visit;
    private static int cnt, X, Y;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};
//        [4, 5]

        X = m;
        Y = n;
        visit = new boolean[m][n];
        int max = Integer.MIN_VALUE;
        int type = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j] || picture[i][j] == 0) continue;
                cnt = 1;
                type++;
                bfs(picture, i, j);
                max = Math.max(max, cnt);
            }
        }

        int[] answer = new int[2];

        answer[0] = type;
        answer[1] = max;

        System.out.println(type + " " + max);
    }

    public static void bfs(int[][] pic, int i, int j) {
        visit[i][j] = true;
        que.add(new Node(i, j));
        int source = pic[i][j];

        while(!que.isEmpty()) {
            Node node = que.poll();

            for(int k = 0; k < 4; k++) {
                int xx = node.x + dx[k], yy = node.y + dy[k];
                if(xx < X && yy < Y && xx >= 0 && yy >= 0) {
                    int target = pic[xx][yy];
                    if(!visit[xx][yy] && source == target) {
                        visit[xx][yy] = true;
                        que.add(new Node(xx, yy));
                        cnt++;
                    }
                }
            }
        }
    }
}
