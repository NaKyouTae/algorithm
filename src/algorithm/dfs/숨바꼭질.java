package algorithm.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
    public static class Node {
        int x, c;

        Node(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }

    public static int[] arr;
    public static boolean[] visit;
    public static Queue<Node> que = new LinkedList<>();
    public static int N, K, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[K];
        visit = new boolean[K];
        que.add(new Node(N, 0));
        bfs();

        System.out.println(cnt);
    }

    public static void bfs() {
        while (!que.isEmpty()) {
            Node node = que.poll();

            if (!visit[node.x * 2]) {
                visit[node.x * 2] = true;
                que.add(new Node(node.x * 2, node.c + 1));
            } else {

            }
        }
    }
}
