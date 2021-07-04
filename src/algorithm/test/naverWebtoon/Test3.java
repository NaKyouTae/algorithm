package algorithm.test.naverWebtoon;

/**
 * 문자열 찾아 바꾸고 바꾼 횟수 구하시오
 * aabcbcd , abc , 2
 * 
 * StringBuilder로 제출하였으나
 * KMP로 푸는게 아닌가 싶다
 */
public class Test3 {
    public static void main(String[] args) {
//        String s = "aabcbcd";
//        String f = "abc";
        String s = "aaaaabbbbb";
        String f = "ab";
        System.out.println(solution(s, f));
    }

    public static int solution(String s, String f) {
        int cnt = 0;
        StringBuffer sb = new StringBuffer(s);

        String[] str = s.split("");
        String[] ftr = f.split("");

        while(true) {
            int idx = kmp(str, ftr);
            if(idx == -1) break;
            sb.replace(idx, idx+f.length(), "");
            cnt++;
        }


        return cnt;
    }

    public static int kmp(String[] str, String[] ftr) {
        int sdx = 0;
        int fdx = 0;

        boolean search = false;
        int searchIdx = -1;
        while(true) {

            if(sdx+1 == str.length) break;

            while (str[sdx].equals(ftr[fdx])) {
                sdx++;
                fdx++;
                if (fdx+1 == ftr.length) {
                    searchIdx = sdx;
                    search = true;
                    break;
                }
            }

            if(search) break;
        }

        return searchIdx;
    }
}
