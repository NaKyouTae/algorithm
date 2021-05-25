package algorithm.study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//9
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1

//https://www.acmicpc.net/problem/1780

public class 종이의개수_1_실패 {
    public static int N;
    public static int[][] map;
    public static int[] res = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isCheck = check(0, N, 0, N);

        if (isCheck) {
            int v = map[0][0];
            if (v == -1) {
                res[2]++;
            } else {
                res[v]++;
            }
        } else {
            slice(0, 0);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static void slice(int s, int e) {
        if (check(s, s + 3, e, e + 3)) {
            int v = map[0][0];
            if (v == -1) {
                res[2]++;
            } else {
                res[v]++;
            }
        } else {
            for (int i = s; i < s + 3; i++) {
                for (int j = e; j < e + 3; j++) {
                    slice(s + (N / 3) * i, e + (N / 3) * j);
                }
            }
        }
    }

    public static boolean check(int ss, int se, int es, int ee) {
        List<Integer> list = new ArrayList<>();

        for (int i = ss; i < se; i++) {
            for (int j = es; j < ee; j++) {
                if (!list.contains(map[i][j])) {
                    list.add(map[i][j]);
                }

                if (list.size() > 1) {
                    break;
                }
            }
        }

        return list.size() > 1 ? false : true;
    }
}
