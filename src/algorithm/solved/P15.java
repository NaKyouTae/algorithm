package algorithm.solved;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P15 {
    @Test
    public void test() {
        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int key = 9;
        int count = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                list.add(i);
                count += 1;
            }
        }

        System.out.println(list.toString());
        System.out.println("요솟수 : " + count);
    }
}
