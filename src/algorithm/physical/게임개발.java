package algorithm.physical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//4 4
//1 1 0
//1 1 1 1
//1 0 0 1
//1 1 0 1
//1 1 1 1

public class 게임개발 {
	public static class Node {
		int x, y, d;
		Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int cnt, N, M;
	public static boolean[][] visit;
	public static Queue<Node> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[0]);
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		String[] location = br.readLine().split(" ");
		
		int x = Integer.parseInt(location[0]);
		int y = Integer.parseInt(location[1]);
		int d = Integer.parseInt(location[2]);
		
		visit[x-1][y-1] = true;
		que.add(new Node(x, y, d));
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
	
	public static void bfs() {
		while(!que.isEmpty()) {
			Node node = que.poll();
			for(int i = 0; i < 4; i++) {
				int xx = node.x + dx[i], yy = node.y + dy[i];
				if(xx < N && yy < M && xx >= 0 && yy >= 0) {
					if(!visit[xx][yy] && arr[xx][yy] != 1) {
						cnt++;
						visit[xx][yy] = true;
						que.add(new Node(xx, yy, i));
					}
				}
			}
		}
	}
}
