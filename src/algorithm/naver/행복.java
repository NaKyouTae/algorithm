package algorithm.naver;

import static org.junit.Assert.*;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

//https://www.acmicpc.net/problem/15969
public class 행복 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String s = sc.nextLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            max = Math.max(max, v);
            min = Math.min(min, v);
        }

        System.out.println(max - min);
    }
}
