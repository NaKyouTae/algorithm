package algorithm.studyGroup.study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//https://www.acmicpc.net/problem/2531

public class rotatingSushi {

    public static int[] sushis;
    public static int nu, ma, di, cp;
    public static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commend = br.readLine().split(" ");

        nu = Integer.parseInt(commend[0]);
        ma = Integer.parseInt(commend[1]);
        di = Integer.parseInt(commend[2]);
        cp = Integer.parseInt(commend[3]);

        sushis = new int[nu];
        Map<Integer, Integer> eat = new HashMap<>();

        eat.put(cp, 1);

        for(int i = 0; i < nu; i++) {
            int sushi = Integer.parseInt(br.readLine());
            sushis[i] = sushi;
            if(i < di) {
                if(eat.containsKey(sushi)) {
                    eat.put(sushi, eat.get(sushi)+1);
                }else {
                    eat.put(sushi, 1);
                }
            }
        }

        for(int i = di; i < sushis.length + di; i++) {
            System.out.println(eat.toString());
            counting(eat.size());

            int e = sushis[Math.abs(di-i)];

            if(eat.containsKey(e) && eat.get(e) > 1) {
                eat.put(e, eat.get(e)-1);
            }else {
                eat.remove(e);
            }

            int sushi = sushis[(i >= sushis.length) ? Math.abs(sushis.length - i) : i];

            System.out.println("e : " + e + ", sushi : " + sushi);
            if(!eat.containsKey(sushi)) {
                eat.put(sushi, 1);
            }else {
                eat.put(sushi, eat.get(sushi)+1);
            }
        }

        System.out.println(max);
    }

    public static void counting(int num) {
        max = Math.max(num, max);
    }
}
