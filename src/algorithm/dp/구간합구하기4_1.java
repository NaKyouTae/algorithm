package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//5 3
//5 4 3 2 1
//1 3
//2 4
//5 5

//https://www.acmicpc.net/problem/11659

public class 구간합구하기4_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		List<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		list.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < n; i++) {
			list.add(list.get(i-1) + Integer.parseInt(st.nextToken()));
		}
		
		
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			
			int x = Integer.parseInt(s[0])-1;
			int y = Integer.parseInt(s[1])-1;
			
			sb.append(list.get(y) - ((x == 0) ? x:list.get(x-1))).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
