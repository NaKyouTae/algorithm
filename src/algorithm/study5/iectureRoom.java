package algorithm.study5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class iectureRoom {
    public static class Node {
        int o, s, e;
        Node(int o, int s, int e) {
            this.o = o;
            this.s = s;
            this.e = e;
        }
    }
    public static PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.o, o2.o);
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int o = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            que.add(new Node(o, s, e));
        }

        int max = Integer.MIN_VALUE;

        while(!que.isEmpty()) {
            Node node = que.poll();
            int cnt = 0;
            while(!que.isEmpty()) {
                Node childNode = que.peek();

                if(node.e < childNode.s) continue;

                que.poll();
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
