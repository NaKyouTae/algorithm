package algorithm.studyPersonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//10 4200
//1
//5
//10
//50
//100
//500
//1000
//5000
//10000
//50000

//https://www.acmicpc.net/problem/11047
public class d20210624_coin0 {
    public static List<Integer> coins = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commends = br.readLine().split(" ");

        int n = Integer.parseInt(commends[0]);
        int tot = Integer.parseInt(commends[1]);

        for(int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins.add(coin);
        }

        coins.sort(Collections.reverseOrder());

        int cnt = 0;

        for(int i = 0; i < coins.size(); i++) {
            int unit = coins.get(i);

            if(unit <= tot) {
                int div = tot/unit;
                cnt += div;
                tot = tot - (div * unit);
            }
        }

        System.out.println(cnt);
    }
}
