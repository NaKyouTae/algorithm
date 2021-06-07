package algorithm.study5;

//7
//20 1
//2 1
//10 3
//100 2
//8 2
//5 20
//50 10

//185

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2109
public class touringIecture {
    public static class Node {
        int p, d;
        Node(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
    public static int ans = 0;
    public static List<Node> list = new ArrayList<>();
    public static Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.d, o2.d);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

//            list.add(new Node(p, d));
            if(!map.containsKey(d)) {
                map.put(d, p);
            }else {
                map.put(d, Math.max(map.get(d), p));
            }
        }

        map.entrySet().forEach(item -> {
            ans += item.getValue();
        });

        System.out.println(ans);
    }
}
