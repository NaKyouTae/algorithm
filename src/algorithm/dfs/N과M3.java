package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15651
public class N과M3 {
	public static int N, M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int idx) {
		if(idx == M) {
			for(int a : arr) {
				if(a != 0) sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[idx] = i+1;
			dfs(idx+1);
		}
	}
}
