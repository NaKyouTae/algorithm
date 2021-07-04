package algorithm.studyPersonal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d20210704_sumOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long sum = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(sum > n) break;
            sum += i;
            cnt++;
        }

        System.out.println(cnt-1);
    }
}
