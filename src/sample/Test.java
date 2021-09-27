package sample;

public class Test {
    public static void main(String[] args) throws Exception {
        Child c = new Child();
        Singleton s = Singleton.getInstance();

        Parseable parser = ParseManager.getParse("2");

        System.out.println("me : " + c.me());
    }
}
