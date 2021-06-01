package algorithm.study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class spica {
    public static int ans = 0;
    public static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        for(int i = 0; i <= 12; i++) list.add(new ArrayList<>());
        while(!(str = br.readLine()).equals("")) {
            StringTokenizer st = new StringTokenizer(str, " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        for(int i = 0; i < list.size(); i++) {
            boolean first = false, second = false, third = false;
            if(list.get(i).size() == 3) {
                for(int j = 0; j < 3; j++) {
                    int side = list.get(list.get(i).get(j)).size();

                    if(!third && side == 3) third = true;
                    if(!second && side == 2) second = true;
                    if(!first && side == 1) first = true;
                }
            }

            if(third && second && first) ans = i;
        }

        System.out.println(ans);
    }
}
