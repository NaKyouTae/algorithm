package algorithm.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//ababc

//https://www.acmicpc.net/problem/11478

public class 서로다른부분문자열의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();

		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 1; i <= str.length(); i++) {
			for (int j = 0; j <= str.length()-i; j++) {
				String s = str.substring(j, j+i);
				
				if(!map.containsKey(s)) {
					map.put(s, 1);
				}
			}
		}
		
		System.out.println(map.size());
	}
}
