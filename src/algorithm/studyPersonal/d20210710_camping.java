package algorithm.studyPersonal;

// https://www.acmicpc.net/problem/4796

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d20210710_camping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(s+m+b == 0) break;

            int cnt = 0;
            while((cnt * m) < b) cnt++;

            int res = s * (cnt-1);
            res += b - (m * (cnt - 1));

            sb.append("Case " + idx++ + ": " + res).append("\n");
        }

        System.out.println(sb.toString());
    }
}
