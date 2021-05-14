package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_연구소 {
    public static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static Queue<Node> que = new LinkedList<>();
    public static int[][] arr, brr;
    public static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    public static int x, y, max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		x = Integer.parseInt(str[0]);
		y = Integer.parseInt(str[1]);
		
		arr = new int[x][y];
		brr = new int[x][y];
		
		for (int i = 0; i < x; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
	}
	public static void dfs(int cnt) {
		if(cnt == 3) {
			copyLaboratory();
			virusInfection();
			countZero();
		}else {
			// 백트래킹
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						cnt++;
						dfs(cnt);
						arr[i][j] = 0;
						cnt--;
					}
				}
			}
		}
	}
	public static void copyLaboratory() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				brr[i][j] = arr[i][j];
				if(arr[i][j] == 2) {
					que.add(new Node(i, j));
				}
			}
		}
	}
	// bfs
	public static void virusInfection() {
		while(!que.isEmpty()) {
			Node node = que.poll();
			for (int i = 0; i < 4; i++) {
				int xx = dx[i] + node.x, yy = dy[i] + node.y;
				if(xx < x && yy < y && xx >= 0 && yy >= 0) {
					int status = brr[xx][yy];
					if(status == 0) {
						brr[xx][yy] = 2;
						que.add(new Node(xx, yy));
					}
				}
			}
		}
	}
	public static void countZero() {
		int cnt = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int status = brr[i][j];
				if(status == 0) {
					cnt++;
				}
			}
		}
		if(max < cnt) max = cnt;
	}
}
