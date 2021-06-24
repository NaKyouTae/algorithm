package algorithm.logic;

import java.util.Comparator;

public class memo {
    public static void main(String[] args) {
        LowerBound<Integer> lower = new LowerBound<>();

        lower.add(1);
        lower.add(10);
        lower.add(9);
        lower.add(8);
        lower.add(7);
        lower.add(6);
        lower.add(5);
        lower.add(4);
        lower.add(3);
        lower.add(2);

        lower.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        System.out.println(lower.lower(8));
    }
}
