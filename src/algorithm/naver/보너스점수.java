package algorithm.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보너스점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            String t = String.valueOf(s.charAt(i));
            if (t.equals("O")) {
                sum += (i + 1) + count++;
            } else {
                count = 0;
            }
        }

        System.out.println(sum);
    }
}
