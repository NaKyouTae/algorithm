package algorithm.solved;

import org.junit.Test;

public class P36 {
	@Test
	public void test() {
		int[] a = {9, 1, 3, 6, 5, 7, 8};
		shakerSort(a);
	}
	
	public void swap(int[] a, int x, int y) {
		int temp;
		
		temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void shakerSort(int[] a) {
		int left = 0;
		int right = a.length - 1;
		int last = right;
		while(left < right) {			
			for(int i = left; i < right; i++) {
				if(a[i] > a[i+1]) {
					swap(a, i, i+1);
					last = i;
				}
			}
			
			right = last;
			
			for(int i = right; i > left; i--) {
				if(a[i] < a[i-1]) {
					swap(a, i-1, i);
					last = i;
				}
			}
			
			left = last;
		}
		
		for(int i = 0; i < a.length; i++) {			
			System.out.printf(a[i] + " ");
		}
	}
}
