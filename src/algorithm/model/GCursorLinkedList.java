package algorithm.model;

import java.util.Comparator;

public class GCursorLinkedList<T> {
	
	class Node<T> {
		private T data;
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
	private int crnt;
	private int deleted;
	private static final int NULL = -1;
	
	public GCursorLinkedList(int capacity) {
		head = crnt = max = deleted = NULL;
		
		try {
			n = new Node[capacity];
			for(int i = 0; i < capacity; i++)
				n[i] = new Node<T>();
			size = capacity;
		} catch (Exception e) {
			this.size = 0;
		}
	}
	
	public int getInsertIndex() {
		if(deleted == NULL) {
			if(max < size) {
				return ++max;
			}else {
				return NULL;
			}
		}else {
			int rec = deleted;
			deleted = n[rec].dnext;
			return rec;
		}
	}
	
	public void deleteIndex(int idx) {
		if(deleted == NULL) {
			deleted = idx;
			n[idx].dnext = NULL;
		}else {
			int rec = deleted;
			deleted = idx;
			n[idx].dnext = rec;
		}
	}
	
	public T search(T obj, Comparator<? super T> c) {
		int ptr = this.head;
		
		while(ptr != NULL) {
			if(c.compare(obj, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data;
			}
			ptr = n[ptr].next;
		}
		
		return null;
	}
	
	public void addFirst(T data) {
		int ptr = this.head;
		int rec = getInsertIndex();
		if(rec != NULL) {
			head = crnt = rec;
			n[head].set(data, ptr);
		}
	}
	
	public void addLast(T data) {
		if(head == NULL) {
			addFirst(data);
		} else {
			int ptr = this.head;
			while(n[ptr].next != NULL) {
				ptr = n[ptr].next;
			}
			int rec = getInsertIndex();
			if(rec != NULL) {
				n[ptr].next = crnt = rec;
				n[rec].set(data, NULL);
			}
		}
	}
	
	public void removeFirst() {
		if(this.head != NULL) {
			int ptr = n[this.head].next;
			deleteIndex(head);
			head = crnt = ptr;
		}
	}
	
	public void removeLast() {
		if(this.head != NULL) {
			if(n[head].next == NULL) {
				removeFirst();
			}else {
				int ptr = this.head;
				int pre = this.head;
				
				while(n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL;
				deleteIndex(ptr);
				crnt = pre;
			}
		}
	}
	
	public void remove(int idx) {
		if(this.head != NULL) {
			if(idx == this.head) {
				removeFirst();
			}else {
				int ptr = this.head;
				
				while(n[ptr].next != idx) {
					ptr = n[ptr].next;
					if(ptr == NULL) return;
				}
				n[ptr].next = NULL;
				deleteIndex(idx);
				n[ptr].next = n[idx].next;
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrent() {
		remove(crnt);
	}
	
	public void clear() {
		while(this.head != NULL) 
			removeFirst();
		crnt = NULL;
	}
	
	public boolean next() {
		if(crnt == NULL || n[crnt].next == NULL) {
			return false;
		}
		crnt = n[crnt].next;
		return true;
	}
	
	public void printCurrent() {
		if(crnt == NULL) 
			System.out.println("선택 노드가 없습니다.");
		else
			System.out.println(n[crnt].data);
	}
	
	public void dump() {
		int ptr = this.head;
		int a = 0;
		System.out.print("NO   : ");
		while(ptr != NULL) {
			System.out.printf("%2d,", a++);
			ptr = n[ptr].next;
		}
		System.out.println();
		ptr = this.head;
		System.out.print("IDX  : ");
		while(ptr != NULL) {
			System.out.printf("%2d,", ptr);
			ptr = n[ptr].next;
		}
		System.out.println();
		
		ptr = this.head;
		System.out.print("NEXT : ");
		while(ptr != NULL) {
			System.out.printf("%2d,", n[ptr].next);
			ptr = n[ptr].next;
		}
		System.out.println();
		
		ptr = this.head;
		System.out.print("DATA : ");
		while(ptr != NULL) {
			System.out.printf("%2s,", n[ptr].data);
			ptr = n[ptr].next;
		}
		System.out.println();
	}
	
	public void purge(Comparator <? super T> c) {
		int ptr = this.head;
		
		
		while(ptr != NULL) {
			int count = 0;
			int pre = ptr;
			int ptr2 = ptr;
			
			
			while(ptr2 != NULL) {
				ptr2 = n[pre].next;
				
				if(ptr2 != NULL && c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				}else {
					pre = ptr2;
				}
			}
			
			if(count == 0) {
				ptr = n[ptr].next;
			}else {
				int temp = ptr;
				remove(ptr);
				ptr = n[temp].next;
			}
		}
			
	}
	
	public T retrieve(int num) {
		int ptr = this.head;
		
		while(num >= 0 && ptr != NULL) {
			if(num-- == 0) {
				this.crnt = ptr;
				return this.n[ptr].data;
			}
			ptr = this.n[ptr].next;
		}
		
		return null;
	}
	
	public T getFirst() {
		return n[this.head].data;
	}
	public T getLast() {
		return n[this.max].data;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int indexOf(T data) {
		int ptr = this.head;
		
		while(ptr != NULL) {
			if(n[ptr].data == data) return ptr;
			ptr = n[ptr].next;
		}
		
		return -1;
	}
	
	public boolean contains(T data) {
		return indexOf(data) > 0 ? true:false;
	}
} 
