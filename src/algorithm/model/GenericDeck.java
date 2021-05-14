package algorithm.model;

import algorithm.exception.DeckException.EmptyDeckException;
import algorithm.exception.DeckException.OverflowDeckException;

public class GenericDeck<T> {
	private int max;
	private int num;
	private int front;
	private int rear;
	private T[] dec;
	
	
	@SuppressWarnings("unchecked")
	public GenericDeck(int front, int size) {
		this.front = this.rear = front;
		this.num = 0;
		this.max = size;
		this.dec = (T[]) new Object[size];
	}
	
	public int size() {
		return num;
	}
	
	public T enDeckFront(T x) {
		if(num >= max) {
			throw new OverflowDeckException();
		}
		
		if(--front < 0) {
			front = max - 1;
		}
		
		dec[front] = x;
		num++;		
		
		return x;
	}
	
	public T enDeckRear(T x) {
		if(num >= max) {
			throw new OverflowDeckException();
		}
		
		if(rear == max) {
			rear = 0;
		}
		
		dec[rear++] = x;
		num++;
		
		return x;
	}
	
	public T deDeckFront() {
		if(num == 0) {
			throw new EmptyDeckException();
		}
		
		if(front++ >= max) {
			front = 0;
		}
		num--;
		return dec[front];
	}
	
	public T deDeckRear() {
		if(num == 0) {
			throw new EmptyDeckException();
		}
		
		if(--rear < 0) {
			rear = max - 1;
		}
		
		num--;
		
		return dec[rear];
	}
	
	public void dump() {
		for(int i = 0; i<max; i++) {
			if(i == max-1) {
				if(front == i) System.out.println("F|");
				else if(rear == i) System.out.println("R|");
				else System.out.println(" |");
			}else {
				if(front == i) System.out.print("F|");
				else if(rear == i) System.out.print("R|");
				else System.out.print(" |");
			}
		}
		
		for(int i = 0; i<max; i++) {
			if(i == max-1) {
				System.out.println(i+"|");
			}else {
				System.out.print(i+"|");
			}
		}
		for(int i = 0; i<max; i++) {
			if(i == max-1) {
				System.out.println(((dec[i] == null) ? " ": dec[i])+"|");
			}else {
				System.out.print(((dec[i] == null) ? " ": dec[i])+"|");
			}
		}
	}
}
