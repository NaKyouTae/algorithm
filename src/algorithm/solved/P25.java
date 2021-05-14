package algorithm.solved;

import org.junit.Test;

public class P25 {
	@Test
	public void test() {
		int[] a = {22, 8, 3, 1};
		
		System.out.println(gdcArray(a, 0, a.length));
	}
	
	public int gdc(int x, int y) {
		while(y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
	
	public int gdcArray(int[]x, int s, int n) {
		if(n == 1){
			return x[s];
		}else if(n == 2) {
			return gdc(x[s], x[s + 1]);
		}else {
			return gdc(x[s], gdcArray(x, s+1, n-1));
		}
	}
}
