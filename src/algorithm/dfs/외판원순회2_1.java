package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4
//0 10 15 20
//5 0 9 10
//6 13 0 12
//8 8 9 0

//35

//https://www.acmicpc.net/problem/10971

public class 외판원순회2_1 {
	public static int N, min = Integer.MAX_VALUE;
	public static int[][] map;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, i, 0, 0);
		}
		
		System.out.println(Integer.toString(min));
	}
	
	public static void dfs(int start, int i, int cnt, int sum) {
		if(cnt == N && start == i) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int idx = 0; idx < N; idx++) {
			if(map[i][idx] == 0) continue;
			
			if(!visit[i] && map[i][idx] > 0) {
				visit[i] = true;
				sum += map[i][idx];
				System.out.print(map[i][idx] + " ");
				dfs(start, idx, cnt+1, sum);
				visit[i] = false;
				sum -= map[i][idx];
			}
		}
		System.out.println();
	}
}
