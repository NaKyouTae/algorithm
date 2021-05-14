package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//5 3 1
//0 -1 0 0 0
//-1 -1 0 1 1
//0 0 0 1 1

//-1

//5 3 2
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 1 0 0
//0 0 0 0 0

//4

//4 3 2
//1 1 1 1
//1 1 1 1
//1 1 1 1
//1 1 1 1
//-1 -1 -1 -1
//1 1 1 -1

//0

//https://www.acmicpc.net/problem/7569
	
public class 토마토 {
	public static class Node {
		int x, y, h, s;
		Node(int x, int y, int h, int s) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.s = s;
		}
	}
	public static int X, Y, H, cnt;
	public static int[][][] arr;
	public static boolean[][][] visit;
	public static Queue<Node> que = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		Y = Integer.parseInt(str[0]);
		X = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);
		
		arr = new int[X][Y][H];
		visit = new boolean[X][Y][H];
		
		boolean isSuccessed = true;
		
		for (int f = 0; f < H; f++) {
			for (int i = 0; i < X; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < Y; j++) {
					int v = Integer.parseInt(st.nextToken());
					if(v == 0) isSuccessed = false;
					if(v == 1) {
						que.add(new Node(i, j, f, 0));
						visit[i][j][f] = true;
					}
					arr[i][j][f] = v;
				}
			}
		}
		
		if(isSuccessed) {
			System.out.println("0");
		}else {
			bfs();
			
			boolean isCompleted = true;
			
			for (int f = 0; f < H; f++) {
				for (int i = 0; i < X; i++) {
					for (int j = 0; j < Y; j++) {
						int v = arr[i][j][f];
						if(v == 0) isCompleted = false;
					}
				}
			}
			
			if(isCompleted) {
				System.out.println(cnt-1);
			}else {
				System.out.println("-1");
			}
			
		}
	}
	
	public static void bfs() {
		int[] dx = {0, -1, 0, 1, 0, 0};
		int[] dy = {-1, 0, 1, 0, 0, 0};
		int[] dh = {0, 0, 0, 0, -1, 1};
		
		while(!que.isEmpty()) {
			int size = que.size();
			cnt++;
			for (int i = 0; i < size; i++) {				
				Node node = que.poll();
				
				for (int j = 0; j < 6; j++) {
					int xx = node.x + dx[j], yy = node.y + dy[j], hh = node.h + dh[j];
					if(xx < X && yy < Y && hh < H && xx >= 0 && yy >= 0 && hh >= 0) {
						if(!visit[xx][yy][hh] && arr[xx][yy][hh] == 0) {
							visit[xx][yy][hh] = true;
							arr[xx][yy][hh] = node.s + 1;
							que.add(new Node(xx, yy, hh, node.s + 1));
						}
					}
				}
			}
		}
 	}
 }
