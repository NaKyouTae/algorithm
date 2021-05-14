/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.Test;

public class DP_knapsack {
	
	@Test
	public void testSomeLibraryMethod() throws IOException {
		run();
	}

	public static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int[][] arr = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j <= m; j++) {
				if(j-w >= 0) {
					arr[i][j] = Math.max(arr[i-1][j], v + arr[i-1][j-w]); 
				}else {
					arr[i][j] = arr[i-1][j];
				}
			}
		}
		
        bw.write(Integer.toString(arr[n][m]));
        bw.flush();
        bw.close();
    }
}
