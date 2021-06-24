package algorithm.studyPersonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
//11
//1 4
//3 5
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14

//https://www.acmicpc.net/problem/1931
public class d20210624_meetingRoom {
    public static class Node {
        int s, e;
        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static List<Node> times = new ArrayList<>();
    public static Comparator<Node> compare = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.e, o2.e) == 0 ? Integer.compare(o1.s, o2.s) : Integer.compare(o1.e, o2.e);
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            times.add(new Node(s, e));
        }

        times.sort(compare);

        Node node = times.get(0);

        int cnt = 1;
        for (int i = 1; i < times.size(); i++) {
            Node nextNode = times.get(i);
            if(node.e <= nextNode.s) {
                node = nextNode;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
