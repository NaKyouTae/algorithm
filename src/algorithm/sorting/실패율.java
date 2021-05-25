package algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class 실패율 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
//		int[] arr = {4, 4, 4, 4, 4};
        int[] result = run(n, arr);

        for (int l : result) {
            System.out.println(l + ", ");
        }
    }

    public static class Node {
        int stage;
        double failure;

        Node(int s, double f) {
            this.stage = s;
            this.failure = f;
        }
    }

    public static Comparator<Node> compare = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.failure == o2.failure) ? (o1.stage == o2.stage) ? 0 : (o1.stage > o2.stage) ? 1 : -1 : (o1.failure > o2.failure) ? -1 : 1;
        }

    };

    public static int[] run(int n, int[] stages) {
        int[] answer = {};
        List<Node> list = new ArrayList<>();
        List<Integer> sta = Arrays.stream(stages).boxed().collect(Collectors.toList());

        int total = stages.length;
        for (int i = 0; i < n; i++) {
            long count = 0;
            double fail = 0;
            int val = i + 1;
            count = sta.stream().filter(item -> item == val).count();

            if (total == 0) {
                fail = 0;
            } else {
                fail = (double) count / total;
            }

            list.add(new Node(i + 1, fail));
            total -= count;
        }

        Collections.sort(list, compare);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i).stage;

        return answer;
    }
}
