package algorithm.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//4
//5
//2 4 7 8 9
//1
//9
//6
//10 5 13 2 7 8
//4
//3 4 4 3

//6
//0
//4
//0

//https://www.acmicpc.net/problem/9037
public class thecandywar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int cnt = 0;
			if(k == 1) {
				sb.append(cnt).append("\n");
				continue;
			}
			
			List<Integer> list = new ArrayList<>();
			
			while(st.hasMoreTokens()) {
				int c = Integer.parseInt(st.nextToken());
				if(c%2 != 0) {
					c++;
				}
				list.add(c);
			}
			
			if(check(list)) {
				sb.append(cnt).append("\n");
				continue;
			}
			
			while(true) {
				cnt++;

				for(int j = 1; j < k; j++) {
					int prev = list.get(j-1) / 2;
					int sum = prev + list.get(j);
					list.set(j, (sum%2 != 0) ? sum+1:sum);
					list.set(j-1, list.get(j-1) - prev);
				}
				
				int last = list.get(k-1) - (list.get(k-1)/2);
				list.set(k-1, (last % 2 != 0) ? last+1:last);
				int sum = list.get(0) + last;
				System.out.println(" i : " + i + " , " + list.toString());
				if(check(list)) break;
				list.set(0, (sum % 2 != 0) ? sum+1:sum);
				
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean check(List<Integer> list) {
		boolean isCheck = true;
		
		int tot = 0;
		
		for(Integer l : list) {
			tot += l;
		}
		
		for(Integer l : list) {
			if(tot/list.size() != l) isCheck = false;
		}
		return isCheck;
	}
}
