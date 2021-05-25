package algorithm.solved;

import org.junit.Test;

/**
 * @author nkt
 * P. 305 8-3
 * <p>
 * Create by User Date : 2020. 12. 28.
 */
public class P51BM {
    @Test
    public void test() {
        String t = "abcxdezcabacabac";
        String p = "abac";

        System.out.println(boyerMoore(t, p));
    }

    public int boyerMoore(String t, String p) {
        int pt = 0;
        int pp = 0;
        int tl = t.length();
        int pl = p.length();
        int[] s = new int[Character.MAX_VALUE + 1];
        int count = 0;

        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            s[pt] = pl;
        }
        for (pt = 0; pt < pl - 1; pt++) {
            s[p.charAt(pt)] = pl - pt - 1;
        }

        while (pt < tl) {
            pp = pl - 1;

            System.out.println(t);
            dispD(pt, t.charAt(pt) == p.charAt(pp));
            dispSpace(pt - pp);
            System.out.println(p);
            count++;
            while (t.charAt(pt) == p.charAt(pp)) {
                if (pp == 0) {
                    System.out.println("비교 횟수 : " + count);
                    return pt;
                }
                pp--;
                pt--;

                System.out.println(t);
                dispD(pt, t.charAt(pt) == p.charAt(pp));
                dispSpace(pt - pp);
                System.out.println(p);
                count++;
            }


            pt += (s[t.charAt(pt)] > pl - pp) ? s[t.charAt(pt)] : pl - pp;
        }
        System.out.println("비교 횟수 : " + count);
        return -1;
    }

    public void dispSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" ");
        }
    }

    public void dispD(int n, boolean f) {
        dispSpace(n);
        System.out.printf(f == true ? "+" : "|");
        System.out.println();

    }
}
