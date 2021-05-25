package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//4 4
//3 0 1 4

//https://www.acmicpc.net/problem/14719

public class 빗물 {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] map = new int[n][m];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int idx = 0;
        while (st.hasMoreTokens()) {
            int y = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= y - 1; i++) {
                map[i][idx] = 1;
            }
            idx++;
        }

        for (int i = 0; i < n; i++) {
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    list.add(new Node(i, j));
                }
            }

            if (list.size() >= 2) {
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int k = list.get(j).y + 1; k < list.get(j + 1).y; k++) {
                        map[i][k] = 2;
                    }
                }
            }
            list = new ArrayList<>();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = map[i][j];
                if (v == 2) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
