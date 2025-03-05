import java.util.*;

// Base class for orders extending Product

class GenericOrder<T extends Product> {
    private static int idCounter = 1;
    private final String orderId;
    private final List<T> items;

    public GenericOrder() {
        this.orderId = "Order-" + idCounter++;
        this.items = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    // Add a product to the order
    public void addProduct(T product) {
        items.add(product);
    }

    // Get all products in the order
    public List<T> getProducts() {
        return items;
    }

    // Calculate the total price of the order
    public float calculateTotalPrice() {
        float total = 0;
        for (T item : items) {
            total += item.price();
        }
        return total;
    }

    // Display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Details...");
        for (T item : items) {
            System.out.println("- " + item.getClass().getSimpleName() + ", Price: $" + item.price());
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}
