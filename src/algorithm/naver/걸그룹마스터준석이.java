package algorithm.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//3 4
//twice
//9
//jihyo
//dahyeon
//mina
//momo
//chaeyoung
//jeongyeon
//tzuyu
//sana
//nayeon
//blackpink
//4
//jisu
//lisa
//rose
//jenny
//redvelvet
//5
//wendy
//irene
//seulgi
//yeri
//joy
//sana
//1
//wendy
//1
//twice
//0
//rose
//1

//https://www.acmicpc.net/problem/16165
public class 걸그룹마스터준석이 {
	public static String team;
	public static Comparator<String> compare = new Comparator<>() {
		@Override
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		Map<String, List<String>> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String teamName = br.readLine();
			int num = Integer.parseInt(br.readLine());
			List<String> team = new ArrayList<>();
			for(int j = 0; j < num; j++) {
				String mem = br.readLine();
				team.add(mem);
			}
			Collections.sort(team, compare);
			map.put(teamName, team);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			String quiz = br.readLine();
			String type = br.readLine();
			
			if(type.equals("1")) {
				team = "";
				map.entrySet().forEach(item -> {
					item.getValue().forEach(mem -> {
						if(quiz.equals(mem)) {
							 team = item.getKey();
						}
					});
				});
				sb.append(team).append("\n");
			}else {
				map.entrySet().forEach(item -> {
					if(item.getKey().equals(quiz)) {
						item.getValue().forEach(mem -> {
							sb.append(mem).append("\n");
						});
					}
				});
			}
		}
		System.out.println(sb.toString());
	}
}
