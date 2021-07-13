package algorithm.studyPersonal;

//4
//2 3 1
//5 2 4 1

// https://www.acmicpc.net/problem/13305

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class d20210710_gasStation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String[] dis = br.readLine().split(" ");
        String[] amounts = br.readLine().split(" ");

        long min = Long.parseLong(amounts[0]), tot = 0;

        for (int i = 0; i < dis.length; i++) {
            long d = Long.parseLong(dis[i]);
            long a = Long.parseLong(amounts[i]);

            if(a < min) min = a;

            tot += (min * d);
        }

        System.out.println(tot);
    }
}
