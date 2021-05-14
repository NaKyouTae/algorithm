package algorithm.solved;

import org.junit.Test;

public class P24 {
	@Test
	public void test() {
		
		int num = 10;
		
		factorial(num);
		nonFactorial(num);
		gdc(22, 8);
	}
	
	public int gdc(int x, int y) {
		if(y != 0) {
			return gdc(y, x % y);
		}
		return x;
	}

	public int factorial(int x) {
		if(x > 0) {
			int a = x * factorial(x - 1);
			
			System.out.println(x + " * " + (x-1) + " : " + a);
			
			return a;
		}else {
			return 1;
		}
	}
	
	public void nonFactorial(int x) {
		int sum = 1;
		for(int i = 1; i< x; i++) {
			sum += i * sum;
		}
		System.out.println(sum);
	}
}
