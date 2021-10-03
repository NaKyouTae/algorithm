package algorithm.test.yanolja;

public class Test1 {

    private static final String ROCK = "R";
    private static final String PAPER = "P";
    private static final String SCISSORS = "S";

    public static void main(String[] args) {
//        String G = "RSPRS"; // 6
//        String G = "SRR"; // 4
//        String G = "PRPRRPP"; // 10
        String G = "PPPPRRSSSSS"; //13

        int rockCount = 0;
        int paperCount = 0;
        int scissorsCount = 0;

        for (int i = 0; i < G.length(); i++) {
            String oppenent = String.valueOf(G.charAt(i));

            switch (oppenent) {
                case ROCK:
                    rockCount++;
                    paperCount += 2;
                    break;
                case PAPER:
                    paperCount++;
                    scissorsCount += 2;
                    break;
                case SCISSORS:
                    scissorsCount++;
                    rockCount += 2;
                    break;
            }
        }

        int max = Math.max(rockCount, Math.max(paperCount, scissorsCount)); // 가장 많이 이긴 게임 수를 구한다.

        System.out.println(max);

    }
}
