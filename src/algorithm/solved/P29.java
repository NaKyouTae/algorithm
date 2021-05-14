package algorithm.solved;

import algorithm.model.GStack;
import org.junit.Test;

public class P29 {

	@Test
	public void test() {
		move(5, 1, 3);
		System.out.println("==========================================");
		move1(5, 1, 3);
	}
	
	public void move(int n, int x, int y) {
		if(n > 1)
			move(n-1, x, 6 - x - y);
		
		System.out.println("n["+n+"] 은 "+ (x == 1 ? "A기둥":x == 2 ? "B기둥":"C기둥") +"에서 " + (y == 1 ? "A기둥":y == 2 ? "B기둥":"C기둥") +"로 이동하였습니다.");
		
		if(n > 1)
			move(n-1, 6 - x - y, y);
	}
	
	public void move1(int n, int x, int y) {
		GStack<Integer> xstk = new GStack<>(n);
		GStack<Integer> ystk = new GStack<>(n);
		GStack<Integer> sstk = new GStack<>(n);
		int sw = 0;
		
		while(true) {			
			if(sw == 0 && n > 1) {
				xstk.push(x);
				ystk.push(y);
				sstk.push(sw);
				n = n - 1;
				y = 6 - x - y;
				continue;
			}
			
			System.out.printf("n[%d] 은 %d기둥에서 %d기둥으로 옮길\n", n, x, y);
			
			if(sw == 1 && n > 1) {
				xstk.push(x);
				ystk.push(y);
				sstk.push(sw);
				n = n - 1;
				x = 6 - x - y;
				if(++sw == 2)
					sw = 0;
				continue;
			}
			
			do {
				if(xstk.isEmpty()) return;
				
				x = xstk.pop();
				y = ystk.pop();
				sw = sstk.pop() + 1;
				n++;
				
			} while(sw == 2);
		}
		
		
	}
}
