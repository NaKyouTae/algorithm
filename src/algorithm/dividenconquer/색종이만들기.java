package algorithm.dividenconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//8
//1 1 0 0 0 0 1 1
//1 1 0 0 0 0 1 1
//0 0 0 0 1 1 0 0
//0 0 0 0 1 1 0 0
//1 0 0 0 1 1 1 1
//0 1 0 0 1 1 1 1
//0 0 1 1 1 1 1 1
//0 0 1 1 1 1 1 1

//https://www.acmicpc.net/problem/2630

public class 색종이만들기 {
	public static int N;
	public static int[][] map;
	public static int[] res = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			sb.append(res[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void divide(int r, int c, int s) {
		if (checkColor(r, c, s)) {
			if (map[r][c] == 0) {
				res[0]++;
			} else {
				res[1]++;
			}
			return;
		}

		int ns = s / 2;

		divide(r, c, ns);
		divide(r, c + ns, ns);
		divide(r + ns, c, ns);
		divide(r + ns, c + ns, ns);
	}

	public static boolean checkColor(int r, int c, int s) {
		int color = map[r][c];
		for (int i = r; i < r + s; i++) {
			for (int j = c; j < c + s; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}
}
