package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
    public static int N, K;
    public static int[] arr = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    public static void bfs(int num) {
        Queue<Integer> que = new LinkedList<>();

        que.add(num);
        arr[num] = 1;

        while (!que.isEmpty()) {
            int temp = que.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                if (next == K) {
                    System.out.println(arr[temp]);
                    return;
                }

                if (next >= 0 && next < arr.length & arr[next] == 0) {
                    que.add(next);
                    arr[next] = arr[temp] + 1;
                }
            }
        }
    }
}
