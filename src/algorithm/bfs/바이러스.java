package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7

//https://www.acmicpc.net/problem/2606
public class 바이러스 {

	public static int cnt;
	public static boolean[] visit;
	public static Queue<Integer> que = new LinkedList<>();
	public static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int l = Integer.parseInt(br.readLine());
		
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) list.add(new ArrayList<>()); 
		for (int i = 0; i < l; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0])-1;
			int y = Integer.parseInt(str[1])-1;
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		bfs();
		
		System.out.println();
		System.out.println(cnt);
	}
	
	public static void bfs() {
		que.add(0);
		visit[0] = true;

		while(!que.isEmpty()) {
			int x = que.poll();
			for (int i = 0; i < list.get(x).size(); i++) {
				int y = list.get(x).get(i);
				if(!visit[y]) {
					visit[y] = true;
					que.add(y);
					cnt++;
				}
			}
		}
	}
}
