package algorithm.programmers.level2;

/**
 * 가장 큰 정사각형 찾기
 * */
public class Study14 {
    public static void main(String[] args) {
        int[][] board = {
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,0,1,0}};	//9
//        int[][] map = {{0,0,1,1},{1,1,1,1}};	//4

        int[][] map = new int[board.length+1][board[0].length+1];

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                map[i+1][j+1] = board[i][j];
            }
        }

        int size = Integer.MIN_VALUE;
        for(int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if(map[i][j] == 0) continue;
                map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
                size = Math.max(size, map[i][j]);
            }
        }

        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(size * size);
    }
}
