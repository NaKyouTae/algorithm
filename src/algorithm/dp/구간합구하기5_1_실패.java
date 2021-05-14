package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11660

public class 구간합구하기5_1_실패 {
	public static int[][] arr, brr;
	public static int x, y, r, c, sum;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		arr = new int[n][n];
		brr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
				if(i == 0 && j == 0) {
					brr[i][j] += arr[i][j];
				}else {
					brr[i][j] = sum;
				}
			}
		}
		
		for (int k = 0; k < m; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			
			if(x == r && y == c) {
				sb.append(arr[x][y]).append("\n");
			}else if(x == 0 && y == 0){
				sb.append(brr[r][c]).append("\n");
			}else {
				sb.append(brr[r][c] - brr[x][y]).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
