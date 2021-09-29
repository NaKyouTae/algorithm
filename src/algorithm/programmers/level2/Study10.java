package algorithm.programmers.level2;

/**
 * 다음 큰수
 * */

public class Study10 {
    public static void main(String[] args) {
        int n = 78;

        int nc = Integer.bitCount(n);

        while(true) {
            if(nc == Integer.bitCount(++n)) break;
        }

        System.out.println(n);
    }
}
