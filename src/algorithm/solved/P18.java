package algorithm.solved;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import algorithm.solved.P11.Physc;

public class P18 {
	public static class OrderComparator implements Comparator<Physc> {
		@Override
		public int compare(Physc o1, Physc o2) {
			return (o1.vision > o2.vision) ?  1 :
				   (o1.vision < o2.vision) ? -1 : 0;
		}
		
	}
	
	public static final Comparator<Physc> com = new OrderComparator();
	
	@Test
	public void test() {
		double vision = 0.3;
		
		// Key의 순차 정렬이 되어있어야 함
		
		Physc[] x = {
			new Physc("나규태1", 143, 0.1),
			new Physc("나규태2", 184, 0.2),
			new Physc("나규태3", 183, vision),
			new Physc("나규태4", 163, 0.4),
			new Physc("나규태5", 181, 0.9),
			new Physc("나규태6", 182, 1.3),
			new Physc("나규태7", 113, 1.4),
			new Physc("나규태8", 103, 1.5),
			new Physc("나규태9", 163, 1.6),
			new Physc("나규태10", 193, 1.7),
			new Physc("나규태11", 113, 1.8),
			new Physc("나규태12", 123, 1.9),
			new Physc("나규태13", 133, 2.0),
		};
		
		int idx = Arrays.binarySearch(x, new Physc("", 0, vision), com);
		
		if(idx < 0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
		}else {			
			System.out.println("찾은 데이터 : " + x[idx]);
		}
	}
	
}
