package algorithm.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BFS_모래성쌓기2 {
	
	public static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static String[][] arr;
	public static int[][] brr;
	public static Queue<Node> que = new LinkedList<>();
	
	public static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	public static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };
	public static int x, y;
	
	@Test
	public void test() throws IOException {
		run();
	}
	
	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int e = 0; e < T; e++) {
			
			String[] str = br.readLine().split(" ");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			
			arr = new String[x][y];
			brr = new int[x][y];
			
			for (int i = 0; i < x; i++) {
				String s = br.readLine();
				for (int j = 0; j < y; j++) {
					arr[i][j] = String.valueOf(s.charAt(j));
				}
			}
			
			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if(!arr[i][j].equals(".") && !arr[i][j].equals("9")) {						
						for (int j2 = 0; j2 < 8; j2++) {
							int xx = dx[j2] + i, yy = dy[j2] + j;
							if(xx < x && yy < y && xx >= 0 && yy >= 0) {
								String val = arr[xx][yy];
								if(val.equals(".")) {
									brr[i][j]++;
								}
							}
						}
						if(Integer.parseInt(arr[i][j]) <= brr[i][j]) {
							que.add(new Node(i, j));
						}
					}
				}
			}
			
			int cnt = 0;
			while(!que.isEmpty()) {
            	cnt++;
                int t = que.size();
                
                for(int i = 0; i < t; i++) {
                	Node node = que.poll();
                	for(int j = 0; j < 8; j++) {
                    	int xx = dx[j] + node.x, yy = dy[j] + node.y;
                        if(xx < x && yy < y && xx >= 0 && yy >=0) {
                            String val = arr[xx][yy];
                            if(!val.equals(".") && Integer.parseInt(val) > brr[xx][yy]) {
                                brr[xx][yy]++;
                            }else{
                                continue;
                        	}
                            
                            if(!val.equals(".") && Integer.parseInt(val) <= brr[xx][yy]) {
                                que.add(new Node(xx, yy));
                            }
                    	}
                	}
            	}
        	}
			
			sb.append("#").append(e+1).append(" ").append(cnt).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
