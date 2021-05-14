package algorithm.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.acmicpc.net/problem/17269
public class 이름궁합테스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ap = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		String[] str1 = br.readLine().split(" ");
		
		String p1 = str1[0];
		String p2 = str1[1];
		
		String res = "";
		int min = Math.min(p1.length(), p2.length());
		for(int i = 0; i < min; i++) {
			res += String.valueOf(p1.charAt(i)) + String.valueOf(p2.charAt(i));
		}
		
		res += p1.substring(min, p1.length()) + p2.substring(min, p2.length());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < res.length(); i++) {
			list.add(ap[res.charAt(i) - 'A']);
		}
		
		
		for(int i = 0; i < res.length()-2; i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j = 0; j < list.size()-1; j++) {
				temp.add((list.get(j) + list.get(j+1))%10);
			}
			list = temp;
		}
		
		System.out.println((list.get(0)*10) + list.get(1) + "%");
	}
}
