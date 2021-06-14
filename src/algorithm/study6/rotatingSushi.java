package algorithm.study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


//https://www.acmicpc.net/problem/2531

public class rotatingSushi {

    public static int nu, ma, di, cp;
    public static int max = Integer.MIN_VALUE;
    public static Queue<Integer> sushis = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commend = br.readLine().split(" ");

        nu = Integer.parseInt(commend[0]);
        ma = Integer.parseInt(commend[1]);
        di = Integer.parseInt(commend[2]);
        cp = Integer.parseInt(commend[3]);

        Map<Integer, Integer> eat = new HashMap<>();

        eat.put(cp, 1);

        for(int i = 0; i < nu; i++) {
            int sushi = Integer.parseInt(br.readLine());
            sushis.add(sushi);
            if(i < di) {
                if(eat.containsKey(sushi)) {
                    eat.put(sushi, eat.get(sushi)+1);
                }else {
                    eat.put(sushi, 1);
                }
            }
        }

        for(int i = di; i < sushis.size() + di; i++) {
            System.out.println(eat.toString());
            counting(eat.size());

            int e = getHashMap(eat, 0);

            if(eat.containsKey(e) && eat.get(e) >= 2) {
                eat.put(e, eat.get(e)-1);
            }else {
                eat.remove(e);
            }

            int sushi = getQueue(sushis, (i >= sushis.size()) ? sushis.size() - i : i);

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
    public static int getQueue(Queue<Integer> que, int idx) {
        Iterator<Integer> iter = que.iterator();
        int res = 0;
        for(int i = 0; i <= idx; i++) res = iter.next();
        return res;
    }
    public static int getHashMap(Map<Integer, Integer> map, int idx) {
        Iterator<Integer> iter = map.keySet().iterator();
        int res = 0;
        for(int i = 0; i <= idx; i++) res = iter.next();
        return res;
    }
}
