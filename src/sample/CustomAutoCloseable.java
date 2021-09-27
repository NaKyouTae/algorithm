package sample;

public class CustomAutoCloseable implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("닫기");
    }
}
