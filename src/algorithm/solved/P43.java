package algorithm.solved;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class P43 {
    @Test
    public void test() {
        Phy[] data = {
                new Phy("a", 173, 2.0),
                new Phy("b", 113, 1.3),
                new Phy("c", 123, 2.9),
                new Phy("d", 133, 2.3),
                new Phy("e", 174, 1.3),
                new Phy("f", 175, 2.3),
                new Phy("g", 176, 0.3),
                new Phy("h", 187, 2.2),
                new Phy("i", 173, 2.1),
                new Phy("j", 163, 0.3),
                new Phy("k", 183, 2.3),
                new Phy("l", 133, 0.3),
                new Phy("m", 143, 2.3),
                new Phy("n", 163, -2.3),
                new Phy("o", 173, -0.3),
                new Phy("p", 193, -1.3),
                new Phy("q", 153, -2.5)
        };

        Arrays.sort(data, Phy.HEIGHT_ORDER);

        for (int i = 0; i < data.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", data[i].name, data[i].height, data[i].vision);
    }

    static class Phy {
        String name;
        int height;
        double vision;


        public Phy(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<Phy> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<Phy> {
            public int compare(Phy p1, Phy p2) {
                return (p1.vision < p2.vision) ? 1 : (p1.vision > p2.vision) ? -1 : 0;
            }
        }


    }


}
