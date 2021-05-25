package algorithm.solved;

import org.junit.Test;

public class P16 {

    @Test
    public void test() {
        int[] a = {1, 2, 3, 5, 6, 8, 9};
        int pl = 0;
        int pr = a.length - 1;
        int key = 2;


        System.out.print("   |");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.println(" " + i);
            } else {
                System.out.print(" " + i);
            }
        }

        System.out.print("---+");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.println("--");
            } else {
                System.out.print("--");
            }
        }

        while (true) {
            int pc = (pl + pr) / 2;

            System.out.print("   |");
            for (int i = 0; i < a.length; i++) {
                if (i == pl) {
                    System.out.print(" <-");
                } else if (i == pc) {
                    System.out.print("+");
                } else if (i == pr) {
                    if (i == a.length - 1)
                        System.out.println("->");
                    else
                        System.out.print("->");
                } else {
                    if (i == a.length - 1)
                        System.out.println("  ");
                    else
                        System.out.print("  ");
                }
            }

            System.out.print("  " + pc + "|");
            for (int i = 0; i < a.length; i++) {
                if (i == a.length - 1)
                    System.out.println(" " + a[i]);
                else
                    System.out.print(" " + a[i]);
            }


            if (a[pc] < key) {
                pl = pc + 1;
            } else if (a[pc] > key) {
                pr = pc - 1;
            } else if (a[pc] == key) {
                System.out.println(key + "는" + "a[" + pc + "]에 있습니다.");
                break;
            }
        }
    }
}
