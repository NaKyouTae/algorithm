package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2
//10 8 17
//0 0
//1 0
//1 1
//4 2
//4 3
//4 5
//2 4
//3 4
//7 4
//8 4
//9 4
//7 5
//8 5
//9 5
//7 6
//8 6
//9 6
//10 10 1
//5 5


//https://www.acmicpc.net/problem/1012

public class 유기농배추 {
	public static int X, Y;
	public static int[][] arr;
	public static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			
			X = Integer.parseInt(s[0]);
			Y = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
			
			arr = new int[X][Y];
			visit = new boolean[X][Y];
			
			for (int i = 0; i < k; i++) {
				String[] location = br.readLine().split(" ");
				int n = Integer.parseInt(location[0]);
				int m = Integer.parseInt(location[1]);
				arr[n][m] = 1;
			}
			
			int cnt = 0;
			
			for (int i = 0; i < X; i++) {
				for (int j = 0; j < Y; j++) {
					if(!visit[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i], yy = y + dy[i];
			if(xx < X && yy < Y && xx >= 0 && yy >= 0) {
				if(!visit[xx][yy] && arr[xx][yy] == 1) {
					visit[xx][yy] = true;
					dfs(xx, yy);
				}
			}
		}
	}
}
