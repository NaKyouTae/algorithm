package algorithm.solved;

import org.junit.Test;

public class P49bfMatchLast {
	@Test
	public void test() {
		String str = "ababcdefabc";
		String pat = "abc";
		
		System.out.println(bfMatchLast(str, pat));
	}
	
	public int bfMatchLast(String t, String p) {
		int pt = 0;
		int pp = 0;
		int compareCount = 0;
		int count = 1;
		
		while(pt != t.length()) {
			
			// 비교 횟수 증가
			compareCount++;
			
			// 소스 문자와 패턴 문자의 한글자가 일치할때
			if(t.charAt(pt) == p.charAt(pp)) {
				pt++; pp++;
				if(pp ==  p.length()) pp = 0;
			}else {
				// 소스 문자 위치 이동 횟수
				count++;
				
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		
		System.out.println("전체 문자 이동 횟수 : " + count);
		System.out.println("비교 횟수 : " + compareCount);
		if(pp == 0) {
			return pt - p.length();
		}
		
		return -1;		
	}
}
