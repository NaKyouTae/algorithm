package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//7
//2 4
//4 5
//5 6
//5 7
//7 9
//11 12
//12 12

//https://www.acmicpc.net/problem/20207
public class 달력_1 {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Comparator<Node> compare = new Comparator<>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.x == o2.x) ? (o1.y - o1.x + 1 > o2.y - o2.x + 1) ? -1 : 1 : (o1.x > o2.x) ? 1 : -1;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.max(x, y));
            min = Math.min(min, Math.min(x, y));
            list.add(new Node(x, y));

        }

        Collections.sort(list, compare);

        int[][] map = new int[n][max + 2];

        for (int t = 0; t < n; t++) {
            Node node = list.get(t);
            int idx = 0;
            for (int j = node.x; j <= node.y; j++) {

                if (map[idx][j] == 1) {
                    while (map[++idx][j] != 0) {
                    }
                }

                map[idx][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < max + 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        List<Node> res = new ArrayList<>();

        for (int i = min; i < max + 2; i++) {
            boolean isOne = false;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 1) {
                    isOne = true;
                    xMax = Math.max(xMax, j);
                    yMax = Math.max(yMax, i);
                    yMin = Math.min(yMin, i);
                }
            }

            if (!isOne) {
                res.add(new Node(xMax + 1, (yMax - yMin) + 1));
                xMax = Integer.MIN_VALUE;
                yMax = Integer.MIN_VALUE;
                yMin = Integer.MAX_VALUE;
            }
        }

        int sum = 0;
        for (Node r : res) {
            sum += r.x * r.y;
        }

        System.out.println(sum);
    }
}
