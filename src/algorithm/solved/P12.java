package algorithm.solved;

import java.time.LocalDate;

import org.junit.Test;

public class P12 {
	@Test
	public void test() {
		YMD after = YMD.after(240);
		YMD before = YMD.before(240);
		
		System.out.println(after.y + "-" + after.m + "-" + after.d);
		System.out.println(before.y + "-" + before.m + "-" + before.d);
	}
	
	public static class YMD {
		private int y;
		private int m;
		private int d;
		
		YMD(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		}
		
		static YMD after(long n) {
			LocalDate date = LocalDate.now().minusDays(n);
			return new YMD(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		}
		
		static YMD before(long n) {
			LocalDate date = LocalDate.now().plusDays(n);
			return new YMD(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		}
	}
}
