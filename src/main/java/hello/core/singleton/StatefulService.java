package hello.core.singleton;

/**
 * Test for problems that may be caused by very common mistakes
 * Singleton must be stateless
 */
public class StatefulService {

    private int price; // Stateful field

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
