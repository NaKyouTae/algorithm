package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//9
//0
//12345678
//1
//2
//0
//0
//0
//0
//32

//https://www.acmicpc.net/problem/1927

public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int l = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < l; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (que.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(que.poll()).append("\n");
                }
            } else {
                if (que.isEmpty()) {
                    que.add(n);
                } else {
                    if (que.peek() > n) {
                        que.offer(n);
                    } else {
                        que.add(n);
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
