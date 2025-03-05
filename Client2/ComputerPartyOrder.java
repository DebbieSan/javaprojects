// Subclass ComputerPartyOrder extending GenericOrder
class ComputerPartyOrder extends GenericOrder<Product> {

    // Add a computer part to the order
    public void addComputerPart(ComputerPart part) {
        addProduct(part);
    }

    // Add a peripheral to the order
    public void addPeripheral(Peripheral peripheral) {
        addProduct(peripheral);
    }

    // Add a cheese to the order
    public void addCheese(Cheese cheese) {
        addProduct(cheese);
    }

    // Add a fruit to the order
    public void addFruit(Fruit fruit) {
        addProduct(fruit);
    }

    // Add a service to the order
    public void addService(Service service) {
        addProduct(service);
    }

    // Display specific categories (optional)
    public void displayOrderDetails() {
        System.out.println("Computer Party Order Details:");
        super.displayOrderDetails();
    }
}
