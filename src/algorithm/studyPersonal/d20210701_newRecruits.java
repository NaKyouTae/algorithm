package algorithm.studyPersonal;

//2
//5
//3 2
//1 4
//4 1
//2 3
//5 5
//7
//3 6
//7 3
//4 2
//1 4
//5 7
//2 5
//6 1

//4
//3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1946
public class d20210701_newRecruits {
    public static class Node {
        int g1, g2, sum;
        Node(int g1, int g2, int sum) {
            this.g1 = g1;
            this.g2 = g2;
            this.sum = sum;
        }
    }
    public static Comparator<Node> compare = new Comparator<>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.g1, o2.g1);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int g1 = Integer.parseInt(st.nextToken());
                int g2 = Integer.parseInt(st.nextToken());
                list.add(new Node(g1, g2, g1+g2));
            }

            list.sort(compare);

            int cnt = 1;
            int c = list.get(0).g2;
            for (int j = 1; j < list.size(); j++) {
                if(c > list.get(j).g2) {
                    cnt++;
                    c = list.get(j).g2;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
