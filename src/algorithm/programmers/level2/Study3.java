package algorithm.programmers.level2;

/**
 * 2차원 배열의 곱셈
 * */
public class Study3 {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        int x = Math.max(arr1.length, arr2.length);
        int y = Math.max(arr1[0].length, arr2[0].length);

        int[][] list = new int[x][y];

        for(int i = 0; i < list.length; i++) {
            for(int j = 0; j < list[0].length; j++) {
                for(int k = 0; k < list[0].length; k++) {
                    list[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }
}
