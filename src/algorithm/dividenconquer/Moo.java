package algorithm.dividenconquer;

import java.util.Scanner;

public class Moo {
    public static String ans;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        moo(n);

        System.out.println(ans);
    }

    public static void moo(int num) {
        int side = 3;
        int center = 0;

        if(num <= 3){
            ans = (num == 1) ? "m" : "o";
        }else {
            while(num > side) {
                side = center + 4 + side * 2;
                center++;
            }
            System.out.println("side : " + side);
            System.out.println("center : " + center);
            int fb = (side - center - 3) / 2;
            System.out.println("fb : " + fb);
            if(side-fb+1 <= num) {
                moo(num-side+fb);
            }else if(num == fb+1){
                ans = "m";
            }else {
                ans = "o";
            }
        }
    }
}
