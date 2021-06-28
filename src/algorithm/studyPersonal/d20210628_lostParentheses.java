package algorithm.studyPersonal;


//55-50+40

//-35

//https://www.acmicpc.net/problem/1541

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class d20210628_lostParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("-");

        long res = Integer.MAX_VALUE;

        for(int i = 0; i < str.length; i++) {
            String[] s = str[i].split("\\+");
            long temp = 0;
            for(int j = 0; j < s.length; j++) {
                temp += Long.parseLong(s[j]);
            }
            if(res == Integer.MAX_VALUE) {
                res = temp;
            }else {
                res -= temp;
            }
        }

        System.out.println(res);
    }
}
