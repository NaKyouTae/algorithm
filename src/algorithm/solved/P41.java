package algorithm.solved;

import org.junit.Test;

public class P41 {
	@Test
	public void test() {
		int[] a = {22, 5, 11, 32, 120, 68, 70, 13,65, 64,65,78,44,13,54,67,24,64,78,99};
		quickSort(a, 0, a.length-1);
		
		for(int i = 0; i < a.length; i++) {			
			System.out.printf(a[i] + " ");
		}
	}
	
	public void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	
	public void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int key = a[(pl + pr) / 2];
		
		System.out.printf("a[%d]~a[%d]:{", left, right);
		for(int i = left; i < right; i++) {
			System.out.printf("%d, ", a[i]);
		}
		System.out.printf("%d}\n", a[right]);
		
		do {			
			while(a[pl] < key) pl++;
			while(a[pr] > key) pr--;
			if(pl <= pr) {
				swap(a, pl++, pr--);
			}
		} while(pl <= pr);
		
		if(left < pr) quickSort(a, left, pr);
		if(right > pl) quickSort(a, pl, right);
	}
}
