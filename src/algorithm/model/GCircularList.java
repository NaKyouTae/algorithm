package algorithm.model;

import java.util.Comparator;

/**
 * @author      : "NKT"
 * @date        : 2021-01-05 12:51

 * @description
 * ==============================================================
 * Circular List 원형 연결 리스트
 * P 348 7번 문제
 * ==============================================================
 */
public class GCircularList<T> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.next = this;
		}
		
		Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	private Node<T> crnt;
	
	public GCircularList() {
		this.head = this.crnt = this.tail = null;
	}
	
	
	public T search(T o, Comparator<? super T> c) {
		Node<T> ptr = this.head;
		
		while(ptr.next != this.head) {
			if(c.compare(ptr.data, o) == 0) {
				this.crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		
		return null;
	}
	
	public void addFirst(T o) {
		if(this.head == null) {
			this.head = this.tail = this.crnt = new Node<T>(o);
		}else {
			Node<T> ptr = this.head;
			this.head = this.crnt = new Node<T>(o, ptr);
			this.tail.next = this.head;
		}
	}
	
	public void addLast(T o) {
		if(head == null) {
			addFirst(o);
		}else {
			Node<T> ptr = this.tail;
			ptr.next = this.crnt = this.tail = new Node<T>(o, this.head);
		}
	}
	
	public void removeFirst() {
		if(this.head != null) {
			if(this.tail == this.head) {
				this.head = this.tail = this.crnt = null;
			}else {
				Node<T> ptr = this.head.next;
				this.head = this.crnt = ptr;
				this.tail.next = this.head;
			}
		}
	}
	
	public void removeLast() {
		if(this.head != null) {
			if(this.tail == this.head) {
				removeFirst();
			}else {
				Node<T> ptr = this.head;
				Node<T> pre = this.head;
				
				while(ptr.next != this.head) {
					pre = ptr;
					ptr = ptr.next;
				}
				
				pre.next = this.head;
				this.tail = this.crnt = pre;
			}
		}
	}
	
	public void remove(Node<T> o) {
		if(this.head != null) {
			if(o == this.head) {
				removeFirst();
			}else if(o == this.tail) {
				removeLast();
			}else {
				Node<T> ptr = this.head;
				
				while(ptr.next != o) {
					ptr = ptr.next;
					if(ptr == this.head) {
						return;
					}
				}
				
				ptr.next = o.next;
				this.crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() {
		remove(this.crnt);
	}
	
	public void clear() {
		while(this.head != null) {
			removeFirst();
		}
		this.crnt = null;
	}
	
	public boolean next() {
		if(this.crnt == null || this.crnt.next == this.head) {
			return false;
		}
		this.crnt = this.crnt.next;
		
		return true;
	}
	
	public void printCurrentNode() {
		if(this.crnt == null) {
			System.out.println("선택 노드가 없습니다.");
		}else {
			System.out.println(this.crnt.data.toString());
		}
	}
	
	public void dump() {
		Node<T> ptr = this.head; 
		
		do{
			System.out.printf("%2s, ", ptr.data.toString());
			ptr = ptr.next;
		} while(ptr != this.head); 
	}
	
	public void purge(Comparator<? super T> c) {
		if(this.head == null) return;
		
		Node<T> ptr = this.head;
		
		do {
			int count = 0;
			Node<T> ptr2 = ptr;
			Node<T> pre = ptr;
			
			while(pre.next != this.head) {
				ptr2 = pre.next;
				if(c.compare(ptr.data, ptr2.data) == 0) {
					remove(ptr2);
					count++;
				}else {
					pre = ptr2;
				}
			}
			if(count == 0) {
				ptr = ptr.next;
			}else {
				Node<T> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
		} while(ptr.next != this.head);
		
		this.crnt = this.head;
	}
	
	public T retrieve(int n) {
		if(this.head != null) {			
			Node<T> ptr = this.head;
			
			while(n >= 0 && ptr.next != this.head) {
				if(n-- == 0) {
					this.crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next;
			}
		}
		
		return null;
	}
}
