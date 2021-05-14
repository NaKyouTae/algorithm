package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BFS_카드뽑기2 {
	
	public static Queue<Integer> que = new LinkedList<>();
	public static int last = 0;
	
	@Test
	public void test() throws IOException {
		run();
	}
	
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			que.add(i);
		}
		
		BFS();
		
		bw.write(Integer.toString(que.peek()));
		bw.flush();
		bw.close();
	}
	
	public static void BFS() {
		if(que.size() > 1) {
			que.poll();
			int bottom = que.poll();
			que.add(bottom);
			BFS();
		}
	}
}
