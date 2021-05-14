package algorithm.solved;

import java.util.Comparator;

import algorithm.model.GDblLinkedList;
import org.junit.Test;

/**
 * @author      : "NKT"
 * @date        : 2021-01-04 15:47

 * @description
 * ==============================================================
 * P. 348
 * Doubly Circular Linked List (원형 이중 연결 리스트)
 * ==============================================================
 */
public class P54DblLinkedList {
	@Test
	public void test() {
		GDblLinkedList<Integer> list = new GDblLinkedList<>();
		
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(18);
		list.add(19);
		list.add(20);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		
		list.dump();
		
		list.purge(COMPARATOR);
		System.out.println();
		list.dump();
		System.out.println();
		System.out.println(list.retrive(4));
		
	}
	
	public static final Comparator<Integer> COMPARATOR = new GComparator(); 
			
	private static class GComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return ((int) o1 > (int) o2) ? -1 : ((int) o2 > (int) o1) ? 1 : 0;
		}
		
	}
}
