package algorithm.solved;

import org.junit.Test;

public class P26 {
	@Test
	public void test() {
		recur(4);
		System.out.println("=====================================");
		recur1(4);
	}
	
	public void recur(int n) {
		if(n > 0) {
			recur(n-1);
			System.out.print(n);
			recur(n-2);
		}
	}
	
	public void recur1(int n) {
		for(int i = 1; i<=n; i++) {			
			recur(i);
			System.out.println("----");
		}
	}
}
