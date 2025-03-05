// Subclass PartyTrayOrder extending GenericOrder
class PartyTrayOrder extends GenericOrder<Product> {

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

}
