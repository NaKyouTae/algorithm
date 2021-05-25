package algorithm.physical;

import java.util.Iterator;

public class 자물쇠와열쇠 {
    public static int[][] lrr, krr, key, lock;
    public static int size;
    public static boolean answer;

    public static void main(String[] args) {
        key = new int[][]{{0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}};

        lock = new int[][]{{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        initialize();

        for (int i = 0; i < 4; i++) {
            transfer(90 * i);
            if (move()) {
                print(krr);
                answer = true;
                break;
            }
            initialize();
        }
        System.out.println();
        print(lrr);
        System.out.println(answer);
    }

    public static void initialize() {
        size = lock.length - 1;
        krr = new int[key.length][key[0].length];
        lrr = new int[lock.length + size * 2][lock[0].length + size * 2];

        for (int i = 0; i < krr.length; i++) {
            for (int j = 0; j < krr[i].length; j++) {
                krr[i][j] = key[i][j];
            }
        }

        for (int i = 0; i < krr.length; i++) {
            for (int j = 0; j < krr[0].length; j++) {
                lrr[size + i][size + j] = lock[i][j];
            }
        }
    }

    public static void transfer(int dgree) {
        int n = key.length - 1;
        int m = key[0].length - 1;

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                switch (dgree) {
                    case 90:
                        krr[i][j] = key[n - j][i];
                        break;
                    case 180:
                        krr[i][j] = key[n - i][m - j];
                        break;
                    case 270:
                        krr[i][j] = key[j][m - i];
                }
            }
        }
    }

    public static boolean move() {
        for (int i = 0; i < lrr.length - size; i++) {
            for (int j = 0; j < lrr[i].length - size; j++) {
                boolean flag = true;
                for (int r = 0; r < krr.length; r++) {
                    for (int c = 0; c < krr[r].length; c++) {
                        int k = krr[r][c], l = lrr[i + r][j + c];
                        lrr[i + r][j + c] += krr[r][c];
                        flag = false;
                    }
                }
                System.out.println("lo");
                print(lrr);

                if (flag) return true;
            }
        }
        return false;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
