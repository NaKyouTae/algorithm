package algorithm.solved;

import java.util.Arrays;

import org.junit.Test;

public class P7 {
    @Test
    public void test() {
        int[] a = {};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10};

        copy(a, b);
        System.out.println();
        rcopy(a, b);
    }

    public void copy(int[] a, int[] b) {
        a = b.clone();
        System.out.println(Arrays.toString(a));
    }

    public void rcopy(int[] a, int[] b) {
        a = b.clone();
        int temp = 0;
        for (int i = 0; i < a.length / 2; i++) {
            temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(a));
    }
}
