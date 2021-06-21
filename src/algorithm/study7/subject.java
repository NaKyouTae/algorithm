package algorithm.study7;

//7
//4 60
//4 40
//1 20
//2 50
//3 30
//4 10
//6 5

//https://www.acmicpc.net/problem/13904

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class subject {
    public static class Node {
        int d, p;
        Node(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
    public static int point = 0;
    public static List<Node> list = new ArrayList<>();
    public static Comparator<Node> compare = new Comparator<>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o2.p, o1.p);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new Node(d, p));
        }

        list.sort(compare);

        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            que.add(list.get(i));
        }

        int c = que.peek().d;

        int sumCount = 0;

        while(!que.isEmpty()) {
            Node node = que.peek();
            if(sumCount == c)
            for(int i = 0; i < node.d; i++) {
                Node nc = que.poll();
                sumCount++;
                point += nc.p;
                if(que.isEmpty()) break;
            }
        }

        System.out.println(point);
    }
}
