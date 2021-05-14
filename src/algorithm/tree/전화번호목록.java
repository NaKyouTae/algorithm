package algorithm.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//2
//3
//911
//97625999
//91125426
//5
//113
//12340
//123440
//12345
//98346

//https://www.acmicpc.net/problem/5052
public class 전화번호목록 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int e = 0; e < T; e++) {
			int ca = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			Trie t = new Trie();
			
			for (int i = 0; i < ca; i++) {
				String word = br.readLine();
				list.add(word);
				t.insert(word);
			}
			
			boolean is = false;
			
			for(String k : list) {
				if(t.contains(k)) {
					is = true;
					break;
				}
			}
			
			sb.append((is == true) ? "NO":"YES").append("\n");
		}
		
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}
