package algorithm.study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class subject1 {
    public static class Node {
        int d, p;
        Node(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
    public static int point = 0;
    public static List<Node> list = new ArrayList<>();
    public static TreeSet<Integer> set = new TreeSet<>();
    public static Comparator<Node> compare = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o2.p, o1.p);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.add(new Node(d, p));
            max = Math.max(max, d);
        }

        list.sort(compare);

        for(int i = 0; i <= max; i++)  set.add(i+1);
        for(int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            Integer idx = set.lower(node.d+1);
            if(idx != null) {
                set.remove(idx);
                point += node.p;
            }
        }

        System.out.println(point);
    }
}
