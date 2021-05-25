package algorithm.exception;

public class QueException {
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {
            System.out.println("큐가 비어 있습니다.");
        }
    }

    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {
            System.out.println("큐가 가득 찼습니다.");
        }
    }
}
