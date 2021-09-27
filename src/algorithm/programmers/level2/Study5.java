package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Collections;

/**
 * 두 배열의 곱셈을 총 합중 최소값 구하기
 * */
public class Study5 {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 2};
//        int[] brr = {5, 4, 4};
        int[] arr = {1, 2};
        int[] brr = {3, 4};

        Integer[] sortB = Arrays.stream(brr).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

        int sum = 0;
        for(int i = 0 ; i < arr.length; i++) {
            sum += arr[i] * sortB[i];
        }

        System.out.println(sum);
    }
}
