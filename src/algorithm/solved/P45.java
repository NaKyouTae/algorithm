package algorithm.solved;

import org.junit.Test;

public class P45 {
	@Test
	public void test() {
		int[] a = {5,7,0,2,4,9,3,1,3};
		
		int max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(max < a[i]) max = a[i];
		}
		
		fSort(a, max);
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void fSort(int[] a, int max) {
		int n = a.length;
		int[] f = new int[max+1];
		int[] b = new int[a.length];
		
		for(int i = 0; i < f.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i < max; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("------------------");
		
		for(int i = 0; i < n; i++) {
			f[a[i]]++;
		}
		for(int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}
		System.out.println();
		System.out.println("------------------");
		
		for(int i = 1; i <= max; i++) {
			f[i] += f[i-1];
//			System.out.print(f[i-1] + " ");
		}
		
		for(int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];
		for(int i = 0; i < n; i++) System.out.print(b[i] + " ");
		System.out.println();
		
		for(int i = 0; i < n; i++) a[i] = b[i];
		System.out.println();
	}
}
