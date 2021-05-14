package algorithm.physical;

import java.util.Scanner;

public class 시각 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = 0;
		for(int i = 1; i <= n+1; i++) {
			for (int j = 1; j <= 60; j++) {
				for (int j2 = 1; j2 <= 60; j2++) {
					String a = Integer.toString(i);
					String b = Integer.toString(j);
					String c = Integer.toString(j2);					
					String str = a+b+c;
					if(str.contains("3")) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
