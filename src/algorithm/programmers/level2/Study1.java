package algorithm.programmers.level2;

/**
 * N개의 최소 공배수 구하기
 *
 * */
public class Study1 {

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        int ans = arr[0];
        for(int i = 1; i < arr.length; i++) {
            ans = ans * arr[i] / gcd(ans, arr[i]);
        }

        System.out.println(ans);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
