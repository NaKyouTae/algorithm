package algorithm.solved;

import java.util.Comparator;

import algorithm.model.BinTree;
import org.junit.Test;

/**
 * @author      : "NKT"
 * @date        : 2021-01-07 11:14

 * @description
 * ==============================================================
 * 이진 검색 트리
 * P 392 1~3번 문제
 * ==============================================================
 */
public class P57BinarySearchTree {
	
	@Test
	public void test() {
		BinTree<String, Integer> t = new BinTree<>(Compe);
		
		
		t.add("1435", 456);
		t.add("236", 123);
		t.add("31", 867);
		t.add("48", 124);
		t.add("52", 46);
		t.add("61", 1324);
		t.add("76", 546);
		t.add("54", 1423);
		t.add("9", 5367);
		t.add("10", 4256);
		t.add("435", 431);
		t.add("62", 123);
		t.add("534", 354);
		t.add("123", 456);
		t.add("0", 4536);
		t.add("645", 8671);
		
		
		t.printReverse();
		System.out.println();
		System.out.println("Min Key : " + t.getMinKey());
		System.out.println("Min Data : " + t.getDataWithMinKey());
		System.out.println();
		System.out.println("Max Key : " + t.getMaxKey());
		System.out.println("Max Data : " + t.getDataWithMaxKey());
	}
	
	public static final Comparator<String> Compe = new CompartorNatural(); 
	private static class CompartorNatural implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			int n1 = Integer.parseInt(o1);
			int n2 = Integer.parseInt(o2);
			return (n1 > n2) ? -1 : (n2 > n1) ? 1:0;
		}
		
	}
}
