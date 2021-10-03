package algorithm.test.yanolja;

import java.util.LinkedList;
import java.util.Queue;

public class Test4 {
    public static class Node {
        int x, y, p;
        Node(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    public static int pastXRoad = Integer.MIN_VALUE;
    public static boolean[][] visit;
    public static String[][] road;
    public static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) {
//        String L1 = "..xx.x."; // 4
//        String L2 = "x.x.x..";
//        String L1 = ".xxx...x"; // 6
//        String L2 = "..x.xxxx";
//        String L1 = "xxxxx"; // 5
//        String L2 = ".x..x";
        String L1 = "x...x"; // 2
        String L2 = "..x..";


        int len = L1.length();
        int xTotalCount = 0;

        road = new String[len][2];

        for (int i = 0; i < len; i++) {
            char l1Road = L1.charAt(i);
            char l2Road = L2.charAt(i);

            road[i][0] = String.valueOf(l1Road);
            road[i][1] = String.valueOf(l2Road);

            if(l1Road == 'x') xTotalCount++;
            if(l2Road == 'x') xTotalCount++;
        }

        for (int i = 0; i < 2; i++) {
            visit = new boolean[len][2];
            que.add(new Node(0, i, 0));
            findRoad(0);
        }

        System.out.println(xTotalCount);
        System.out.println(pastXRoad);
        System.out.println(xTotalCount - pastXRoad);
    }

    public static void findRoad(int xRoadCount) {
        int[] dy = {-1, 1};

        while(!que.isEmpty()) {

            Node node = que.poll();

            if(node.x >= road.length-1) {
                xRoadCount = 0;
                break;
            }


            int xx = node.x;

            for (int i = 0; i < 2; i++) {
                int yy = (node.x + i) % 2;

                que.add(new Node(xx+1, yy, road[xx][yy].equals("x") ? node.p : node.p + 1));
            }

            pastXRoad = Math.max(pastXRoad, node.p);
        }

    }
}
