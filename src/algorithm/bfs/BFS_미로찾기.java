package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.junit.Test;

public class BFS_미로찾기 {
	public static class Node {
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static Queue<Node> que = new LinkedList<>();
	public static int[][] arr;
	public static int[][] visit;
	public static int x, y;
	@Test
	public void test() throws IOException {
		run();
	}
	
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		arr = new int[x][y];
		visit = new int[x][y];
		
		for (int i = 0; i < x; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		BFS();
		
		bw.write(Integer.toString(visit[x-1][y-1]));
		bw.flush();
		bw.close();
	}
	
	public static void BFS() {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		
		que.add(new Node(0, 0));
		visit[0][0] = 1;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int h = node.x;
			int w = node.y;
			
			for (int i = 0; i < 4; i++) {
				int xx = dx[i] + h, yy = dy[i] + w;
				if(xx < x && yy < y && xx >= 0 && yy >= 0) {
					if(arr[xx][yy] == 1 && visit[xx][yy] == 0) {
						visit[xx][yy] = visit[h][w] + 1;
						Node node1 = new Node(xx, yy);
						que.add(node1);
					}
				}
			}
		}
	}
}
