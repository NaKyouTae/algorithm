package algorithm.solved;

import org.junit.Test;

public class P31 {
	private boolean[] flag_a = new boolean[8]; 
	private boolean[] flag_b = new boolean[15]; 
	private boolean[] flag_c = new boolean[15]; 
	private int[] pos = new int[8]; 
	
	@Test
	public void test() {
		set(0);
	}
	
	public void print() {
		for(int i = 0; i<8; i++) {
			System.out.printf("%2d", pos[i]);
		}
		System.out.println();
		
	}
	
	public void set(int i) {
		for(int j = 0; j < 8; j++) {
			if(flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) {

				pos[i] = j;
				
				if(i == 7) {
					setPrint();
				} else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7]  = true;
					set(i+1);
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7]  = false;
				}
			}
		}
	}
	
	public void setPrint() {
		for(int k = 0; k < 8; k++) {
			System.out.print(k+1 + ". ");
			for(int l = 0; l < 8; l++) {
				System.out.printf("%s", l == pos[k] ? "■" : "□");
			}
			System.out.println();
		}
		System.out.println();
	}
}
