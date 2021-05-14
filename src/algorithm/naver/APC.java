package algorithm.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//4 8 4
//1 8
//4 5
//6 20
//9 12

//380

//https://www.acmicpc.net/problem/17224
public class APC {
	public static boolean[] visit;
	public static List<Integer> list = new ArrayList<>();
	public static int N, L, K, cnt, sum, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		visit = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int v = 0;
			if(Integer.parseInt(s[1]) <= L) {
				v = 140;
			}else {
				if(Integer.parseInt(s[0]) <= L) {
					v = 100;
				}
			}
			
			list.add(v);
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	public static void dfs(int idx) {
		if(cnt >= K || idx == N-1) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				sum += list.get(i);
				cnt++;
				dfs(idx+1);
				visit[i] = false;
				sum -= list.get(i);
				cnt--;
			}
		}
	}
}
