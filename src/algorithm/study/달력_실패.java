package algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//7
//2 4
//4 5
//5 6
//5 7
//7 9
//11 12
//12 12

//https://www.acmicpc.net/problem/20207
public class 달력_실패 {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        List<Node> rq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            min = Math.min(min, Math.min(x, y));
            max = Math.max(max, Math.max(x, y));

            rq.add(new Node(x, y));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= max + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < rq.size(); i++) {
            list.get(rq.get(i).x).add(rq.get(i).y);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int idx = min, x = 0, y = 0;
        while (true) {
            if (list.size() <= idx + 2) break;
            if (list.get(idx).size() == 0) {
                map.put(idx, y);
                x = 0;
                y = 0;
                idx++;
            } else {
                int m = Integer.MIN_VALUE;

                for (int i = 0; i < list.get(idx).size(); i++) {
                    m = Math.max(m, list.get(idx).get(i));
                }

                idx = m;
            }

            y = Math.max(y, list.get(idx).size());
        }

        map.entrySet().forEach(item -> {
            sum += item.getKey() * item.getValue();
        });

        System.out.println(sum);
    }
}
