package algorithm.solved;

import algorithm.model.GenericDeck;
import org.junit.Test;

public class P23 {
    @Test
    public void test() {
        GenericDeck<Integer> dec = new GenericDeck<>(0, 10);

        dec.enDeckFront(0);
        dec.enDeckRear(9);
        dec.enDeckFront(1);
        dec.enDeckRear(8);
        dec.dump();
    }
}
