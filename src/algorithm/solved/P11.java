package algorithm.solved;

import java.util.Arrays;

import org.junit.Test;

public class P11 {

    static final int VMAX = 21;

    @Test
    public void test() {


        Physc[] x = {
                new Physc("나규태", 154, 2.0),
                new Physc("나규태1", 154, 2.0),
                new Physc("나규태2", 154, 1.0),
                new Physc("나규태3", 654, 1.1),
                new Physc("나규태4", 535, 1.1),
                new Physc("나규태5", 674, 1.0),
                new Physc("나규태6", 154, 1.0),
                new Physc("나규태7", 145, 1.0),
                new Physc("나규태8", 177, 2.2),
                new Physc("나규태9", 188, 2.6),
                new Physc("나규태9", 199, 2.2),
                new Physc("나규태10", 131, 2.9)
        };

        String[] v = new String[VMAX];

        distVision(x, v);

        for (int i = 0; i < VMAX; i++) {
            System.out.printf("%3.1f~:%s명\n", i / 10.0, v[i]);
        }

    }

    public void distVision(Physc[] data, String[] v) {
        Arrays.fill(v, "");

        for (int i = 0; i < data.length; i++) {
            int idx = (int) (data[i].vision * 10);
            if (data[i].vision >= 0.0 && data[i].vision <= VMAX / 10.0) {
                v[idx] += "*";
            }
        }
    }

    static class Physc {
        String name;
        int height;
        double vision;

        Physc(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return this.name + "," + this.height + ", " + this.vision;
        }
    }
}
