package algorithm.solved;

import org.junit.Test;

public class P50KMP {
	
	@Test
	public void test() {
		String str = "zabcabxaccadef";
		String pat = "abcabd";
		
		System.out.println(KMP(str, pat));
//		System.out.println(kmpMatch(str, pat));
	}
	
	public int KMP(String t, String p) {
		int pt = 1;
		int pp = 0;
		int[] skip = new int[p.length()+1];
		
		while(pt != p.length()) {
			if(p.charAt(pt) == p.charAt(pp)) {
				skip[++pt] = ++pp;
			}else if(pp == 0) {
				skip[++pt] = pp;
			}else {
				pp = skip[pp];
			}
		}
		
		pt = pp = 0;
		
		while(pt != t.length() && pp != p.length()) {
			System.out.println(t);
			if(t.charAt(pt) == p.charAt(pp)) {
				dispPlus(pt);
				dispParttern((pt-pp), p);
				pt++; pp++;
			}else if(pp == 0){
				dispPipe(pt);
				dispParttern((pt-pp), p);
				pt++;
			}else {
				dispPipe(pt);
				dispParttern((pt-pp), p);
				pp = skip[pp];
			}
		}
		
		if(pp == p.length()) return pt - pp;
		return -1;
	}
	
	
	public void dispSpace(int n) {
		for(int i = 0; i < n; i++) {
			System.out.printf(" ");
		}
	}
	
	public void dispParttern(int n, String p) {
		dispSpace(n);
		System.out.println(p);
	}
	
	public void dispPlus(int n) {
		dispSpace(n);
		System.out.println("+");
	}
	
	public void dispPipe(int n) {
		dispSpace(n);
		System.out.println("|");
	}
	static int kmpMatch(String txt, String pat) {
		int pt = 1; // txt를 따라가는 커서
		int pp = 0; // pat를 따라가는 커서
		int count = 0; // 비교횟수
		int[] skip = new int[pat.length() + 1]; // skip 테이블
		int k = -1;

		// skip 테이블 만들기
		System.out.println("skip 테이블 만들기");
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			for (int i = 0; i < txt.length(); i++)
				System.out.print(txt.charAt(i) + " ");
			System.out.println();

			for (int i = 0; i < pt * 2 + 4; i++)
				System.out.print(" ");
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			count++;
			if (pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp == 0)
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}

		// 검색
		System.out.println("검색");
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (k == pt - pp)
				System.out.print("    ");
			else {
				System.out.printf("%2d  ", pt - pp);
				k = pt - pp;
			}
			for (int i = 0; i < txt.length(); i++)
				System.out.print(txt.charAt(i) + " ");
			System.out.println();

			for (int i = 0; i < pt * 2 + 4; i++)
				System.out.print(" ");
			System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
			System.out.println();

			for (int i = 0; i < (pt - pp) * 2 + 4; i++)
				System.out.print(" ");

			for (int i = 0; i < pat.length(); i++)
				System.out.print(pat.charAt(i) + " ");
			System.out.println();
			System.out.println();
			count++;
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0)
				pt++;
			else
				pp = skip[pp];
		}

		System.out.printf("비교는 %d회입니다.\n", count);
		if (pp == pat.length()) // 패턴의 모든 문자를 조사
			return pt - pp;
		return -1; // 검색실패
	}
}
