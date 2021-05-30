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
            map[e]++;
        }
        for(int i = 0; i < list.size(); i++) {
        	for(int j = 0; j < list.get(i).size(); j++) {
        		System.out.println(i + " , " + j + " : " + list.get(i).get(j) + " cnt : " + map[i]);
        	}
        }
        for(int i = 0; i < map.length; i++) {
            if(map[i] == 2) {
                if(list.get(i).size() == 1) {
                	int check = list.get(i).get(0);
                    if(list.get(check).size() == 0) {
                    	System.out.println(list.get(i).get(0));
                        ans = i;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
