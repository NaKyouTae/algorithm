package algorithm.solved;

import org.junit.Test;

/**
 * @author : "NKT"
 * @date : 2021-01-07 17:58
 * @description ==============================================================
 * 선택 삽입 정렬
 * <p>
 * ==============================================================
 */
public class P37 {
    @Test
    public void test() {
//		int[] a = {22, 5, 11, 32, 120, 68, 70};
        int[] a = {6, 4, 8, 3, 1, 9, 7};
        selectSort(a);
    }

    public void swap(int[] a, int x, int y) {
        int temp;

        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = 0;
            for (int k = i + 1; k < a.length; k++) {
                if (a[k] < a[min]) {
                    min = k;
                }
            }

            for (int k = 0; k < a.length; k++) {
                System.out.printf((k == i) ? "  * " : (k == min) ? "  + " : "    ");
            }
            System.out.println();


            for (int k = 0; k < a.length; k++) {
                System.out.printf("%3d ", a[k]);
            }
            System.out.println();

            swap(a, i, min);
        }

    }
}
