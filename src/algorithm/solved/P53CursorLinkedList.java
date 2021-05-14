package algorithm.solved;

import java.util.Comparator;

import algorithm.model.GCursorLinkedList;
import org.junit.Test;

/**
 * @author      : "NKT"
 * @date        : 2020-12-30 14:39

 * @description
 * ==============================================================
 *
 *
 * ==============================================================
 */
public class P53CursorLinkedList {
	@Test
	public void test() {
		GCursorLinkedList<String> gc = new GCursorLinkedList<>(20);
		
		gc.addLast("A");
		gc.addLast("B");
		gc.addLast("A");
		gc.addLast("D");
		gc.addLast("A");
		gc.addLast("F");
		gc.addLast("A");
		gc.addFirst("A");
		gc.addLast("H");
		gc.addLast("I");
		gc.addLast("J");
		gc.addFirst("K");
		gc.addLast("A");
		gc.addLast("M");
		gc.addFirst("A");
		
		gc.dump();
		gc.purge(COMPARATOR);
		System.out.println();
		gc.dump();
		
		System.out.println(gc.retrieve(6));
		
	}
	
	public static final Comparator<String> COMPARATOR = new StringComparaotr();
	private static class StringComparaotr implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.equals(o2) ? 0:-1;
		}
	}
}
