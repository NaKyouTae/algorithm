package algorithm.programmers.level2;

/**
 * 숫자의 표현
 * */
public class Study7 {
    public static void main(String[] args) {
        int n = 15;

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if(sum > n) break;
                if(n == sum) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
