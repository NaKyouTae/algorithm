package sample;

import java.io.IOException;

public class Child extends AbstractSample {

    private int a;
    private static int b;

    static {
        System.out.println("클래스 초기화");
    }


    Child() {
        System.out.println("인스턴스 생성");
    }

    @Override
    public int get() {
        return 1;
    }

    @Override
    public boolean set() {
        return false;
    }

    public int  me() throws Exception {
        try (CustomAutoCloseable c = new CustomAutoCloseable()) {
            return 1;
        } catch (IOException e) {
            ArithmeticException ae = new ArithmeticException();
            ae.initCause(e);
            throw ae;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
