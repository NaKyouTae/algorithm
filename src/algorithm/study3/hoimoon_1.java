package algorithm.study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//7
//abba
//summuus
//xabba
//xabbay
//comcom
//comwwmoc
//comwwtmoc

public class hoimoon_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            int left = 0;
            int right = 0;
            int status = 0;

            int len = str.length();
            int cnt = str.length() / 2;

            for (int j = 0; j < cnt; j++) {
                if (status == 2) break;
                if (status == 1) {
                    boolean isOk = false;
                    if ((left != 0 && str.charAt(j + left) == str.charAt(len - j - 1))
                            || (right != 0 && str.charAt(j) == str.charAt(len - j - 1 - right))) isOk = true;

                    if (!isOk) {
                        status++;
                        break;
                    }
                } else {
                    if (str.charAt(j + left) != str.charAt(len - 1 - j - right)) {
                        status++;
                        if (str.charAt(j + left) == str.charAt(len - j - 1 - right)) left++;
                        if (str.charAt(j) == str.charAt(len - j - 2)) right++;
                        j--;
                    }
                }
            }

            sb.append(status).append("\n");
        }

        System.out.println(sb.toString());
    }
}
