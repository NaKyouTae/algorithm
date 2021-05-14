package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합치기5_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int[][] arr = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 = Integer.parseInt(s[3]);
			
			int sum = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
