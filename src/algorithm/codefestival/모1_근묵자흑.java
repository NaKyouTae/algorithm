package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//4 3
//2 3 1 4	// 2

//8 3
//7 3 1 8 4 6 2 5	// 4

//37 4
//31 36 20 30 1 9 6 13 3 29 11 25 7 8 2 24 34 18 26 15 23 28 37 19 21 4 32 14 16 10 12 27 22 35 5 17 33		// 12

public class 모1_근묵자흑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        List<Integer> list = new ArrayList<>();
        int totMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            list.add(val);
            if (totMin > val) totMin = val;
        }

        int cnt = 0, idx = 0;
        while (true) {
            if (idx >= n) break;
            if (idx == 0) idx += m;
            else idx += m - 1;

            cnt++;
        }

        System.out.println(cnt);
    }
}
