package algorithm.test.yanolja;

public class Test3 {
    public static void main(String[] args) {
//        int[] A = {1, 2, 1}; // 2
//        int[] A = {2, 1, 4, 4}; // 1
        int[] A = {6, 2, 3, 5, 6, 3}; // 4


        int len = A.length;

        int total = ((1 + len) * len) / 2; // 배열의 길이만큼의 숫자 합을 구한다.
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        int moveCount = Math.abs(total - sum); // 현재 보유하고 있는 숫자와 최종 보유해야할 숫자를 뺄셈하여 최소 이동 횟수를 구한다.

        System.out.println(moveCount);
    }
}
