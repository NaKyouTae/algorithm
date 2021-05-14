package algorithm.solved;

import org.junit.Test;

public class P38 {
	@Test
	public void test() {
		int[] a = {22, 5, 11, 32, 120, 68, 70};
		selectSort(a);
	}
	
	public void selectSort(int[] a) {
		int n = a.length;
		
		for(int i = 1; i<n; i++) {
			int j;
			int t = a[i];
			
			for(j=i; j>0 && a[j-1] > t; j--) {
				a[j] = a[j - 1];
			}
			a[j] = t;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.printf(a[i] + " ");
		}
	}
}
