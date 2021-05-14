package algorithm.physical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//5
//R R R U D D

// 이것이 코딩테스트다 110페이지
public class 상하좌우_직접구현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = 1, y = 1;
		
		while(st.hasMoreTokens()) {
			switch(st.nextToken()) {
			case "R" :
				if(y+1 < n) {
					y++;
				}
				break;
			case "L" :
				if(y-1 >= 0) {
					y--;
				}
				break;
			case "U" :
				if(x-1 > 0) {
					x--;
				}
				break;
			case "D" :
				if(x+1 < n) {
					x++;
				}
				break;
			}
		}
		
		System.out.println("x : " + x + ", y : " + y);
	}
}
