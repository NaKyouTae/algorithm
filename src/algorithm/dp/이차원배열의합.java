package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2 3
//1 2 4
//8 16 32
//3
//1 1 2 3
//1 2 1 2
//1 3 2 3

//https://www.acmicpc.net/problem/2167

public class 이차원배열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int z = 0;
			while(st.hasMoreTokens()) {
				arr[i][z++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int p = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < p; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int sum = 0;
			for (int r = x; r <= i; r++) {
				for (int c = y; c <= j; c++) {
					sum += arr[r][c];
				}
			}
			sb.append(sum).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
