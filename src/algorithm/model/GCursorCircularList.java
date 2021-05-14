package algorithm.model;

import java.util.Comparator;

/**
 * @author      : "NKT"
 * @date        : 2021-01-05 13:36

 * @description
 * ==============================================================
 * 원영 리스트 커서 버전 Cursor Circular List
 * P 348 8번 문제
 * ==============================================================
 */
public class GCursorCircularList<T> {
	class Node<T>{
		private	T data;
		private int next;
		private int dnext;
		
		void set(T data, int next) {
			this.data = data;
			this.next = next;			
		}
	}
	
	private Node<T>[] n;
	private int size;
	private int max;
	private int head;
	private int tail;
	private int crnt;
	private int deleted;
	private static final int NULL = -1;
	
	public GCursorCircularList(int capacity) { 
		this.head = this.crnt = this.tail = this.max = this.deleted = NULL;
		try {
			n = new Node[capacity];
			for(int i = 0; i < capacity; i++) {
				n[i] = new Node<T>();
			}
			this.size = capacity;
		} catch (Exception e) {
			this.size = 0;
		}
	}
	
	public int getInsertIndex() {
		if(this.deleted == NULL) {
			if(this.max < this.size)
				return ++max;
			else
				return NULL;
		}else {
			int rec = this.deleted;
			this.deleted = n[rec].dnext;
			return rec;
		}
	}
	
	public void deleteIndex(int idx) {
		if(deleted == NULL) {
			this.deleted = idx;
			this.n[idx].dnext = NULL;
		}else {
			int rec = this.deleted;
			this.deleted = idx;
			this.n[idx].dnext = rec;
		}
	}
	
	public T search(T o, Comparator<? super T> c) {
		if(this.head != NULL) {
			int ptr = this.head;
			
			do {
				if(c.compare(o, this.n[ptr].data) == 0) {
					this.crnt = ptr;
					return n[ptr].data;
				}
				ptr = this.n[ptr].next;
	 		} while(ptr != this.head);
		}
		
		return null;
	}
	
	public void addFirst(T o) {
		if(this.head == NULL) {
			int rec = getInsertIndex();
			if(rec != NULL) {
				this.head = this.tail = this.crnt = rec;
				n[this.head].set(o, rec);
			}
		}else {
			int ptr = this.head;
			int rec = getInsertIndex();
			if(rec != NULL) {
				this.head = this.crnt = rec;
				this.n[this.head].set(o, ptr);
				this.n[this.tail].next = this.head;
			}
		}
	}

	public void addLast(T o) {
		if(this.head == NULL) {
			addFirst(o);
		}else {
			int rec = getInsertIndex();
			if(rec != NULL) {				
				this.n[tail].next = this.crnt = this.tail = rec;
				this.n[rec].set(o, this.head);
			}
		}
	}
	
	public void removeFirst() {
		if(this.head != NULL) {
			if(this.head == this.tail) {
				deleteIndex(this.head);
				this.head = this.tail = this.crnt = NULL;
			}else{
				int ptr = this.n[this.head].next;
				deleteIndex(this.head);
				this.n[this.tail].next = this.head = this.crnt = ptr;
			}
		}
	}
	
	public void removeLast() {
		if(this.head != NULL) {
			if(this.head == this.tail) {
				removeFirst();
			}else {
				int ptr = this.head;
				int pre = this.head;
				
				while(n[ptr].next != this.head) {
					pre = ptr;
					ptr = this.n[ptr].next;
				}
				
				this.n[pre].next = this.head;
				deleteIndex(ptr);
				this.tail = this.crnt = pre;
			}
		}
	}

	public void remove(int p) {
		if(this.head != NULL) {
			if(this.head == p) {
				removeFirst();
			}else if(this.tail == p) {
				removeLast();
			}else {
				int ptr = this.head;
				
				while(n[ptr].next != p) {
					ptr = n[ptr].next;
					if(ptr == this.head) return ;
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	public void clear() {
		while(this.head != NULL) {
			removeFirst();
		}
		crnt = NULL;
	}
	
	public boolean next() {
		if(this.crnt == NULL || this.n[this.crnt].next == this.head) {
			return false;
		}
		
		this.crnt = this.n[this.crnt].next;
		return true;
	}
	
	public void printCurrentNode() {
		if(this.crnt == NULL) {
			System.out.println("선택 노드가 없습니다.");
		}else {
			System.out.println(this.n[this.crnt].data.toString());
		}
	}
	
	public void dump() {
		if(this.head != NULL) {
			int ptr= this.head;
					
			do {
				System.out.print(n[ptr].data.toString() + ", ");
				ptr = this.n[ptr].next;
			}while(ptr != this.head);
		}
	}
	public void purge(Comparator<? super T> c) {
		if(head == NULL) return;
		
		int ptr = this.head;
		
		do {
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;
			
			while(n[pre].next != head) {
				ptr2 = n[pre].next;
				if(c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				}else {
					pre = ptr2;
				}
			}
			if(count == 0)
				ptr = n[ptr].next;
			else {				
				int temp = n[ptr].next;
				remove(ptr);
				ptr = temp;
			}
	 	} while(n[ptr].next != head);
				
	}
	
	public T retreive(int n) {
		if(this.head != NULL) {			
			int ptr = this.head;
			
			while(n >= 0) {
				if(n-- == 0) {
					this.crnt = ptr;
					return this.n[ptr].data;
				}
				ptr = this.n[ptr].next;
				if(ptr == head) break;
			}
		}
		return null;
	}
	
}
