package algorithm.solved;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class P5 {
    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int num = rand.nextInt(10);


        int[] height = new int[num];


        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println(i + "번째 키 : " + height[i]);
        }

        System.out.println("최대 키는 : " + max(height) + " 입니다.");
    }

    public int max(int[] array) {
        int max = array[0];


        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }

        return max;
    }
}
