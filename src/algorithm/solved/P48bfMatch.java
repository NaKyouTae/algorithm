package algorithm.solved;

import org.junit.Test;

public class P48bfMatch {
	@Test
	public void test() {
		String str = "ababcdefgha";
		String pat = "abc";
		
		System.out.println(bfMatch(str, pat)); 
	}
	
	public int bfMatch(String str, String pat) {
		String s = str.toUpperCase();
		String p = pat.toUpperCase();
		
		int pt = 0;
		int pp = 0;
		int count = 0;
		int textCount = 1;
		
		while(pt != s.length() && pp != p.length()) {
			count++;
			System.out.println(textCount + ".");
			System.out.println(s);
			if(s.charAt(pt) == p.charAt(pp)) {
				dispPlux(pt);
				dispParttern(textCount, p);
				pt++; pp++;
			}else {
				dispPipe(pt);
				dispParttern(textCount, p);
				textCount++;
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		System.out.println("비교 횟수 : " + count);
		
		if(pp == pat.length()) {
			return pt - pp;
		}
		return -1;		
	}
	
	public void dispSpace(int n) {
		for(int i = 0; i < n; i++) {
			System.out.printf(" ");
		}
	}
	
	public void dispParttern(int n, String p) {
		if(n > 0) dispSpace(n-1);
		System.out.println(p);
	}
	
	public void dispPlux(int n) {
		dispSpace(n);
		for(int i = 0; i <= n; i++) {
			if(n == i)
				System.out.printf("+");
		}
		System.out.println();
	}
	
	public void dispPipe(int n) {
		dispSpace(n);
		for(int i = 0; i <= n; i++) {
			if(n == i)
				System.out.printf("|");
		}
		System.out.println();
	}
	
}
