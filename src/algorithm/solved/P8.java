package algorithm.solved;

import org.junit.Test;

public class P8 {
    @Test
    public void test() {
        char[] c = new char[32];
        int num = convReserve(59, 8, c);

        for (int i = num - 1; i >= 0; i--) {
            System.out.print(c[i]);
        }
    }

    public int convReserve(int x, int r, char[] d) {
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int digits = 0;

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }
}
