package day0511;

public class SingletonPattern {
    private static class SingletonHolder {
        private static final SingletonPattern INSTANCE = new SingletonPattern();
    }

    private SingletonPattern() {
    }

    public static final SingletonPattern getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
