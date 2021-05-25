package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//4
//Baha enter
//Askar enter
//Baha leave
//Artem enter

//https://www.acmicpc.net/problem/7785
public class 회사에있는사람 {
    public static Comparator<String> compare = new Comparator<>() {

        @Override
        public int compare(String o1, String o2) {
            int min = Math.min(o1.length(), o2.length());

            int res = 0;
            for (int i = 0; i < min; i++) {
                if (o1.charAt(i) > o2.charAt(i)) {
                    res = -1;
                    break;
                } else if (o1.charAt(i) < o2.charAt(i)) {
                    res = 1;
                    break;
                }
            }
            if (res == 0) {
                if (o1.length() > o2.length()) {
                    res = -1;
                } else {
                    res = 1;
                }
            }

            return res;
        }

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            String[] str = br.readLine().split(" ");
            String nm = str[0];
            String is = str[1];

            if (map.containsKey(nm)) {
                if (is.equals("enter")) {
                    map.put(nm, map.get(nm) + 1);
                } else {
                    map.put(nm, map.get(nm) - 1);
                }
            } else {
                if (is.equals("enter")) {
                    map.put(nm, 1);
                }
            }
        }

        List<String> list = new ArrayList<>();
        map.entrySet().forEach(item -> {
            if (item.getValue() > 0) {
                list.add(item.getKey());
            }
        });

        Collections.sort(list, compare);

        list.forEach(item -> {
            sb.append(item).append("\n");
        });

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
