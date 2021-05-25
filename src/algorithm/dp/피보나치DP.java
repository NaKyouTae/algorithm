package algorithm.dp;

import java.util.Scanner;

public class 피보나치DP {
    public static int[] map;
    public static int z, o;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            map = new int[t + 1];
            memoizationFibonacci(t);
            sb.append(z).append(" ").append(o).append("\n");
            z = 0;
            o = 0;
        }

        System.out.println(sb.toString());
    }

    public static int memoizationFibonacci(int n) {
        if (n <= 1) {
            if (n == 0) z++;
            if (n == 1) o++;
            return n;
        } else if (map[n] != 0) {
            return map[n];
        } else {
            return map[n] = memoizationFibonacci(n - 1) + memoizationFibonacci(n - 2);
        }
    }
}
