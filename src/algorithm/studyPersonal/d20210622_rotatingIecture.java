package algorithm.studyPersonal;

//7
//20 1
//2 1
//10 3
//100 2
//8 2
//5 20
//50 10

//https://www.acmicpc.net/problem/2109

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class d20210622_rotatingIecture {
    public static class Node {
        int d, p;
        Node(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
    public static int amount = 0;
    public static List<Node> list = new ArrayList<>();
    public static TreeSet<Integer> set = new TreeSet<>();
    public static Comparator<Node> compare = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o2.p, o1.p);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int maxDeadLine = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Node(d, p));
            maxDeadLine = Math.max(maxDeadLine, d);
        }

        list.sort(compare);

        for (int i = 0; i <= maxDeadLine; i++) set.add(i+1);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            Integer idx = set.lower(node.d+1);
            if(idx != null) {
                set.remove(idx);
                amount += node.p;
            }
        }

        System.out.println(amount);
    }
}
