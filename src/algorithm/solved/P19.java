package algorithm.solved;

import algorithm.model.GStack;
import org.junit.Test;

public class P19 {
	@Test
	public void test() {
		GStack<Integer> stk = new GStack<Integer>(50);
		
		
		stk.push(1234);
		stk.push(234);
		stk.push(5435);
		stk.push(123);
		stk.push(5435);
		stk.push(7567);
		stk.push(59);
		stk.push(5435);
		
		stk.pop();
		stk.pop();
		
		System.out.println("peek : " + stk.peek());
		
		stk.pop();
		
		stk.dump();
	}
}
