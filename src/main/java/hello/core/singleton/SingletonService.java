package hello.core.singleton;

public class SingletonService {

    // 1. Create only one instance in static field
    private static final SingletonService instance = new SingletonService();

    // 2. When the instance is needed, use this static method
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. Create a private constructor to prevent creating instance by using new
    private SingletonService() {
    }

    public void logic() {
        System.out.println("Call singleton instance logic.");
    }
}
