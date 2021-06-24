package algorithm.studyPersonal;

//5
//3 1 4 3 2

//https://www.acmicpc.net/problem/11399

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class d20210623_ATM {
    public static Comparator<Integer> compare = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    };
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            int person = Integer.parseInt(st.nextToken());
            list.add(person);
        }

        list.sort(compare);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            max += sum;
        }

        System.out.println(max);
    }
}
