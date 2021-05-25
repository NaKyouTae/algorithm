package algorithm.solved;

import org.junit.Test;

public class P10 {

    static int[][] mday = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };

    @Test
    public void test() {
        int year = 2020;
        int month = 11;
        int day = 29;

        System.out.println(dayOfYears(year, month, day));
        System.out.println(leftDayOfYear(year, month, day));
    }

    public static int dayOfYears(int y, int m, int d) {

        int count = 0;

        while (count != m - 1) {
            d += mday[isLeap(y)][count++];
        }

        return d;
    }

    public static int isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) ? 1 : 0;
    }

    public static int leftDayOfYear(int y, int m, int d) {
        return dayOfYears(y, 12, 31) - dayOfYears(y, m, d);
    }
}
