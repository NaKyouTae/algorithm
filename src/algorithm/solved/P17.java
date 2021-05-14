package algorithm.solved;

import org.junit.Test;

public class P17 {
	@Test
	public void test() {
		int[] a = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
		int pl = 0;
		int pr = a.length - 1;
		int key = 7;
		int idx = 0;
		while(true) {
			int pc = (pl+pr) / 2;
			
			if(a[pc] < key) {
				pl = pc + 1;
			}else if(a[pc] > key) {
				pr = pc - 1;
			}else if(a[pc] == key) {
				for(int i = pc; i >= 0; i--) {
					if(a[i] == key) idx = i; 
				}
				break;
			}
		}
		
		System.out.println("Index : " + idx);
	}
}
