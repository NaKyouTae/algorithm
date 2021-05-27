package algorithm.study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class spica {
    public static int[] map;
    public static int ans = 0, first = 0;
    public static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        map = new int[13];
        for(int i = 0; i <= 12; i++) list.add(new ArrayList<>());
        while(!(str = br.readLine()).equals("")) {
            StringTokenizer st = new StringTokenizer(str, " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            map[e]++;
        }

        for(int i = 0; i < map.length; i++) {
            if(map[i] == 2) {
                if(list.get(i).size() == 1) ans = i;
            }
        }

        System.out.println(ans);
    }
}