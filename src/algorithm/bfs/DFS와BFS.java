package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DFS와BFS {
    public static int N, M, S;
    public static boolean[] dfsVisit;
    public static boolean[] bfsVisit;
    public static Queue<Integer> que = new LinkedList<>();
    public static List<List<Integer>> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        initialize();

        for (int i = 0; i < N; i++) list.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]) - 1;
            int y = Integer.parseInt(str[1]) - 1;
            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i = S - 1; i < N; i++) {
            if (!dfsVisit[i]) {
                dfsVisit[i] = true;
                dfs(i);
            }
        }
        sb.append("\n");
        for (int i = S - 1; i < N; i++) {
            if (!bfsVisit[i]) {
                bfsVisit[i] = true;
                bfs(i);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void initialize() {
        dfsVisit = new boolean[N];
        bfsVisit = new boolean[N];
    }

    public static void dfs(int x) {
        List<Integer> temp = new ArrayList<>();
        sb.append(x + 1).append(" ");

        for (int j = 0; j < list.get(x).size(); j++) {
            int n = list.get(x).get(j);
            if (!dfsVisit[n]) {
                temp.add(n);
            }
        }
        temp = temp.stream().sorted().collect(Collectors.toList());
        for (Integer t : temp) {
            if (!dfsVisit[t]) {
                dfsVisit[t] = true;
                dfs(t);
            }
        }
    }

    public static void bfs(int s) {
        List<Integer> temp = new ArrayList<>();
        que.add(s);

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x + 1).append(" ");
            for (int i = 0; i < list.get(x).size(); i++) {
                int n = list.get(x).get(i);
                if (!bfsVisit[n]) {
                    bfsVisit[n] = true;
                    temp.add(n);
                }
            }

            temp = temp.stream().sorted().collect(Collectors.toList());
            for (Integer t : temp) que.add(t);
            temp = new ArrayList<>();
        }
    }
}
