package algorithm.dividenconquer;

import java.util.Scanner;

public class Moo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n == 1) {
            System.out.println("m");
        }else if(n <= 3) {
            System.out.println("o");
        }else {
            System.out.println(moo(n));
        }
    }

    public static String moo(int num) {
        int side = 3;
        int center = 4;

        while(num > side) {
            side = center + side * 2;
            center++;
        }
        System.out.println(side);
        if(num == side+1) {
            return "m";
        }else {
            return "o";
        }
    }
}
