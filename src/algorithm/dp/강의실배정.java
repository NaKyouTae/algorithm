package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//3
//1 3
//2 4
//3 5

//https://www.acmicpc.net/problem/11000

public class 강의실배정 {
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
            return (o1.x == o2.x) ? 0 : (o1.x > o2.x) ? 1 : -1;
        }

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            String[] str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);

            list.add(new Node(s, e));
        }
        Collections.sort(list, compare);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            if (que.isEmpty()) {
                que.add(list.get(i).y);
            } else {
                if (que.peek() <= list.get(i).x) {
                    que.poll();
                    que.offer(list.get(i).y);
                } else {
                    que.add(list.get(i).y);
                }
            }
        }

        bw.write(Integer.toString(que.size()));
        bw.flush();
        bw.close();
    }
}
