package algorithm.studyGroup.study0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 프로그래머스3 {
    public static class Node {
        int x, y, n, m;

        Node(int x, int y, int n, int m) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.m = m;
        }
    }

    public static Comparator<Node> compare = new Comparator<>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.x == o2.x) ? (o1.y > o2.y) ? -1 : 1 : (o1.x > o2.x) ? -1 : 1;
        }
    };
    public static int cnt;

    public static void main(String[] args) {
//		[-5,0,2,1,2]	[[0,1],[3,4],[2,3],[0,3]]	9
//		int[] a = {-5,0,2,1,2};
//		int[][] edges = {{0,1},{3,4},{2,3},{0,3}};

//		[0,1,0]	[[0,1],[1,2]] -1
        int[] a = {0, 1, 0};
        int[][] edges = {{0, 1}, {1, 2}};

        List<Node> list = new ArrayList<>();
        boolean isZero = true;
        for (int i = 0; i < a.length; i++) if (a[i] != 0) isZero = false;

        if (isZero) System.out.println(0);
        else {
            for (int i = 0; i < edges.length; i++) {
                list.add(new Node(a[edges[i][0]], a[edges[i][1]], edges[i][0], edges[i][1]));
            }

            Collections.sort(list, compare);
            int sum = 0;
            for (Node node : list) {
                if (node.x == 0 && node.y == 0) continue;
                if (node.x > node.y) {
                    int i = Math.abs(a[node.n]);
                    a[node.n] -= i;
                    a[node.m] += i;
                    sum += i;
                } else {
                    int i = Math.abs(a[node.m]);
                    a[node.n] += i;
                    a[node.m] -= i;
                    sum += i;
                }
            }
            boolean check = true;
            for (int i : a) if (i != 0) check = false;
            System.out.println(!check ? -1 : sum);
        }
    }
}
