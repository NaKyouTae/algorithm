package algorithm.solved;

import java.util.Arrays;

import org.junit.Test;

public class P13 {
	@Test
	public void test() {
		int num = 18;
		int[] a = new int[num + 1];
		
		for(int i = 0; i<num; i++) {
			a[i] = 20 + i+1;
		}
		
		int key = 35;
 		System.out.println(Arrays.toString(a));
		System.out.println(seqSearchSen(a, num, key));
	}
	
	
	public int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key;
		
		for(i = 0; i<a.length-1; i++) {
			if(a[i] == key) break; 
		}
		
		return (i == a.length-1) ? -1 : i; 
	}
}
