package algorithm.solved;

import algorithm.model.GStack;
import org.junit.Test;

/**
 * @author nkt
 * 2020-12-17 목
 * 비재귀 퀵정렬
 */
public class P42 {
    @Test
    public void test() {
        int[] a = {6, 5, 4, 2, 7, 3, 1, 8};
        quickSort(a, 0, a.length - 1);
    }

    public void insertSort(int[] a, int left, int right) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int j;
            int t = a[i];
            for (j = i; j > 0 && a[j - 1] > t; j--) {
                a[j] = a[j - 1];
            }
            a[j] = t;
        }


        for (int k = 0; k < a.length; k++) {
            System.out.printf(a[k] + " ");
        }
    }


    public void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    //	5 11 13 13 22 24 32 44 54 64 64 65 65 67 68 70 78 78 99 120
//	5 11 13 13 22 24 32 44 54 64 64 65 65 67 68 70 78 78 99 120
    public void quickSort(int[] a, int left, int right) {
        if (a.length <= 9) {
            insertSort(a, left, right);
        } else {
            GStack<Integer> lstk = new GStack<>(a.length);
            GStack<Integer> rstk = new GStack<>(a.length);

            lstk.push(left);
            rstk.push(right);

            System.out.printf("left : %d, right : %d", left, right);
            System.out.println();

            while (lstk.isEmpty() != true) {
                int pl = left = lstk.pop();
                int pr = right = rstk.pop();
                System.out.printf("left : %d, right : %d, OUT", left, right);
                System.out.println();
                int x = a[(left + right) / 2];

                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr) {
                        swap(a, pl++, pr--);
                    }
                } while (pl <= pr);

//			작은 요소 부터
                if (pr - left > right - pl) {
                    int temp;

                    temp = pl;
                    pl = left;
                    left = temp;

                    temp = pr;
                    pr = right;
                    right = temp;
                }


//			큰 요소 부터 
//			if(pr - left < right - pl) {
//				int temp;
//				
//				temp = left;
//				left = pl;
//				pl = temp;
//				
//				temp = right;
//				right = pr;
//				pr = temp;
//			}


                if (left < pr) {
                    lstk.push(left);
                    rstk.push(pr);
                    System.out.printf("left : %d, right : %d", left, pr);
                    System.out.println();
                }

                if (right > pl) {
                    lstk.push(pl);
                    rstk.push(right);
                    System.out.printf("left : %d, right : %d", pl, right);
                    System.out.println();
                }
            }

            for (int i = 0; i < a.length; i++) {
                System.out.printf(a[i] + " ");
            }

        }

    }
}
