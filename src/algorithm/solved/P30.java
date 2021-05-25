package algorithm.solved;

import org.junit.Test;

public class P30 {
    static boolean[] flag = new boolean[8];
    static int[] pos = new int[8];

    @Test
    public void test() {
        set(0);
    }

    public void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    public void set(int i) {
        for (int k = 0; k < 8; k++) {
            if (flag[k] == false) {
                pos[i] = k;
                if (i == 7) {
                    print();
                } else {
                    flag[k] = true;
                    set(i + 1);
                    flag[k] = false;
                }
            }
        }
    }
}
