package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//3
//111		2

//4
//1101		1

//5
//11111		5

public class 문2_배송전략실험_실패 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        String[] load = br.readLine().split("");

        int idx = 0, ans = 0;

        while (true) {
            ans++;

            for (int i = 1; i < 2; i++) {
                if (load[idx + i].equals("1")) idx += i;
                else continue;
            }

            if (idx >= load.length) break;
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}
