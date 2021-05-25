package algorithm.model;

import algorithm.exception.StackException.EmptyStackException;
import algorithm.exception.StackException.OverflowStackException;

public class GStack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    @SuppressWarnings("unchecked")
    public GStack(int size) {
        this.stk = (E[]) new Object[size];
        this.ptr = 0;
        this.max = size;
    }

    public int size() {
        return ptr;
    }

    public int capacity() {
        return max;
    }

    public E push(E n) throws OverflowStackException {
        if (ptr >= max) {
            throw new OverflowStackException();
        }
        return stk[ptr++] = n;
    }

    public E pop() throws EmptyStackException {
        if (ptr <= 0) {
            throw new EmptyStackException();
        }
        return stk[--ptr];
    }

    public E peek() throws EmptyStackException {
        if (ptr <= 0) {
            throw new EmptyStackException();
        }
        return stk[ptr - 1];
    }

    public boolean isEmpty() {
        return ptr == 0 ? true : false;
    }

    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.println(stk[i]);
            }
        }
    }
}
