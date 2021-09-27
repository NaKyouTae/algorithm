package sample;

public interface Aable extends Parseable {
    default int getAge() {
        return 0;
    }
}
