package algorithm.naver.실제테스트;

public class Task1 {
    public static void main(String[] args) {
        int[] A = {1, 0, 1, 0, 1, 1};
//		int[] A = {1, 1, 0, 1, 1};
//		int[] A = {0, 1, 0};
//		int[] A = {0, 1, 1, 0};


        int cnt = 0;
        for (int i = A.length / 2; i > 0; i--) {
            if (A[i] == A[i - 1]) {
                A[i - 1] = (A[i] == 0) ? 1 : 0;
                cnt++;
            }
        }

        for (int i = A.length / 2; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                A[i + 1] = (A[i] == 0) ? 1 : 0;
                cnt++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        System.out.println(cnt);
    }
}
