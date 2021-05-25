package algorithm.dp;

import java.util.Scanner;

public class 피보나치구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int z = 1;
            int o = 0;
            int zo = 1;

            for (int j = 0; j < t; j++) {
                z = o;
                o = zo;
                zo = z + o;
            }

            sb.append(z).append(" ").append(o).append("\n");
        }

        System.out.println(sb.toString());
    }
}
