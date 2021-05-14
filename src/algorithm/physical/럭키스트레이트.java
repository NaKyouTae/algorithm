package algorithm.physical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 럭키스트레이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		
		int center = str.length()/2;
		
		int left = 0;
		for(int i = 0; i < center; i++) {
			left += str.charAt(i) - '0';
		}
		
		int right = 0;
		for (int i = center; i < str.length(); i++) {
			right += str.charAt(i) - '0';
		}
		
		
		bw.write((right == left) ? "LUCKY":"READY");
		bw.flush();
		bw.close();
	}
	
}
