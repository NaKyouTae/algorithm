package algorithm.model;

import algorithm.exception.QueException.EmptyQueueException;
import algorithm.exception.QueException.OverflowQueueException;

public class ArrayQueue<T> {
	private int max;
	private int num;
	private T[] que;
	
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		this.max = size;
		this.num = 0;
		this.que = (T[]) new Object[size];
	}
	
	public T enque(T en) {
		if(num == max - 1) {
			throw new OverflowQueueException();
		}
		
		return que[num++] = en; 
	}
	
	public T deque() {
		if(num == 0) {
			throw new EmptyQueueException();
		}
		
		T de = que[0];
		
		for(int i = 1; i < num; i++) {
			if(que[i] == null) break;
			que[i-1] = que[i];
		}
		
		que[--num] = null;
		
		return de;
	}
	
	public void dump() {
		if(num == 0) {
			throw new EmptyQueueException();
		}
		
		System.out.println("Num : " + num);
		
		for(int i = 0; i < que.length; i++) {
			if(i == que.length-1) {
				System.out.println(i+1 + "|");
			}else {				
				System.out.print(i+1 + "|");
			}
		}
		for(int i = 0; i < que.length; i++) {
			if(que[i] == null) {
				String em = ((i+1) > 9) ? "  " : " ";
				
				if(i == que.length-1) {
					System.out.println(em + "|");
				}else {
					System.out.print(em + "|");
				}
			}else {
				if(i == que.length-1) {
					System.out.println(que[i] + "|");
				}else {					
					System.out.print(que[i] + "|");
				}
			}
		}
	}
	
}
