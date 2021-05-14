package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BFS_특정도시의거리찾기 {
	public static int[][] arr, brr;
	public static boolean[][] visit;
	public static int cities, road, destination, origination;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		cities = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());
		origination = Integer.parseInt(st.nextToken());
		
		arr = new int[cities][cities];
		brr = new int[cities][cities];
		visit = new boolean[cities][cities];
		
		for (int i = 0; i < road; i++) {
			String[] str = br.readLine().split(" ");
			
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			
			arr[s][e] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				DFS(i, i, 0);
			}
		}
		
		bw.write("");
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int s, int e, int cnt) {
		
		
	}
}
