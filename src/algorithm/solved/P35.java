package algorithm.solved;

import org.junit.Test;

public class P35 {
	@Test
	public void main() {
		A a1 = new A();
		A a2 = new A();
		B b1 = new B(12);
		B b2 = new B(77);
		
		
		System.out.println(a1);
		System.out.println(a2.toString());
		System.out.println(b2);
		System.out.println(b1);
	}
	
	class A{
		
	}
	
	class B{
		int x;
		
		B(int x) {this.x = x;}
		
		public String toString() {return "B["+x+"]";}
	}
}
