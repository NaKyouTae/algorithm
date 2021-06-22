package algorithm.studyGroup.study2;

import java.util.Scanner;

public class Moo_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        moo(n);
    }

    public static void moo(int n) {
        if (n == 0) {
            System.out.println("m");
        } else if (n <= 3) {
            System.out.println("o");
        } else {
            int side = 3;
            int center = 4;

            while (n > side) {
                side = side * 2 + center;
                center++;
            }

            int front = (side - center) / 2;

            if (side - front + 1 <= n) {
                moo(n - side + front);
            } else if (n == front + 1) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
        }
    }
}
