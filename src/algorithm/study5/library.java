package algorithm.study5;

//7 2
//-37 2 -6 -39 -29 11 -28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1461
public class library {
    public static int max, num, res;
    public static List<Integer> plusList = new ArrayList<>();
    public static List<Integer> minusList = new ArrayList<>();
    public static Comparator<Integer> compare = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > 0 && o2 > 0) {
                return (o1 > o2) ? -1:(o1 == o2) ? 0:1;
            }

            return (o1 > o2) ? 1:(o1 == o2) ? 0:-1;
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        num = Integer.parseInt(strs[0]);
        max = Integer.parseInt(strs[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            if(val > 0) plusList.add(val);
            if(val < 0) minusList.add(val);
        }

        Collections.sort(plusList, compare);
        Collections.sort(minusList, compare);

        System.out.println(plusList.toString());
        System.out.println(minusList.toString());

        int cnt = 0;
        for(int i = 0; i < plusList.size(); i += cnt){
            cnt = 0;
            int select = 0;
            for(int j = 0; j < max; j++) {
                if(i + j < plusList.size()) {
                    select = Math.max(select, Math.abs(plusList.get(i + j)));
                    cnt++;
                }
            }
            System.out.println(select * 2);
            res += select * 2;
            if(i+cnt > plusList.size()) break;
        }

        cnt = 0;
        for(int i = 0; i < minusList.size(); i += cnt){
            cnt = 0;
            int select = 0;
            for(int j = 0; j < max; j++) {
                if(i + j < minusList.size()){
                    select = Math.max(select, Math.abs(minusList.get(i + j)));
                    cnt++;
                }
            }
            System.out.println(select * 2);
            res += select * 2;
            if(i+cnt > minusList.size()) break;
        }

        int minus = Math.max(Math.abs(plusList.get(0)), Math.abs(minusList.get(0)));
        System.out.println(res);
        System.out.println(res - minus);
    }
}
