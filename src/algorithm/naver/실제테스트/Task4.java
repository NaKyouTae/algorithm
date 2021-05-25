package algorithm.naver.실제테스트;

public class Task4 {
    public static void main(String[] args) {
//		int[] A = {2,4,1,6,5,9,7};
//		int[] A = {4,3,2,6,1};
//		int[] A = {2,1,6,4,3,7};
        int[] A = {7, 1, 2, 3, 5};

        int cnt = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) cnt++;
        }

        if (cnt > A.length / 2) cnt = 1;

        System.out.println(cnt);
    }
}
