package algorithm.model;

import java.util.Comparator;

public class GLinkedList<T> {
    class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> crnt;
    private Node<T> tail;
    private int size = 0;

    public GLinkedList() {
        this.head = this.crnt = null;
    }

    public T search(T data, Comparator<? super T> c) {
        Node<T> ptr = this.head;

        while (ptr != null) {
            if (c.compare(data, ptr.data) == 0) {
                this.crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }

        return null;
    }

    /**
     * 가장 앞쪽에 Node 추가
     *
     * @param data
     */
    public void addFirst(T data) {
        Node<T> ptr = this.head;
        head = crnt = new Node<T>(data, ptr, null);
        this.tail = ptr;
        size++;
    }

    /**
     * 가장 뒷쪽에 Node 추가
     *
     * @param data
     */
    public void addLast(T data) {
        if (this.head == null) addFirst(data);
        else {
            Node<T> ptr = this.head;
            while (ptr.next != null)
                ptr = ptr.next;

            ptr.next = crnt = new Node<T>(data, null, ptr);
            this.tail = ptr.next;
            size++;
        }
    }

    public void remove(Node<T> data) {
        if (this.head != null) {
            if (data == this.head) {
                removeFirst();
            } else {
                Node<T> ptr = this.head;

                while (ptr.next != data) {
                    ptr = ptr.next;
                    if (ptr == null) return;
                }
                ptr.next = data.next;
                ptr.next.prev = ptr;
                this.crnt = ptr;
                size--;
            }
        }
    }

    public void removeFirst() {
        if (this.head != null)
            this.head = this.crnt = this.head.next;
        size--;
        this.head.prev = null;

    }

    public void removeLast() {
        if (this.head != null) {
            if (this.head.next == null) {
                removeFirst();
            } else {
                Node<T> ptr = this.head;
                Node<T> pre = this.head;

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                this.crnt = pre;
                this.tail = pre;
                size--;
            }
        }
    }

    public void removeCurrentNode() {
        remove(this.crnt);
    }

    public void clear() {
        while (this.head != null) {
            removeFirst();
        }
        this.crnt = null;
    }

    public boolean next() {
        if (this.crnt == null || this.crnt.next == null) {
            return false;
        }
        this.crnt = this.crnt.next;
        return true;
    }

    public void printCurrentNode() {
        if (this.crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }

    public void dump() {
        Node<T> ptr = this.head;

        while (ptr != null) {
            System.out.printf(ptr.data + ", ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public void purge(Comparator<? super T> c) {
        Node<T> ptr = this.head;

        while (ptr != null) {
            int count = 0;
            Node<T> ptr2 = ptr;
            Node<T> pre = ptr;

            while (pre.next != null) {
                // 현재 노트 다음을 비교 값인 ptr2에 삽입
                ptr2 = pre.next;

                if (c.compare(ptr.data, ptr2.data) == 0) {
                    // 매치된 값이 있다면 해당 노트 삭제 후 다음 노트를 해당 노드 이전의 next에 삽입
                    // 매치된 값 중 뒤의 값을 삭제
                    // 카운트 1 더하기
                    pre.next = ptr2.next;
                    count++;
                    size--;
                } else {
                    // 매치된 값이 없다면 현재 위치 노드 pre에 삽입
                    pre = ptr2;
                }
            }
            if (count == 0) {
                // 매치된 값이 없다면 다음 노드로 이동
                ptr = ptr.next;
            } else {
                // 매치된 값이 있다면 해당 노트 삭제 후 다음 노트를 해당 노드 이전의 next에 삽입
                // 매치된 값 중 앞의 값을 삭제
                Node<T> temp = ptr;
                remove(ptr);
                ptr = temp.next;
            }
        }
        this.crnt = this.head;
    }

    public T retrieve(int n) {
        Node<T> ptr = this.head;

        while (n >= 0 && ptr != null) {
            if (n-- == 0) {
                this.crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }

        return null;
    }

    public T getFirst() {
        return this.head.data;
    }

    public T getLast() {
        return this.tail.data;
    }

    public int getSize() {
        return this.size;
    }

    public int indexOf(T data) {
        Node<T> ptr = this.head;
        int idx = 0;

        while (ptr.next != null) {
            if (ptr.data == data) return idx;
            ptr = ptr.next;
            idx++;
        }

        return -1;
    }

    public int lastIndexOf(T data) {
        Node<T> ptr = this.tail;
        int idx = this.size - 1;

        while (ptr.prev != null) {
            if (ptr.data == data) return idx;
            ptr = ptr.prev;
            idx--;
        }

        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) > 0;
    }
}
