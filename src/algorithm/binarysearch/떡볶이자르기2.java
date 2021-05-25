package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//4 6
//19 15 10 17

public class 떡볶이자르기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);

        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }

        int left = 0;
        int right = max;

        int cut = 0;
        while (right >= left) {
            int sum = 0;
            int center = (left + right) / 2;
            for (int i = 0; i < arr.length; i++) {
                if (center < arr[i]) {
                    sum += arr[i] - center;
                }
            }
            if (sum < c) {
                right = center - 1;
            } else {
                cut = center;
                left = center + 1;
            }
        }

        bw.write(Integer.toString(cut));
        bw.flush();
        bw.close();
    }
}
