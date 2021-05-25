package algorithm.solved;

import org.junit.Test;

public class P3 {
    @Test
    public void test() {

        main(0);

    }

    public void main(int num) {
        if (num > 0) {
            System.out.println("입력한 수는 양수입니다.");
        } else if (num < 0) {
            System.out.println("입력한 수는 음수입니다.");
        } else {
            System.out.println("입력한 수는 0입니다.");
        }
    }
}
