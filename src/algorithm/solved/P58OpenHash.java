package algorithm.solved;

import algorithm.model.OpenHash;
import org.junit.Test;

/**
 * @author : "NKT"
 * @date : 2021-01-07 15:23
 * @description ==============================================================
 * Hash
 * P 426
 * ==============================================================
 */
public class P58OpenHash {
    @Test
    public void test() {
        OpenHash<Integer, Integer> hash = new OpenHash<>(50);

        hash.add(1, 1234325);
        hash.add(1, 342643);
        hash.add(1, 567568);
        hash.add(423, 456);
        hash.add(5643, 345634534);
        hash.add(43, 1234);
        hash.add(132, 2345345);
        hash.add(567, 1234123);
        hash.add(897, 234657);
        hash.add(567, 3456756);
        hash.add(8567, 435745);
        hash.add(3564, 34524);
        hash.add(7456, 342543);
        hash.add(253, 1234132);
        hash.add(52, 52346748);
        hash.add(1, 785987068);
        hash.add(1, 567867);
        hash.add(21, 4567);
        hash.add(13, 435);
        hash.add(41, 5436);
        hash.add(51, 123);
        hash.add(1, 0);

        hash.dump();

        System.out.println(hash.search(1));
        hash.remove(13);
        hash.dump();
    }
}
