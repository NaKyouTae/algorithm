package algorithm.solved;

import algorithm.model.ChainHash;
import org.junit.Test;

/**
 * @author      : "NKT"
 * @date        : 2021-01-07 17:02

 * @description
 * ==============================================================
 * ChainHash
 * P 408
 * ==============================================================
 */
public class P59ChainHash {
	@Test
	public void test() {
		ChainHash<Integer, Integer> c = new ChainHash<>(30);
		
		c.add(1, 0);
		c.add(31, 2);
		c.add(61, 0);
		c.add(91, 0);
		c.add(121, 0);
		c.add(151, 0);
		c.add(181, 0);
		c.add(211, 0);
		c.add(241, 0);
		c.add(271, 0);
		c.add(301, 0);
		
		c.remove(121);
		c.dump();
		
	}
}
