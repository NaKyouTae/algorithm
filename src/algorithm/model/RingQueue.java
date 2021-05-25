package algorithm.model;

import algorithm.exception.QueException.EmptyQueueException;
import algorithm.exception.QueException.OverflowQueueException;

public class RingQueue<T> {
    private int front;
    private int rear;
    private int max;
    private int num;
    private T[] que;

    @SuppressWarnings("unchecked")
    public RingQueue(int n, int size) {
        this.front = n;
        this.rear = n;
        this.num = 0;
        this.max = size;
        this.que = (T[]) new Object[size];
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getNum() {
        return num;
    }

    public int getMax() {
        return max;
    }

    public T enque(T x) {
        if (num == max) throw new OverflowQueueException();

        que[rear++] = x;
        num++;
        if (rear == max) rear = 0;

        return x;
    }

    public T deque() {
        if (num <= 0) throw new EmptyQueueException();

        int f = front++;

        T x = que[f];
        que[f] = null;
        num--;
        if (front == max) front = 0;

        return x;
    }

    public T peek() {
        return que[front];
    }

    public int search(T x) {
        for (int i = 0; i < num; i++) {
            int idx = i + front % max;

            if (que[idx] == x) return (idx + 1) % front;
        }

        return 0;
    }

    public int indexOf(T x) {

        for (int i = 0; i < num; i++) {
            int idx = i + front % max;

            if (que[idx] == x) return idx;
        }

        return -1;
    }

    public void clear() {
        num = front = max = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num == 0 ? true : false;
    }

    public boolean isFull() {
        return num == max ? true : false;
    }

    public void dump() {
        if (num <= 0) {
            throw new EmptyQueueException();
        }

        for (int i = 0; i < max; i++) {
            if (i == max - 1) {
                System.out.println(i + "|");
            } else {
                System.out.print(i + "|");
            }
        }

        for (int i = 0; i < max; i++) {
            if (que[i] == null) {
                if (i == max - 1) {
                    if (i > 9) {
                        System.out.println("  |");
                    } else {
                        System.out.println(" |");
                    }
                } else {
                    if (i > 9) {
                        System.out.print("  |");
                    } else {
                        System.out.print(" |");
                    }
                }
            } else {
                if (i == max - 1) {
                    if (i > 9) {
                        System.out.println(" " + que[i] + "|");
                    } else {
                        System.out.println(que[i] + "|");
                    }
                } else {
                    if (i > 9) {
                        System.out.print(" " + que[i] + "|");
                    } else {
                        System.out.print(que[i] + "|");
                    }
                }
            }
        }
    }

}
