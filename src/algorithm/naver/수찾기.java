package algorithm.naver;
//5
//4 1 5 2 3
//5
//1 3 7 9 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//1
//1
//0
//0
//1

//https://www.acmicpc.net/problem/1920
public class 수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		int m = Integer.parseInt(br.readLine());
		String[] str1 = br.readLine().split(" ");
		
		Map<Integer, Integer> source = new HashMap<>();
		for(int i = 0; i < n; i++) {
			source.put(Integer.parseInt(str[i]), 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			if(source.containsKey(Integer.parseInt(str1[i]))) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
