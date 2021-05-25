package algorithm.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//4
//5 1 7 9

public class 안테나 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            list.add(val);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int search = binarySearch(i, 0, N - 1, (N - 1) / 2);
            if (min > search) min = search;
        }

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int idx, int left, int right, int center) {

        int sum = center - idx;
        if (right >= left) return sum;
        sum += binarySearch(idx, left, center - 1, (left + center - 1) / 2);
        sum += binarySearch(idx, center + 1, right, (center + 1 + right) / 2);

        return sum;
    }
}
