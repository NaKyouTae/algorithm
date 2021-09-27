package sample;

public class Singleton {

    private static Singleton s = new Singleton();

    public static Singleton getInstance() {
        return s;
    }
}
