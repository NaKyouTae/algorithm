package algorithm.test.kakopay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Create By na kyutae 2021-10-31
 */

// 2. 가로가 x, 세로가 y이고 각 칸에는 숫자 s가 적혀 있는 말판이 있습니다.
// 네오와 프로도는 자기 말을 각각 왼쪽 상단과 오른쪽 상단에 두고 게임을 시작하려고 합니다.
// 말은 자기의 위치에서 아래 3칸(왼쪽아래, 아래, 오른쪽아래)중에 한곳으로만 이동할 수 있고, 두 말이 이동한 위치에 적힌 숫자의 총합이 게임의 점수가 됩니다.
// 각 칸에 점수가 적힌 말판이 주어질 때, 네오와 프로도가 얻을 수 있는 가장 높은 점수를 구하는 코드를 작성해주세요.
//
// 규칙
// - 말판의 가로 x, 세로 y의 범위는 3 < x, y < 50,
// - 각 칸의 점수 s의 범위는 -100 < s < 100
// - 입력은 2차원 배열로 주어집니다.
// - 말은 말판 밖으로 나갈 수 없습니다.
// - 두 말이 같은 칸으로 이동할 수 있지만, 점수는 한명에게만 주어집니다.
// - 입력처리
// 	첫번째 입력 : 가로 x 값
// 	두번째 입력 : 세로 y 값
// 	세번째 입력 : 맵 데이터 , 로 구분
//
// 예제 입출력
// 입력 :
// 3
// 4
// 3,1,1,2,5,1,1,5,5,2,1,1
// 출력 : 24
//
// 입력 :
// 7
// 5
// 1,0,0,0,0,0,1,2,0,0,0,0,3,0,2,0,9,0,0,0,0,0,3,0,5,4,0,0,1,0,2,3,0,0,6
// 출력 : 28

// 추가 케이스 1
// 입력 :
// 3
// 3
// 1,2,3,10,5,6,7,10,9
// 출력 : 39

// 추가 케이스 2
// 입력 :
// 3
// 3
// 1,2,3,6,5,10,9,10,7
// 출력 : 39

public class KakaopaySecurityTask2 {
    private static int[][] map;
    private static int X, Y, prodSum, neoSum;
    private static Map<String, Integer> prodMoves = new HashMap<>();
    private static Map<String, Integer> neoMoves = new HashMap<>();
    private static Map<String, Integer> neoSumMoves = new HashMap<>();
    private static Map<String, Integer> prodSumMoves = new HashMap<>();

    private static int prodMax = Integer.MIN_VALUE;
    private static int neoMax = Integer.MIN_VALUE;
    private static int max = Integer.MIN_VALUE;

    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        Y = Integer.parseInt(br.readLine());
        String map = br.readLine();

        System.out.println(findMaxPoint(map));
    }

    public static int findMaxPoint(String str) {

        map = new int[Y][X];
        visit = new boolean[Y][X];

        StringTokenizer st = new StringTokenizer(str, ",");

        for(int i = 0; i < Y; i++) {
            for(int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prodMove(1, 0, false);
        neoMove(1, X - 1);
        max = Math.max(max, prodMax + neoMax + map[0][0] + map[0][X-1]);

        prodMax = Integer.MIN_VALUE;
        prodSum = 0;
        neoMax = Integer.MIN_VALUE;
        neoSum = 0;

        prodMove(1, 0, true);
        max = Math.max(max, prodMax + neoMax + map[0][0] + map[0][X-1]);

        return max;
    }

    public static void prodMove(int idx, int y, boolean sameTime) {
        if(idx == Y) {
            if(prodMax <= prodSum) {
                prodSumMoves = new HashMap<>(prodMoves);
            }
            prodMax = Math.max(prodSum, prodMax);

            if(sameTime) {
                neoMove(1, X - 1);
            }
            return;
        }

        int dy[] = {-1, 0, 1};

        for(int i = 0; i < 3; i++) {
            int yy = y + dy[i];
            if (yy < X && yy >= 0) {
                if (!visit[idx][yy]) {
                    String key = String.valueOf(idx) + ", " + String.valueOf(yy);

                    if(neoSumMoves.containsKey(key)) continue;

                    visit[idx][yy] = true;
                    prodSum += map[idx][yy];
                    prodMoves.put(key, map[idx][yy]);
                    prodMove(idx+1, yy, sameTime);
                    prodMoves.remove(key);
                    prodSum -= map[idx][yy];
                    visit[idx][yy] = false;
                }
            }
        }
    }

    public static void neoMove(int idx, int y) {
        if(idx == Y) {
            if(neoMax <= neoSum) {
                neoSumMoves = new HashMap<>(neoMoves);
            }
            neoMax = Math.max(neoSum, neoMax);

            return;
        }

        int dy[] = {-1, 0, 1};

        for(int i = 0; i < 3; i++) {
            int yy = y + dy[i];
            if (yy < X && yy >= 0) {
                if (!visit[idx][yy]) {
                    String key = String.valueOf(idx) + ", " + String.valueOf(yy);

                    if(prodSumMoves.containsKey(key)) continue;

                    visit[idx][yy] = true;
                    neoSum += map[idx][yy];
                    neoMoves.put(key, map[idx][yy]);
                    neoMove(idx+1, yy);
                    neoMoves.remove(key);
                    neoSum -= map[idx][yy];
                    visit[idx][yy] = false;
                }
            }
        }
    }
}
