package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2
//5 6
//......
//.939..
//.3428.
//.9393.
//......
//10 10
//..........
//.99999999.
//.9.323239.
//.91444449.
//.91444449.
//.91444449.
//.91444449.
//.91232329.
//.99999999.
//..........

public class BFS_모래성쌓기4 {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int x, y;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int c = 0; c < T; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            arr = new int[x][y];
            visit = new boolean[x][y];

            for (int i = 0; i < x; i++) {
                String str = br.readLine();
                for (int j = 0; j < y; j++) {
                    int val = str.charAt(j) - '0';
                    if (val >= 1 && val <= 9) {
                        arr[i][j] = val;
                    } else {
                        visit[i][j] = true;
                        que.add(new Node(i, j));
                    }
                }
            }

            int cnt = 0;
            while (!que.isEmpty()) {
                cnt++;
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    Node node = que.poll();
                    for (int j = 0; j < 8; j++) {
                        int xx = dx[j] + node.x, yy = dy[j] + node.y;
                        if (xx < x && yy < y && xx >= 0 && yy >= 0) {
                            int val = arr[xx][yy];
                            if (!visit[xx][yy] && val != 0 && val != 9) {
                                arr[xx][yy]--;
                            }

                            if (!visit[xx][yy] && arr[xx][yy] == 0) {
                                visit[xx][yy] = true;
                                que.add(new Node(xx, yy));
                            }
                        }
                    }
                }
            }

            sb.append("#").append(c + 1).append(" ").append(cnt - 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
