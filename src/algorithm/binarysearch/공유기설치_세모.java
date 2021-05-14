package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 공유기설치_세모 {
	public static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		int left = 0;
		int right = list.get(list.size()-1);
		int center = (left + right) / 2;
		binarySearch(left, right, center);
		
		for(Integer l : result) System.out.println(l); 
	}
	
	public static void binarySearch(int left, int right, int center) {
		result.add(center);
		if(right == left) return;
		binarySearch(left, center-1, (left+center-1)/2);
		binarySearch(center+1, right, (right+center+1)/2);
	}
}
