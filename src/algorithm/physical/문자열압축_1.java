package algorithm.physical;

public class 문자열압축_1 {
	public static void main(String[] args) {
		String[] str = {
				"aabbaccc",  // 7
				"ababcdcdababcdcd",  // 9
				"abcabcdede",  // 8
				"abcabcabcabcdededededede",  // 14
				"xababcdcdababcdcd"  // 17
		};
		for(String s : str) {
			int len = s.length();
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= len/2; i++) {
				String prev = "", compressed = "";
				int cnt = 1;
				for (int j = 0; j <= len/i; j++) {
					int start = i * j;
					int end = (i*(j+1) > len) ? len:i*(j+1);
					
					if(prev.equals(s.substring(start, end))) {
						cnt++;
					}else {
						compressed += ((cnt > 1) ? cnt:"") + prev;
						prev = s.substring(start, end);
						cnt = 1;
					}
				}
				compressed += ((cnt > 1) ? cnt:"") + prev;
				min = Math.min(min, compressed.length());
				System.out.println(min + " " + compressed);
			}
			System.out.println("min : " + min);
		}
	}
}
