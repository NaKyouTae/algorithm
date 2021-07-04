package algorithm.studyGroup.study0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//ZOAC

//https://www.acmicpc.net/problem/16719

public class ZOAC {
    public static class Node {
        int l;
        String s;

        Node(int l, String s) {
            this.l = l;
            this.s = s;
        }
    }

    public static Comparator<Node> compare = new Comparator<>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.l == o2.l) ? 0 : (o1.l > o2.l) ? 1 : -1;
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.next().split("");

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            list.add(new Node(i, str[i]));
        }

        Collections.sort(list, compare);

        PriorityQueue<Node> que = new PriorityQueue<>();
        for (Node n : list) {
            que.add(n);
        }

        for (Node n : que) {
            System.out.println(que.poll());
        }
    }
}
