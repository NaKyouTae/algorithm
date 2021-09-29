package algorithm.programmers.level2;

/**
 * 땅따 먹기
 * */
public class Study9 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < land[0].length; k++) {
                    if(j == k) continue;
                    max = Math.max(max, land[i][j] + land[i-1][k]);
                }
                System.out.println(i + " : " + j + " : " + max);
                land[i][j] = max;
                res = Math.max(res, max);
            }
        }

        for(int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                System.out.print(land[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(res);
    }
}
