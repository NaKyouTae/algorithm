package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//4
//12 0
//10 14
//4 20
//5 2147483648

//1
//2
//0
//1

public class 모2_사은품교환하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            String[] str = br.readLine().split(" ");

            long n = Long.parseLong(str[0]);
            long m = Long.parseLong(str[1]);
            long ans = 0;

            ans = (n / 5 <= m / 7) ? n / 5 : m / 7;

            if (ans > 0) n -= 5 * ans;
            m -= 7 * ans;
            if (n >= 5 && m > 0 && n + m >= 12) {
                n -= 12 - m;
                m = 0;
                ans++;
            }
            if (n >= 12) ans += n / 12;

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
