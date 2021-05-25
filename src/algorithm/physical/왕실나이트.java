package algorithm.physical;

import java.util.Scanner;

public class 왕실나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String location = sc.next();

        int y = location.charAt(0) - 'a';
        int x = location.charAt(1) - '1';

        int[] dx = {-1, 1, -2, -2, -1, 1, 2, 2};
        int[] dy = {-2, -2, -1, 1, 2, 2, -1, 1};

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx < 8 && yy < 8 && xx >= 0 && yy >= 0) {
                System.out.println("x : " + (xx + 1) + ", yy : " + (yy + 1));
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
