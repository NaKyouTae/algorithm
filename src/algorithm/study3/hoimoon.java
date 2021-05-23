package algorithm.study3;

//7
//abba
//summuus
//xabba
//xabbay
//comcom
//comwwmoc
//comwwtmoc

//https://www.acmicpc.net/problem/17609

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hoimoon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++) {
            String str = br.readLine();

            int status = 0;
            int left = 0;
            int right = 0;

            int len = str.length();

            for(int j = 0; j < str.length()/2; j++) {
                if(status == 2) break;
                if(status == 1) {
                    boolean isOk = false;
                    if(str.charAt(j+left) == str.charAt(len-j-1) || str.charAt(j) == str.charAt(len-j-1-right)) isOk = true;

                    if(!isOk) {
                        status++;
                        break;
                    }
                }else {
                    if(str.charAt(j+left) != str.charAt(len-1-j-right)) {
                        status++;
                        if(str.charAt(j+1) == str.charAt(len-j-1-right)) left++;
                        if(str.charAt(j) == str.charAt(len-j-2)) right++;
                        j--;
                    }
                }
            }

            sb.append(status).append("\n");
        }

        System.out.println(sb.toString());
    }
}
