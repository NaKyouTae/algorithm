package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//5 5
//00011
//01011
//00110
//00001
//10100
//1 1
//5 5
//5 2

//https://www.acmicpc.net/problem/16469
public class 소년점프 {
    public static class Node {
        int x, y, s;

        Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static int X, Y;
    public static int[][] arr, brr, crr, map, res;
    public static boolean[][] visit;
    public static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");

        X = Integer.parseInt(str[0]);
        Y = Integer.parseInt(str[1]);

        arr = new int[X][Y];
        brr = new int[X][Y];
        crr = new int[X][Y];
        map = new int[X][Y];
        res = new int[X][Y];
        visit = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String s = br.readLine();
            for (int j = 0; j < Y; j++) {
                int val = Integer.parseInt(String.valueOf(s.charAt(j)));
                if (val == 1) {
                    // 넉살 이동 배열
                    arr[i][j] = -1;
                    // 스윙 이동 배열
                    brr[i][j] = -1;
                    // 창모 이동 배열
                    crr[i][j] = -1;
                    // 3명의 악당 방문 기록 배열
                    map[i][j] = -1;
                    // 3명의 악당이 모두 한 곳에 방문할 수 있는 시간 배열
                    res[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            String[] f = br.readLine().split(" ");
            int r = Integer.parseInt(f[0]) - 1;
            int c = Integer.parseInt(f[1]) - 1;
            search(i, r, c);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                // res[i][j] != -1 >>>> 벽으로 막혀있지 않는 곳
                // map[i][j] == 3 >>>> 악당 3명 모두 방문한 곳
                if (res[i][j] != -1 && map[i][j] == 3) {
                    // 3명이 한 곳에 다 모이기 위해서는 i,j 위치에 가장 늦게 도착한 악당 기준으로 시간을 체크해야한다.
                    res[i][j] = Math.max(Math.max(arr[i][j], brr[i][j]), crr[i][j]);
                    if (res[i][j] < min) min = res[i][j];
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            int cnt = 0;
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (res[i][j] == min) cnt++;
                }
            }

            sb.append(min).append("\n");
            sb.append(cnt);
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void search(int o, int x, int y) {
        que.add(new Node(x, y, 1));
        visit[x][y] = true;
        map[x][y] += 1;
        bfs(o);
        clear();
    }

    // 각 악당의 방문 여부 배열과 방문할 수 있는 Queue 초기화
    public static void clear() {
        visit = new boolean[X][Y];
        que.clear();
    }

    public static void bfs(int o) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int xx = node.x + dx[i], yy = node.y + dy[i];
                if (xx < X && yy < Y && xx >= 0 && yy >= 0) {
                    if (!visit[xx][yy] && res[xx][yy] != -1) {
                        visit[xx][yy] = true;
                        // 악당의 방문 횟수 추가
                        map[xx][yy] += 1;

                        // 넉살
                        if (o == 0) arr[xx][yy] += node.s;
                        // 스윙스
                        if (o == 1) brr[xx][yy] += node.s;
                        // 창모
                        if (o == 2) crr[xx][yy] += node.s;

                        que.add(new Node(xx, yy, node.s + 1));
                    }
                }
            }
        }
    }
}