package algorithm.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BinaryGap {
    @Test
    public void test() {
        int n = 32;
        int a = n;

        List<Integer> list = new ArrayList<>();
        while (a > 0) {
            list.add(a % 2);
            a /= 2;
        }

        Collections.reverse(list);

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (Integer l : list) {
            if (l == 1) {
                result.add(cnt);
                cnt = 0;
            } else if (l == 0) {
                cnt++;
            }
        }

        int max = 0;
        for (int i = 1; i < result.size(); i++) {
            int v = result.get(i);
            if (max < v) max = v;
        }

        System.out.println(max);
    }
}
