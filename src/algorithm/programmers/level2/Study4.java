package algorithm.programmers.level2;

/**
 * 피보나치 수
 * */

public class Study4 {
    public static void main(String[] args) {
        int n = 5;

        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            int c = (a+b) % 1234567;
            a = b % 1234567;
            b = c % 1234567;
        }

        System.out.println(a);
    }
}
