package algorithm.solved;

import java.util.Comparator;

import algorithm.model.GLinkedList;
import org.junit.Test;

/**
 * @author nkt
 * P. 331 9-1
 * <p>
 * Create by User Date : 2020. 12. 28.
 */
public class P52LinkedList {
    @Test
    public void test() {
        GLinkedList<Integer> gl = new GLinkedList<>();

        gl.addLast(1);
        gl.addLast(2);
        gl.addLast(3);
        gl.addLast(4);
        gl.addLast(13);
        gl.addFirst(6);
        gl.addLast(7);
        gl.addLast(8);
        gl.addLast(9);
        gl.addLast(10);
        gl.addLast(11);
        gl.addLast(13);
        gl.addLast(12);


        gl.removeFirst();
        gl.removeFirst();
        gl.removeLast();
        gl.removeFirst();


        gl.dump();
//		gl.purge(Order);
        gl.dump();

        int n = 10;

        System.out.println("요청 노트 번호 : " + n + ", 노드 값 : " + gl.retrieve(n));
        System.out.println(gl.lastIndexOf(13));
        System.out.println(gl.getSize());
        System.out.println(gl.getLast());
        System.out.println(gl.contains(13));

    }

    public static final Comparator<Integer> Order = new GComparator();

    private static class GComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer s, Integer t) {
            return (s > t) ? 1 : (s < t) ? -1 : 0;
        }
    }


}
