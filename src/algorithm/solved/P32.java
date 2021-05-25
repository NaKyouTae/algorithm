package algorithm.solved;

import algorithm.model.GStack;
import org.junit.Test;

/**
 * @author nkt
 * <p>
 * 8퀸 비재귀
 * <p>
 * Create by User Date : 2020. 12. 8.
 */
public class P32 {
    private boolean[] flag_a = new boolean[8];
    private boolean[] flag_b = new boolean[15];
    private boolean[] flag_c = new boolean[15];
    private int[] pos = new int[8];

    @Test
    public void test() {
        set(0);
    }

    public void print() {
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + ". ");
            for (int j = 0; j < 8; j++) {
                System.out.printf("%s", pos[i] == j ? "■" : "□");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void set(int i) {
        int j;
        GStack<Integer> stk = new GStack<>(8);

        Start:
        while (true) {
            j = 0;
            while (true) {
                while (j < 8) {
                    if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
                        pos[i] = j;

                        if (i == 7) {
                            print();
                        } else {
                            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                            stk.push(j);
                            i++;
                            continue Start;
                        }
                    }
                    j++;
                }
                if (stk.isEmpty()) return;
                j = stk.pop();
                i--;
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                j++;
            }
        }
    }
}
