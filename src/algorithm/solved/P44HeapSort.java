package algorithm.solved;

import org.junit.Test;

/**
 * @author nkt
 * 2020-12-19 heapSort 해야함
 */
public class P44HeapSort {
    @Test
    public void test() {
        int[] a = {10, 7, 5, 4, 1, 2, 8, 6, 9, 3};
        heapSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + ",");
    }

    public void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    static int pow2(int n) {
        int k = 1;

        while (n-- > 0)
            k *= 2;
        return k;
    }

    public void dispSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" ");
        }
    }

    public void heapSort(int[] a) {
        int n = a.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            dispHeap(a, n);
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            dispHeap(a, n);
            downHeap(a, 0, i - 1);
        }
    }

    public void dispHeap(int[] a, int n) {
        int i = n;
        int height = 1;
        while ((i >>= 1) > 0)
            height++;
        i = 0;
        int w = 1;
        Loop:
        {
            for (int level = 0; level < height; level++) {
                dispSpace(pow2(height - level) - 3);
                for (int k = 0; k < w; k++) {
                    System.out.printf("%02d", a[i++]);
                    if (i >= n)
                        break Loop;
                    if (k < w - 1)
                        dispSpace(pow2(height - level + 1) - 2);
                }
                System.out.println();

                dispSpace(pow2(height - level) - 4);
                for (int k = 0; k < w; k++) {
                    if (2 * k + i < n)
                        System.out.printf(" /");
                    if (2 * k + i + 1 < n)
                        System.out.printf(" \\");
                    if (k < w - 1)
                        dispSpace(pow2(height - level + 1) - 4);
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }

    public void downHeap(int[] a, int left, int right) {
        int t = a[left];
        int c;
        int p;

        for (p = left; p < (right + 1) / 2; p = c) {
            int cl = p * 2 + 1;
            int cr = cl + 1;
            c = (cr <= right && a[cr] > a[cl]) ? cr : cl;

            if (t >= a[c]) {
                break;
            }
            a[p] = a[c];
        }
        a[p] = t;
    }
}
