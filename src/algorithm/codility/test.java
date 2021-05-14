package algorithm.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.checkerframework.checker.units.qual.Current;
import org.junit.Test;

public class test {
	
	public static void main(String[] args) {
		int N = Integer.MAX_VALUE;
		long start = System.currentTimeMillis();
		test(N);
		System.out.println("TIME : " + (System.currentTimeMillis()-start));
		
		
		long start1 = System.currentTimeMillis();
		test1(N);
		System.out.println("TIME : " + (System.currentTimeMillis()-start1));
	}
	
	public static void test(int N) {
//		String binaryStr = Integer.toBinaryString(1000000000);
		
		int a = N;
		List<Integer> list = new ArrayList<>();
		while(a > 0) {
			list.add(a % 2);
			a /= 2;
		}
		
		Collections.reverse(list);
		
//		String[] binaryStrArray = binaryStr.split("");

		boolean start = false;
		int resultCount=0;
		int count_0=0;
		for(Integer tmp:list){
			if(tmp == 1&& !start){
				start=true;
			}else if(tmp == 1 && start){
			
				if(count_0 > resultCount){
					resultCount = count_0;
				}
			
				count_0 = 0;
			}else if(tmp == 0 && start){
				count_0++;
			}
		}
		
		System.out.println(list.toString());
		System.out.println(resultCount);
	}
	
	public static void test1(int N) {
		String binaryStr=Integer.toBinaryString(N);
		String[] binaryStrArray=binaryStr.split("");

		boolean start=false;
		int resultCount=0;
		int count_0=0;
		for(String tmp:binaryStrArray){
		if(tmp.equals("1")&&!start){
		start=true;
		}else if(tmp.equals("1")&&start){
		if(count_0>resultCount){
		resultCount=count_0;
		}
		count_0=0;
		}else if(tmp.equals("0")&&start){
		count_0++;
		}
		}
		System.out.println(binaryStr);
		System.out.println(resultCount);
	}
}
