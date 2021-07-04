package algorithm.studyPersonal;

//https://www.acmicpc.net/problem/9012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class d20210704_bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            Queue<String> que = new LinkedList<>();
            for (int j = 0; j < s.length; j++) {
                if(que.isEmpty()) {
                    que.add(s[j]);
                }else {
                    if(que.peek().equals("(") && s[j].equals(")")) {
                        que.poll();
                    }else {
                        que.add(s[j]);
                    }
                }
            }
            if(que.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb.toString());
    }
}
