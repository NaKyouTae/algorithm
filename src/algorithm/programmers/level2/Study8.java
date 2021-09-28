package algorithm.programmers.level2;

/**
 * 땅따먹기
 * */
public class Study8 {

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        int sum = 0;
        int prevStep = -1;

        for(int i = 0; i < land.length; i++) {
            int max = Integer.MIN_VALUE;
            int step = -1;
            for (int j = 0; j < land[0].length; j++) {
                if(j == prevStep) continue;
                max = Math.max(max, land[i][j]);
                step = j;

            }
            System.out.println("max : " + max);

            prevStep = step;
            sum += max;
        }

        System.out.println(sum);
    }

}
