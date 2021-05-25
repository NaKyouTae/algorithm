package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 떡볶이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int count = Integer.parseInt(str[0]);
        int want = Integer.parseInt(str[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int cut = 1;
        int sum = 0;
        while (true) {
            if (sum == want) break;
            cut++;
            sum = 0;

            if (list[idx] > cut) sum += list[idx] - cut;
            if (list[idx + 1] > cut) sum += list[idx + 1] - cut;
            if (list[idx + 2] > cut) sum += list[idx + 2] - cut;
            if (list[idx + 3] > cut) sum += list[idx + 3] - cut;

        }

        bw.write(Integer.toString(cut));
        bw.flush();
        bw.close();
    }
}
//4 6
//19 15 10 17