package algorithm.studyGroup.study3;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10993

public class start18 {
    public static String[][] map;
    public static int level, width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int level = (int) Math.pow(2, num + 1) - 3;
        int width = (int) Math.pow(2, num) - 1;

        map = new String[width + 1][level + 1];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < level; j++) {
                map[i][j] = " ";
            }
        }

        branch(num, 0, 0);

        StringBuilder sb = new StringBuilder();
        if(num % 2 == 0) {
            for(int i = 0; i < level; i++) {
                for(int j = 0; j < width - i; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }else {
            for(int i = 0; i < width; i++) {
                for(int j = 0; j < level - width + i + 1; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void branch(int num, int nx, int ny) {
        if (num == 1) {
            map[nx][ny] = "*";
            return;
        }

        level = (int) Math.pow(2, num + 1) - 3;
        width = (int) Math.pow(2, num) - 1;

        System.out.println("nx : " + nx + " ny : " + ny);
        if (num % 2 == 0) {
            for (int i = nx; i < level + nx; i++) {
                map[ny][i] = "*";
            }
            for (int i = 0; i < width; i++) {
                map[ny+i][nx+i] = "*";
                map[ny+i][nx+level-1-i] = "*";
            }
            branch(num - 1, (int) Math.pow(2, num - 1) + nx,  ny + 1);
        } else {
            for (int i = nx; i < level + nx; i++) {
                map[ny+width-1][i] = "*";
            }
            for (int i = 0; i < width; i++) {
                map[ny+i][nx + level % 2 - i] = "*";
                map[ny+i][nx + level % 2 + i] = "*";
            }

            branch(num - 1, (int) Math.pow(2, num - 1) + nx,  ny  + (width % 2));
        }
    }
}
