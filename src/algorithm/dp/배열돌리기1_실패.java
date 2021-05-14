package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4 4 2
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16


//3 4 8 12
//2 11 10 16
//1 7 6 15
//5 9 13 14

//https://www.acmicpc.net/problem/16926
public class 배열돌리기1_실패 {
	public static int[][] map, res;
	public static int N, M, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		L = Integer.parseInt(str[2]);
		
		map = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Math.min(N, M) / 2;
		
		for(int r = 0; r < L; r++) {
			move(min);
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		
		System.out.print(sb.toString());
	}
	
	public static void move(int num) {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for(int i = 1; i <= num; i++) {
			
			int x = i;
			int y = i;
			int temp = map[x][y];
			
			int idx = 0;
			
			while(idx < 4) {
				int xx = x + dx[idx], yy = y + dy[idx];
				if(xx < i || yy < i || xx > N-i+1 || yy > M-i+1) {
					idx++;
				}else {
					map[x][y] = map[xx][yy];
					x = xx;
					y = yy;
				}
			}
 			map[i+1][i] = temp;
		}
	}
}
