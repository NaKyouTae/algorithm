package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//4
//1110
//1110
//0110
//0000

//total: 11
//size[1]: 8
//size[2]: 3


//5
//11110
//11110
//01110
//01110
//00000

public class 문5_상품배치추천_세모 {
    public static int ans, N;
    public static int[][] map;
    public static boolean[][] visit;
    public static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        check();

        sb.append("total: ").append(ans).append("\n");

        for (int i = 0; i < res.size(); i++) {
            sb.append("size[" + (i + 1) + "]: ").append(res.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void check() {
        int idx = 1;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (!visit[i][j] && map[i][j] != 0 && i + idx < N && j + idx < N) {
                        visit[i][j] = true;
                        boolean isVisit = true;
                        for (int k = i; k < i + idx; k++) {
                            for (int z = j; z < j + idx; z++) {
                                if (map[k][z] == 0) {
                                    isVisit = false;
                                    break;
                                }
                            }
                        }
                        if (isVisit) cnt++;
                    }

                }
            }
            if (cnt == 0) break;
            else visit = new boolean[N][N];
            idx++;
            res.add(cnt);
            ans += cnt;
        }
    }
}
