package algorithm.programmers.level2;

public class Study16 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        int[][] map = new int[h][w];

        int[][] deleteMap = new int[0][0];

        if(w > h) {
            deleteMap = new int[2][3];

            deleteMap[0][0] = 1;
            deleteMap[0][1] = 1;
            deleteMap[1][1] = 1;
            deleteMap[1][2] = 1;
        }else if(w < h) {
            deleteMap = new int[3][2];
            deleteMap[0][0] = 1;
            deleteMap[1][0] = 1;
            deleteMap[1][1] = 1;
            deleteMap[2][1] = 1;
        }else {
            System.out.println(h);
        }

        for (int i = 0; i < deleteMap.length; i++) {
            for (int j = 0; j < deleteMap[0].length; j++) {
                System.out.print(deleteMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(i == i+deleteMap.length && j == j+deleteMap[0].length)
                map[i][j] = (deleteMap[i % deleteMap.length][j % deleteMap[0].length] == 1) ? 1 : 0;

                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
