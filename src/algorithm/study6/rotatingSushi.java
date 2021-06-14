package algorithm.study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


//https://www.acmicpc.net/problem/2531

public class rotatingSushi {

    public static int nu, ma, di, cp;
    public static int max = Integer.MIN_VALUE;
    public static List<Integer> sushis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commend = br.readLine().split(" ");

        nu = Integer.parseInt(commend[0]);
        ma = Integer.parseInt(commend[1]);
        di = Integer.parseInt(commend[2]);
        cp = Integer.parseInt(commend[3]);


        sushis = new ArrayList<>();

        for(int i = 0; i < nu; i++) {
            int sushi = Integer.parseInt(br.readLine());
            sushis.add(sushi);
        }

        int s = (nu / 2) - 1 + di;
        int e = (nu - s);

        for(int i = 0; i < sushis.size() - (di - 1); i++) {
            List<Integer> one = new ArrayList<>();
            List<Integer> two = new ArrayList<>();

            int oc = 0, tc = 0, o, t;
            if(i < s) one = sushis.subList(i, i+di);
            if(i >= e) two = sushis.subList(i, i+di);

            List<Integer> oDisc = new ArrayList<>();
            List<Integer> tDisc = new ArrayList<>();

            for(int j = 0; j < di; j++) {
                if(one.size() > 0 && one.size() <= di) {
                    if(one.get(j) == cp) oc++;
                    if(!oDisc.contains(one.get(j))) oDisc.add(one.get(j));
                }

                if(two.size() > 0 && two.size() <= di) {
                    if(two.get(j) == cp) tc++;
                    if(!tDisc.contains(two.get(j))) tDisc.add(two.get(j));
                }
            }

            int os = (oc == 0) ? oDisc.size()+1 : oDisc.size();
            int ts = (tc == 0) ? tDisc.size()+1 : tDisc.size();
            int m = Math.max(os, ts);

            dishsCounting(m);
        }

        System.out.println(max);
    }

    public static void dishsCounting(int num) {
        max = Math.max(num, max);
    }
}
