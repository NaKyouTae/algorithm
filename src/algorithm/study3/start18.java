package algorithm.study3;

import java.util.Scanner;

public class start18 {
    public static String[][] map;
    public static int level, width;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        level = (int) Math.pow(2, num);
        width = (int) Math.pow(2, num+1) - 1;

        map = new String[level][width];

        branch(num, 0, 0);

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] != null) System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public static void branch(int num, int nx, int ny) {
        if(num == 0) return;

        int level = (int) Math.pow(2, num) - 1;
        int width = (int) Math.pow(2, num+1) - 3;
        int n_width = (int) Math.pow(2, num) - 3;

        if(num % 2 == 1) {
            oddStar(num, nx, ny);
        }else {
            evenStar(num, nx, ny);
        }

        branch(num-1, level / 2, (width-n_width) / 2);
    }
    public static void oddStar(int num, int nx, int ny) {
        int level = (int) Math.pow(2, num) - 1;
        int width = (int) Math.pow(2, num+1) - 3;

        for(int i = nx; i < nx + level; i++) {
            for(int j = ny; j <= ny + (width/2)+i; j++) {
                if(j == ny + (width/2) - i || j == ny + (width/2) + i || i == level - 1) {
                    map[i][j] = "*";
                }else {
                    map[i][j] = " ";
                }
            }
        }
    }

    public static void evenStar(int num, int nx, int ny) {
        int level = (int) Math.pow(2, num) - 1;
        int width = (int) Math.pow(2, num+1) - 3;

        for(int i = nx; i < nx + level; i++) {
            for(int j = ny; j <= ny + width - i; j++) {
                if(j == j + i || j == ny + width - i || i == nx) {
                    map[i][j] = "*";
                }else {
                    map[i][j] = " ";
                }
            }
        }
    }
}
