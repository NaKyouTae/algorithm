package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11660

public class 구간합구하기5_bfs_실패 {
	public static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int[][] arr;
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	public static boolean[][] visit;
	public static int x, y, r, c, sum;
	public static Queue<Node> que = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());						
			}
		}
		
		for (int k = 0; k < m; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			
			visit = new boolean[n][n];
			
			sum = arr[x][y];
			visit[x][y] = true;
			
			bfs();
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void bfs() {
		que.add(new Node(x, y));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = node.x + dx[i], yy = node.y + dy[i];
				if(xx <= r && yy <= c && yy >= node.y && xx >= node.x) {
					if(!visit[xx][yy]) {
						visit[xx][yy] = true;
						sum += arr[xx][yy];
						que.add(new Node(xx, yy));
					}
				}
			}
		}
		
		sb.append(sum).append("\n");
	}
}
