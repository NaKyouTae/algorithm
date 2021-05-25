package algorithm.solved;

import java.util.Comparator;

import algorithm.model.GCircularList;
import org.junit.Test;

/**
 * @author : "NKT"
 * @date : 2021-01-05 13:22
 * @description ==============================================================
 * 원형 리스트 Circular List
 * P 348
 * ==============================================================
 */
public class P55CircularList {
    @Test
    public void test() {
        GCircularList<Integer> l = new GCircularList<>();

        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(13);
        l.addFirst(4);
        l.addFirst(5);
        l.addFirst(6);
        l.addFirst(7);
        l.addFirst(8);
        l.addFirst(9);
        l.addFirst(10);
        l.addFirst(11);
        l.addFirst(12);
        l.addFirst(13);
        l.addFirst(14);
        l.addFirst(15);
        l.addFirst(16);
        l.addFirst(17);
        l.addFirst(18);
        l.addFirst(11);
        l.addFirst(12);
        l.addFirst(14);
        l.addFirst(15);
        l.addFirst(16);
        l.addFirst(17);
        l.addFirst(18);

        print(l);

        l.purge(COMPARATOR);
        print(l);
        System.out.println(l.retrieve(7));

    }

    public static final Comparator<Integer> COMPARATOR = new GComparator();

    private static class GComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 > o2) ? -1 : (o2 > o1) ? 1 : 0;
        }

    }

    public void print(GCircularList<Integer> l) {
        l.dump();
        System.out.println();
    }
}
