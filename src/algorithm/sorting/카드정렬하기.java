package algorithm.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            list.add(val);
        }

        Collections.sort(list);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.addAll(list);

        int sum = 0;
        while (que.size() > 1) {
            int a = que.poll();
            int b = que.poll();

            sum += a + b;
            que.add(a + b);
        }


        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
}
