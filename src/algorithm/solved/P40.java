package algorithm.solved;

import org.junit.Test;

public class P40 {
    @Test
    public void test() {
        int[] a = {22, 5, 11, 32, 120, 68, 70, 13, 65, 64, 65, 78, 44, 13, 54, 67, 24, 64, 78, 99};
        shellSortV1(a, a.length);

        int[] b = {22, 5, 11, 32, 120, 68, 70, 13, 65, 64, 65, 78, 44, 13, 54, 67, 24, 64, 78, 99};
        shellSortV2(b, b.length);

        System.out.println(a.length / 9);
    }

    public void shellSortV1(int[] a, int n) {
        int c = 0;
        for (int i = n / 2; i > 0; i /= 2) {
            for (int k = i; k < n; k++) {
                int j;
                int t = a[k];
                for (j = k - i; j >= 0 && a[j] > t; j -= i) {
                    c++;
                    a[j + i] = a[j];
                }
                a[j + i] = t;
            }
        }
        System.out.println("v1 : " + c);
        for (int i = 0; i < a.length; i++)
            System.out.printf(a[i] + " ");
        System.out.println();

    }

    public void shellSortV2(int[] a, int n) {
        int c = 0;
        int i;
        for (i = 1; i < n / 9; i = (i * 3) + 1)
            ;

        for (; i > 0; i /= 3) {
            for (int k = i; k < n; k++) {
                int j;
                int t = a[k];
                for (j = k - i; j >= 0 && a[j] > t; j -= i) {
                    c++;
                    a[j + i] = a[j];
                }
                a[j + i] = t;
            }
        }

        System.out.println("v2 : " + c);
        for (int j = 0; j < a.length; j++)
            System.out.printf(a[j] + " ");
        System.out.println();
    }

}
