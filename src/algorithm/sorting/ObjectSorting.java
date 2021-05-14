package algorithm.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectSorting {
	public static class Node {
		String name;
		Integer point;
		
		Node(String n, int p) {
			this.point = p;
			this.name = n;
		}
	}
	public static List<Node> list = new ArrayList<>();
	public static Comparator<Node> compare = new Comparator<>() {

		@Override
		public int compare(Node o1, Node o2) {
			return (o1.point > o2.point) ? 0 : (o1.point == o2.point) ? 0:-1;
		}
		
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			
			list.add(new Node(str[0], Integer.parseInt(str[1])));
		}
		
		Collections.sort(list, compare);
		
		list.forEach((Node item) -> {
			sb.append(item.name).append(" ");
		});
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}


//2
//홍길동 95
//이순신 77