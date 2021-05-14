package algorithm.solved;

import java.util.Comparator;

import algorithm.model.GCursorCircularList;
import org.junit.Test;

/**
 * @author      : "NKT"
 * @date        : 2021-01-05 13:36

 * @description
 * ==============================================================
 * 원영 리스트 커서 버전 Cursor Circular List
 * P 348 8번 문제
 * ==============================================================
 */
public class P56CursorCircularList {
	@Test
	public void test() {
		GCursorCircularList<Integer> l = new GCursorCircularList<>(50);
		
		l.addFirst(1);
		l.addFirst(1);
		l.addFirst(2);
		l.addFirst(3);
		l.addFirst(4);
		l.addFirst(5);
		l.addFirst(6);
		l.addFirst(7);
		l.addFirst(8);
		l.addFirst(9);
		l.addFirst(10);
		l.addFirst(11);
		l.addFirst(12);
		l.addFirst(5);
		l.addFirst(6);
		l.addFirst(7);
		l.addFirst(8);
		l.addFirst(9);
		l.addFirst(10);
		l.addFirst(11);
		l.addFirst(12);
		l.addFirst(13);
		l.addFirst(14);
		l.addLast(15);
		l.addLast(13);
		l.addLast(14);
		l.addLast(15);
		l.addLast(17);
		l.addLast(16);
		
		
		print(l);
		l.purge(COMPARATOR);
		print(l);
		System.out.println(l.retreive(8));
	}
	
	public void print(GCursorCircularList<Integer> l) {
		l.dump();
		System.out.println();
	}
	
	public static final Comparator<Integer> COMPARATOR = new GComparator();
	private static class GComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return (o1 > o2) ? -1: (o2 > o1) ? 1:0;
		} 
		
	}

}
