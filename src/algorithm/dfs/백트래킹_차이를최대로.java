package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6
//20 1 15 8 4 10

//https://www.acmicpc.net/problem/10819
public class 백트래킹_차이를최대로 {
	public static int max;
	public static int[] arr, res;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		res = new int[n];
		visit = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	public static void dfs(int i) {
		if(i == res.length) {
			int sum = 0;
			for(int j = 1; j < res.length; j++) {
				sum += Math.abs(res[j-1] - res[j]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		for(int j = 0; j < arr.length; j++) {
			if(!visit[j]) {
				visit[j] = true;
				res[i] = arr[j];
				dfs(i + 1);
				visit[j] = false;
			}
		}
	}
}
