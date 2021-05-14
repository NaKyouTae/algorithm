package algorithm.model;

import algorithm.exception.StackException.EmptyStackException;
import algorithm.exception.StackException.OverflowStackException;

public class GStackBack<E> {
	private int max;
	private int ptr;
	private int r_ptr;
	private E[] stk;
	
	@SuppressWarnings("unchecked")
	public GStackBack(int size){
		this.stk = (E[]) new Object[size];
		this.ptr = 0;
		this.r_ptr = size-1;
		this.max = size;
	}
	
	public int size(){
		return ptr;
	}
	
	public int sizeBack(){
		return max - r_ptr - 1;
	}
	
	public int capacity(){
		return max;
	}
	
	public E push(E n) throws OverflowStackException{
		if(ptr >= r_ptr + 1) {
			throw new OverflowStackException();
		}
		return stk[ptr++] = n; 
	}
	
	public E pop() throws EmptyStackException{
		if(ptr <= 0) {
			throw new EmptyStackException();
		}
		int p = --ptr;
		E x = stk[p];
		stk[p] = null;
		return x;
	}
	
	public E peek() throws EmptyStackException{
		if(ptr <= 0) {
			throw new EmptyStackException();
		}
		return stk[ptr-1];
	}
	
	public E pushBack(E n) throws OverflowStackException{
		if(ptr >= r_ptr - 1) {
			throw new OverflowStackException();
		}
		return stk[r_ptr--] = n; 
	}
	
	public E popBack() throws EmptyStackException{
		if(r_ptr >= max - 1) {
			throw new EmptyStackException();
		}
		
		int p = ++r_ptr;
		E x = stk[p];
		stk[p] = null;
		return x;
	}
	
	public E peekBack() throws EmptyStackException{
		if(r_ptr >= max - 1) {
			throw new EmptyStackException();
		}
		return stk[r_ptr+1];
	}
	
	public void dump(){
		if(ptr <= 0 && r_ptr >= max - 1) {
			System.out.println("스택이 비어 있습니다.");
		}else {
			
			for(int i = 0; i < max; i++) {
				if(i == max - 1) {					
					System.out.println(i+1 + "|");
				}else {
					System.out.print(i+1 + "|");
				}
			}
			for(int i = 0; i < max; i++) {
				if(stk[i] == null) {
					if(i+1 > 9)
						System.out.print("  |");
					else
						System.out.print(" |");
				}else {					
					System.out.print(stk[i] + "|");
				}
			}
		}
	}
}
