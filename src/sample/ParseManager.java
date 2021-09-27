package sample;

public class ParseManager {
    public Aable s = new Aable() {
        public int a;
    };
    public static Parseable getParse(String type) {
        if(type.equals("1")) {
            return new Parse1();
        } else {
            return new Parse2();
        }
    }

    static class Inner {
        public int a;
    }
}