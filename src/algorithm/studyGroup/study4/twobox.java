package algorithm.studyGroup.study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// POINT

//1 2 3 5
//3 5 8 11


//https://www.acmicpc.net/problem/15973
public class twobox {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] box1 = br.readLine().split(" ");
		String[] box2 = br.readLine().split(" ");
				
		int box1_x1 = Integer.parseInt(box1[0]); 
		int box1_y1 = Integer.parseInt(box1[1]); 
		int box1_x2 = Integer.parseInt(box1[2]); 
		int box1_y2 = Integer.parseInt(box1[3]);
		
		int box2_x1 = Integer.parseInt(box2[0]); 
		int box2_y1 = Integer.parseInt(box2[1]); 
		int box2_x2 = Integer.parseInt(box2[2]); 
		int box2_y2 = Integer.parseInt(box2[3]); 
		
		Map<Integer, Integer> mapX = new HashMap<>();
		Map<Integer, Integer> mapY = new HashMap<>();
		
		for(int i = box1_x1; i <= box1_x2; i++) {
			for(int j = box1_y1; j <= box1_y2; j++) {
				if(mapX.size() == 2 && mapY.size() == 2) break;
				if(box2_x1 <= i && box2_x2 >= i && box2_y1 <= j && box2_y2 >= j) {
					if(mapX.size() == 2 && mapY.size() == 2) break;
					if(!mapX.containsKey(i)) mapX.put(i, 1);
					if(!mapY.containsKey(j)) mapY.put(j, 1);
				}
			}
		}
		
		if(mapX.size() == 0 && mapY.size() == 0) System.out.println("NULL");
		if(mapX.size() >= 2 && mapY.size() >= 2) System.out.println("FACE");
		if(mapX.size() == 1 && mapY.size() == 1) System.out.println("POINT");
		if(mapX.size() >= 2 && mapY.size() == 1) System.out.println("LINE");
		if(mapX.size() == 1 && mapY.size() >= 2) System.out.println("LINE");
	}
}
