package algorithm.physical;
//5
//R R R U D D

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


//이것이 코딩테스트다 110페이지
public class 상하좌우_사방탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        List<String> type = new ArrayList<>(Arrays.asList("L", "U", "R", "D"));
        int x = 1, y = 1;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();

            int idx = type.indexOf(str);

            int xx = x + dx[idx], yy = y + dy[idx];
            if (xx < n && yy < n && xx > 0 && yy > 0) {
                x = xx;
                y = yy;
            }
        }

        bw.write(Integer.toString(x) + " " + Integer.toString(y));
        bw.flush();
        bw.close();
    }
}
