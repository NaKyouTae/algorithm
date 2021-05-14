package algorithm.solved;

import org.junit.Test;

public class P14 {
	@Test
	public void test() {
		
		int[] array = {6, 4, 3, 2, 1, 9, 8};
		int[] key = {6, 4, 3};
 		
		
		System.out.print("   | ");
		for(int i = 0; i<array.length; i++) {
			if(i == array.length-1) {
				System.out.println(i + " ");
			}else {
				System.out.print(i + " ");
			}
		}
		
		System.out.print("---+");
		for(int i = 0; i<array.length; i++) {
			if(i == array.length-1) {
				System.out.println("--");
			}else {
				System.out.print("--");
			}
		}
		
		
		for(int j = 0; j < key.length; j++) {
			System.out.print("   |");
			for(int i = 0; i<array.length; i++) {
				if(array[i] == key[j]) {
					if(i == array.length-1)
						System.out.println(" *");
					else
						System.out.print(" *");
				}else {
					if(i == array.length-1)
						System.out.println("  ");
					else
						System.out.print("  ");
				}
			}
			
			System.out.print("  " + j + "| ");
			for(int i = 0; i<array.length; i++) {
				if(i == array.length-1)
					System.out.println(array[i] + " ");
				else
					System.out.print(array[i] + " ");
			}
		}
	}
}
