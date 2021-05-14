package algorithm.solved;

import algorithm.model.GSortedSet;
import org.junit.Test;

public class P47Set {
	@Test
	public void test() {
		GSortedSet<Integer> g = new GSortedSet<>(40);
		
		g.add(13);
		g.add(12);
		
		System.out.println("g : " + g.toString());
		
		GSortedSet<Integer> t = new GSortedSet<>(20);
		t.add(20);
		t.add(13);
		t.add(15);
		t.add(16);
		t.add(12);
		t.add(17);
		t.add(18);
		t.add(22);
		t.add(27);
		t.add(29);
		t.add(19);
		t.add(28);
		t.add(21);
		t.add(23);
		t.add(24);
		t.add(25);
		t.add(26);
		
		
		System.out.println("t : " + t.toString());
		
		
//		t.union(g);
//		System.out.println("합 : " + t.toString());
		
//		t.retain(g);
//		System.out.println("교 : " + t.toString());

//		t.remove(g);
//		System.out.println("차 : " + t.toString());
		
		
		GSortedSet<Integer> z = new GSortedSet<>(g.size() + t.size());
		
		z.differenceOf(t, g);
		
		System.out.println(z.toString());
		
	}
}
