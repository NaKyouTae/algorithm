package algorithm.codility;

public class FrogJump {
    public static void main(String[] args) {
        int x = 10;
        int y = 85;
        int d = 30;

        System.out.println((int) Math.ceil((int) (y - x) / (double) d));
    }
}
