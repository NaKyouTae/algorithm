package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 최댓값과 최솟값
 * */

public class Study6 {
    public static void main(String[] args) {
        String s = "1 2 3 4";

        String[] str = s.split(" ");

        int max = Arrays.stream(str).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(str).mapToInt(Integer::parseInt).min().getAsInt();

        System.out.println(min + " " + max);
    }
}
