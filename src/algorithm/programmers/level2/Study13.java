package algorithm.programmers.level2;

/**
 * 124 나라의 숫자자 * */
public class Study13 {
    public static void main(String[] args) {
        int n = 10;

        int[] notation = {4, 1, 2};


//        for (int i = 1; i <= n; i++) {
//            int num = i;
            String res = "";

            while(n > 0) {
                res = notation[n % notation.length] + res;
                n = (n - 1) / notation.length;
            }

            System.out.println(res);

//            System.out.println((first * 10) + last);
//        }
    }
}
