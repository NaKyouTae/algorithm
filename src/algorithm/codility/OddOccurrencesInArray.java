package algorithm.codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
	
	public static void main(String[] args) {
		int[] A = {9, 7, 9, 4, 7};
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			if(map.containsKey(a)) {
				map.put(a, map.get(a)+1);
			}else {
				map.put(a, 1);
			}
		}
		
		int res = 0;
		for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
			if(ent.getValue() % 2 != 0) {
				res = ent.getKey()+1;
			}
		}
		
		System.out.println(res);
	}
}
