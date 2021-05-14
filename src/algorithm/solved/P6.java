package algorithm.solved;

import java.util.Arrays;

import org.junit.Test;

public class P6 {
	@Test
	public void test() {
		int[] array = {5, 10, 73, 2, -5, 42};
		reverse(array);
		System.out.println();
		arraySum(array);
	}
	
	public void reverse(int[] a) {
		int temp = 0;
		
		for(int i = 0; i<a.length/2; i++) {
			System.out.println(Arrays.toString(a));
			System.out.println("a[" + i + "]과(와) a[" + (a.length-i-1) + "]를 교환합니다.");
			temp = a[i];
			a[i] = a[a.length-i-1];
			a[a.length-i-1] = temp;
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("역순 정렬을 마쳤습니다.");
	}
	
	public void arraySum(int[] a) {
		int sum = 0;
		for(int i = 0; i<a.length; i++) {
			sum += a[i]; 
		}
		
		System.out.println(sum);
	}
}
