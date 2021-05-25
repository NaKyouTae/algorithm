package algorithm.solved;

import algorithm.model.RingQueue;
import org.junit.Test;

public class P22 {
    @Test
    public void test() {
        RingQueue<Integer> que = new RingQueue<>(6, 20);

        que.enque(1);
        que.enque(2);
        que.enque(3);
        que.enque(4);
        que.enque(5);
        que.enque(6);


        que.dump();
        System.out.println("front : " + que.getFront());
        System.out.println("rear : " + que.getRear());
        System.out.println("num : " + que.getNum());
        System.out.println("capacity : " + que.capacity());
        System.out.println("size : " + que.size());
        System.out.println("peek : " + que.peek());
        System.out.println("indexOf : " + que.indexOf(5));
        System.out.println("empty : " + que.isEmpty());
        System.out.println("full : " + que.isFull());
        System.out.println("deque : " + que.deque());
        que.dump();

        System.out.println();
        que.dump();
        System.out.println("front : " + que.getFront());
        System.out.println("rear : " + que.getRear());
        System.out.println("num : " + que.getNum());
        System.out.println("capacity : " + que.capacity());
        System.out.println("size : " + que.size());
        System.out.println("peek : " + que.peek());
        System.out.println("indexOf : " + que.indexOf(5));
        System.out.println("empty : " + que.isEmpty());
        System.out.println("full : " + que.isFull());
        System.out.println("deque : " + que.deque());
        que.dump();

        System.out.println();
        que.dump();
        System.out.println("front : " + que.getFront());
        System.out.println("rear : " + que.getRear());
        System.out.println("num : " + que.getNum());
        System.out.println("capacity : " + que.capacity());
        System.out.println("size : " + que.size());
        System.out.println("peek : " + que.peek());
        System.out.println("indexOf : " + que.indexOf(5));
        System.out.println("empty : " + que.isEmpty());
        System.out.println("full : " + que.isFull());
        System.out.println("enque : " + que.enque(9));
        que.dump();

        System.out.println();
        System.out.println("front : " + que.getFront());
        System.out.println("rear : " + que.getRear());
        System.out.println("num : " + que.getNum());
        System.out.println("capacity : " + que.capacity());
        System.out.println("size : " + que.size());
        System.out.println("peek : " + que.peek());
        System.out.println("indexOf : " + que.indexOf(5));
        System.out.println("empty : " + que.isEmpty());
        System.out.println("full : " + que.isFull());


        System.out.println(que.search(4));
    }
}
