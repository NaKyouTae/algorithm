package algorithm.solved;

import org.junit.Test;

public class P2 {
	@Test
	public void test() {
		System.out.println(med3(3, 7, 1));
	}
	
	public int med3(int a, int b, int c) {
		if((a >= b && b >= c) || (c >= b && b >= a)) {
			return b;
		}else if((b >= c && c >= a)||(a >= c && c >= b)) {
			return c;
		}
		
		return a;
	}
}
