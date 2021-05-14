package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//4 5
//c.xc
//....
//xx..
//...x
//x..x


//1
public class 문4_시선이동_세모 {
	public static class Node {
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static int N, M, ans = Integer.MAX_VALUE;
	public static String[][] map;
	public static boolean[][] visit;
	public static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		
		map = new String[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j].equals("c")) {
					visit = new boolean[N][M];
					visit[i][j] = true;
					check(i, j);
				}
			}
		}
        
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
	}
	
	public static void check(int x, int y) {
		que.add(new Node(x, y));
		int[] dx = {1, 0, 0};
		int[] dy = {0, -1, 1};
		int cnt = 0;
		
		while(!que.isEmpty()) {
			Node node = que.poll();
				
			for (int i = 0; i < 3; i++) {
				int xx = node.x + dx[i], yy = node.y + dy[i];
				if(xx < N && yy < M && xx >= 0 && yy >= 0) {
					if(xx == N-1) {
						que.clear(); break;
					}
					if(!visit[xx][yy] && !map[xx][yy].equals("x")) {
						visit[xx][yy] = true;
						if(i == 0 && map[xx][yy].equals(".")) {
							que.add(new Node(xx, yy));
							break;
						}else if(i != 0 && map[xx][yy].equals(".")){
							que.add(new Node(xx, yy));
							cnt++;
						}
					}
				}
			}
		}
		ans = Math.min(ans, cnt);
 	}
}
