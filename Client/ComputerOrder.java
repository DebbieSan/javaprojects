// Subclass ComputerOrder extending GenericOrder
class ComputerOrder extends GenericOrder<Product> {

    // Add a computer part to the order
    public void addComputerPart(ComputerPart part) {
        addProduct(part);
    }

    // Add a peripheral to the order
    public void addPeripheral(Peripheral peripheral) {
        addProduct(peripheral);
    }

    // Add a service to the order
    public void addService(Service service) {
        addProduct(service);
    }

}
