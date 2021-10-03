package algorithm.test.yanolja;

import java.util.Arrays;

public class Test41 {
    public static void main(String[] args) {
//        String L1 = "..xx.x."; // 4
//        String L2 = "x.x.x..";
        String L1 = ".xxx...x"; // 6
        String L2 = "..x.xxxx";
//        String L1 = "xxxxx"; // 5
//        String L2 = ".x..x";
//        String L1 = "x...x"; // 2
//        String L2 = "..x..";

        int l1Road = 0;
        int l2Road = 0;
        long min = Integer.MAX_VALUE;

        for (int i = 1; i < L1.length()-2; i++) {

            String[] pastL1 = L1.substring(0, i).split("");
            String[] pastL2 = L2.substring(0, i).split("");

            String[] postL1 = L1.substring(i, L1.length()).split("");
            String[] postL2 = L2.substring(i, L2.length()).split("");

            long pastL1Count = Arrays.stream(pastL1).filter(x -> x.equals("x")).count();
            long pastL2Count =  Arrays.stream(pastL2).filter(x -> x.equals("x")).count();

            long postL1Count = Arrays.stream(postL1).filter(x -> x.equals("x")).count();
            long postL2Count = Arrays.stream(postL2).filter(x -> x.equals("x")).count();

            long xRoad1 = Math.min((pastL1Count + postL1Count), (pastL1Count + postL2Count));
            long xRoad2 = Math.min((pastL2Count + postL1Count), (pastL2Count + postL2Count));

            min = Math.min(min, Math.min(xRoad1, xRoad2));
        }

        long pastL1 = Arrays.stream(L1.split("")).filter(x -> x.equals("x")).count();
        long pastL2 =  Arrays.stream(L2.split("")).filter(x -> x.equals("x")).count();

        long total = pastL1 + pastL2;
        long roadMin = Math.min(pastL1, pastL2);

        min = Math.min(min, roadMin);

        System.out.println(total - min);
    }
}
