package algorithm.solved;

import org.junit.Test;

public class P1 {
	@Test
	public void test() {
		System.out.println(max3(1, 2, 3));
		System.out.println(max4(3,234,6546,54645));
		System.out.println(min4(456,645,6456,43));
		System.out.println(1-0);
	}
	
	public int max3(int a, int b, int c) {
		int max = a;
		
		if(max < b) max = b;
		if(max < c) max = c;
		
		return max;
	}
	public int max4(int a, int b, int c, int d) {
		int max = a;
		
		if(max < b) max = b;
		if(max < c) max = c;
		if(max < d) max = d;
		
		return max;
	}
	public int min4(int a, int b, int c, int d) {
		int min = a;
		
		if(min > b) min = b;
		if(min > c) min = c;
		if(min > d) min = d;
		
		return min;
	}
}
