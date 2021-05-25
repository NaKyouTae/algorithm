package algorithm.solved;

import algorithm.model.GStackBack;
import org.junit.Test;

public class P20 {
    @Test
    public void test() {
        GStackBack<Integer> stk = new GStackBack<>(50);

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.pushBack(50);
        stk.pushBack(49);
        stk.pushBack(48);
        stk.pushBack(47);
        stk.pushBack(46);
        stk.pushBack(45);
        stk.pushBack(44);

        stk.dump();

        System.out.println();

        System.out.println("front size : " + stk.size());
        System.out.println("front peek : " + stk.peek());
        System.out.println("front pop : " + stk.pop());

        System.out.println();

        System.out.println("back size : " + stk.sizeBack());
        System.out.println("back peek : " + stk.peekBack());
        System.out.println("back pop : " + stk.popBack());


        stk.dump();
    }
}
