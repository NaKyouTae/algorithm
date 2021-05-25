package algorithm.naver.실제테스트;

public class Task3 {
    public static void main(String[] args) {
//		int[] blocks = {2, 6, 8, 5};
//		int[] blocks = {1, 5, 5, 2, 6};
        int[] blocks = {1, 1};

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < blocks.length; i++) {
            // frogs의 현재 위치
            int location = blocks[i];
            int cnt = 1;
            // frogs가 있는 위치에서 좌측으로 탐색
            for (int j = i; j < 0; j--) {
                if (blocks[j + 1] <= blocks[j]) {
                    cnt++;
                    System.out.println("L location : " + location + " , b : " + blocks[j] + " , c : " + cnt);
                }
            }

            // frogs가 있는 위치에서 우측으로 탐색
            for (int j = i + 1; j < blocks.length; j++) {
                if (blocks[j - 1] <= blocks[j]) {
                    cnt++;
                    System.out.println("R location : " + location + " , b : " + blocks[j] + " , c : " + cnt);
                }
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}
