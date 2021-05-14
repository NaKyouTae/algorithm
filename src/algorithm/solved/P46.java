package algorithm.solved;

import org.junit.Test;

public class P46 {
	@Test
	public void test() {
		int[] a = {22, 3, 67, 46, 134, 65, 122, 575, 781};
		
		int len = a.length;
		int max = a[0];
		for(int i = 1; i < len; i++) {
			if(max < a[i]) max = a[i];
		}
		
		fSort(a, len, 2, max);
	}
	
	public void fSort(int[] a, int n, int min, int max) {
		int[] f = new int[max+1];
		int[] b = new int[(n-min)];
		
		for(int i = min; i < n; i++) f[a[i]]++;
		for(int i = 1; i <= max; i++) f[i] += f[i - 1];
		for(int i = n-1; i >= min; i--) b[--f[a[i]]] = a[i];
		
		for(int i = 0; i < b.length; i++)
			System.out.printf(b[i] + " ");
	}
}
