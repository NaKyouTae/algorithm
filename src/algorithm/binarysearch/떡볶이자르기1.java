package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//4 6
//19 15 10 17

public class 떡볶이자르기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = list.get(i).size() - 1;
            int center = 0;

            while (right >= left) {
                center = (left + right) / 2;

                sum += (right - center);
                if (sum == c) break;
                left = center + 1;
            }
            if (sum == c) {
                sb.append(center + 1);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
