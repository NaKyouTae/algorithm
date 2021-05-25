package algorithm.solved;

import org.junit.Test;

public class P39 {
    @Test
    public void test() {
        int[] a = {22, 5, 11, 32, 120, 68, 70};
        selectSort(a);
    }

    public void selectSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int pl = 0;
            int pr = i - 1;
            int pc;
            int pd;

            do {
                pc = (pl + pr) / 2;

                if (a[pc] == key) {
                    break;
                } else if (a[pc] < key) {
                    pl = pc + 1;
                } else {
                    pr = pc - 1;
                }
            } while (pl <= pr);


            pd = (pl <= pr) ? pc + 1 : pr + 1;


            System.out.printf("pd : %d, pl : %d, pr : %d", pd, pl, pr);
            System.out.println();

            for (int k = 0; k < a.length; k++)
                System.out.printf(a[k] + " ");
            System.out.println();

            for (int j = i; j > pd; j--) {
                a[j] = a[j - 1];
            }
            a[pd] = key;


        }

        for (int i = 0; i < a.length; i++)
            System.out.printf(a[i] + " ");
    }
}
