package algorithm.study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class spica {
    public static int[] map;
    public static int ans = 0;
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
            list.get(e).add(s);
            map[e]++;
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.printf(i + " : ");
        	for(int j = 0; j < list.get(i).size(); j++) {
                System.out.printf(list.get(i).get(j) + " ");
        	}
            System.out.println();
        }


        for(int i = 0; i < list.size(); i++) {
            int cnt = 0;

            if(list.get(i).size() == 3) {
                for(int j = 0; j < 3; j++) {
                    if(list.get(list.get(i).get(j)).size() == 3) cnt++;
                    if(list.get(list.get(i).get(j)).size() == 2) cnt++;
                    if(list.get(list.get(i).get(j)).size() == 1) cnt++;
                }
            }

            if(cnt == 3) ans = i;
        }

        System.out.println(ans);
    }
}
