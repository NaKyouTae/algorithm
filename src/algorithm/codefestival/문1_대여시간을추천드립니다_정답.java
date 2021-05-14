package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//3
//12:00 ~ 23:59
//11:00 ~ 18:00
//14:00 ~ 20:00

//14:00 ~ 18:00

//5
//09:42 ~ 20:32
//00:29 ~ 23:32
//01:32 ~ 21:39
//02:34 ~ 16:59
//09:43 ~ 19:01

//3
//23:00 ~ 23:59
//15:00 ~ 18:23
//17:43 ~ 20:13

public class 문1_대여시간을추천드립니다_정답 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int l = Integer.parseInt(br.readLine());
		
		List<Integer> stime = new ArrayList<>();
		List<Integer> etime = new ArrayList<>();
		
		for (int i = 0; i < l; i++) {
			String[] timezone = br.readLine().split(" ~ ");
			
			String[] start = timezone[0].split(":");
			String[] end = timezone[1].split(":");
			
			int s = (Integer.parseInt(start[0])*60) + Integer.parseInt(start[1]);
			int e = (Integer.parseInt(end[0])*60) + Integer.parseInt(end[1]);
			
			stime.add(s);
			etime.add(e);
		}        
        
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE; 
		
		
		for(int i = 0; i < l; i++) {
			if(max < stime.get(i)) max = stime.get(i);
			if(min > etime.get(i)) min = etime.get(i);
		}
		
		boolean isAll = true;
		
		for(int i = 0; i < l; i++) {
			if(stime.get(i) > min || etime.get(i) < max) isAll = false;  
		}

		if(isAll) {
			sb.append(convertTime(max/60)).append(":").append(convertTime(max%60))
			.append(" ~ ").append(convertTime(min/60)).append(":").append(convertTime(min%60));
		}else {
			sb.append(-1);
		}
		
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
	
	public static String convertTime(int time) {
		if(time < 10) {
			return "0" + Integer.toString(time);
		}else {
			return Integer.toString(time);
		}
	}
}
