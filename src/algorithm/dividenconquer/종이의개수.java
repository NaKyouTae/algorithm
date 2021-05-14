package algorithm.dividenconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//9
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1

//https://www.acmicpc.net/problem/1780
	
public class 종이의개수 {
	public static int N;
	public static int[][] map;
	public static int[] res = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(res[2]).append("\n");
		sb.append(res[0]).append("\n");
		sb.append(res[1]).append("\n");
		
		System.out.println(sb.toString());
	}
	
	public static void divide(int r, int c, int s) {
		if(checkNum(r, c, s)) {
			int num = map[r][c];
			if(num == -1) {
				res[2]++;
			}else {
				res[num]++;
			}
			
			return;
		}
		
		int ns = s/3;
		
		divide(r, c, ns);
		
		divide(r, c+ns, ns);
		divide(r, c+ns*2, ns);
		
		divide(r+ns, c, ns);
		divide(r+ns*2, c, ns);
		
		divide(r+ns, c+ns, ns);
		divide(r+ns, c+ns*2, ns);
		
		divide(r+ns*2, c+ns, ns);
		divide(r+ns*2, c+ns*2, ns);
	}
	
	public static boolean checkNum(int r, int c, int s) {
		int num = map[r][c];
		
		for(int i = r; i < r+s; i++) {
			for (int j = c; j < c+s; j++) {
				if(map[i][j] != num) return false;
			}
		}
		
		return true;
	}
}
