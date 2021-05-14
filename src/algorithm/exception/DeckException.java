package algorithm.exception;

public class DeckException {
	public static class EmptyDeckException extends RuntimeException{
		public EmptyDeckException() {
			System.out.println("덱이 비어 있습니다.");
		}
	}
	public static class OverflowDeckException extends RuntimeException{
		public OverflowDeckException() {
			System.out.println("덱이 가득 찼습니다.");
		}
	}
}
