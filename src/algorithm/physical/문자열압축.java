package algorithm.physical;

public class 문자열압축 {
    public static void main(String[] args) {
//		String s = "aabbaccc";  // 7
        String s = "ababcdcdababcdcd";  // 9
//		String s = "abcabcdede";  // 8
//		String s = "abcabcabcabcdededededede";  // 14
//		String s = "xababcdcdababcdcd";  // 17


        int answer = s.length();

        for (int i = 1; i < (s.length() / 2) + 1; i++) {
            String compressed = "";
            int cnt = 1;
            String prev = "";
            for (int j = 0; j <= s.length() / i; j++) {
                int start = i * j;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);

                if (prev.equals(s.substring(start, end))) {
                    cnt++;
                } else {
                    compressed += ((cnt >= 2) ? cnt : "") + prev;
                    prev = s.substring(start, end);
                    cnt = 1;
                }
            }
            compressed += ((cnt >= 2) ? cnt : "") + prev;
            System.out.println(i + ", " + compressed + ", " + compressed.length());
            answer = Math.min(answer, compressed.length());
        }

        System.out.println(answer);
    }
}
