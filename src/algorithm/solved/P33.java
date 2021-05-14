package algorithm.solved;

import org.junit.Test;

/**
 * @author nkt
 *
 *	버블 정렬 왼쪽에서 오른쪽으로
 *
 * Create by User Date : 2020. 12. 8.
 *
 */
public class P33 {
	private String str = "";
	@Test
	public void test() {
		int[] a = {6, 4, 3, 7, 1, 9, 8};
		buble(a);
	}
	
	public void buble(int[] a) {
		int x = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length -  1; j++) {
				if(a[j+1] < a[j]) {
					swap(a, j+1, j);
					System.out.println(x++);
				}
			}
			System.out.println();
		}
	}
	
	public void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
