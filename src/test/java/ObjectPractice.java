import org.junit.jupiter.api.Test;

public class ObjectPractice {
    @Test
    public void workingWithOrders() {
        Order firstOrder = new Order();

        firstOrder.setTotalPrice(19.99);
        firstOrder.setAddress("Kleistu 18 - 85");
        firstOrder.setItemCount(5);

        Order secondOrder = new Order();

        secondOrder.setTotalPrice(12.34);
        secondOrder.setAddress("Raigas 11 - 22");
        secondOrder.setItemCount(7);
        System.out.println("First Order Price:");
        System.out.println(firstOrder.getTotalPrice());
        System.out.println("Second Order Price:");
        System.out.println(secondOrder.getTotalPrice());
    }
}
