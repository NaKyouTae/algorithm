package algorithm.exception;

public class StackException {
	public static class EmptyStackException extends RuntimeException{
		public EmptyStackException() {
			System.out.println("스택이 비어 있습니다.");
		}
	}
	public static class OverflowStackException extends RuntimeException{
		public OverflowStackException() {
			System.out.println("스택이 가득 찼습니다.");
		}
	}
}
