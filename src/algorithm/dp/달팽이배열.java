package algorithm.dp;

import java.util.Scanner;

//7
//35

//https://www.acmicpc.net/problem/1913

public class 달팽이배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[][] map = new int[n][n];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = n * n;

        for (int i = 0; i <= n / 2; i++) {
            int x = i;
            int y = i;
            int idx = 0;

            // 사방 탐색이 시작위치보다 한 칸더 앞서 있기 때문에 시작 위치의 값 삽입
            map[i][i] = cnt--;

            while (idx < 4) {

                int xx = x + dx[idx], yy = y + dy[idx];

                // 정사각형의 외각에 도달했다면 방향 전환
                if (xx >= n || yy >= n || xx < 0 || yy < 0) {
                    idx++;
                    // 이미 값이 채워져 있다면 방향 전환
                } else if (map[xx][yy] != 0) {
                    idx++;
                } else {
                    map[xx][yy] = cnt--;
                    x = xx;
                    y = yy;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = map[i][j];
                if (map[i][j] == t) {
                    x = i;
                    y = j;
                }
                // IDE에서 디버깅시 한눈에 보기 위한 formatting
                sb.append(String.valueOf(val).length() == 1 ? "0" + val : val).append(" ");
//                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        sb.append(x + 1).append(" ").append(y + 1);

        System.out.println(sb.toString());
    }
}
