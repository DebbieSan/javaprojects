public class Client2 {
    public static void main(String[] args) {
        // Create a ComputerPartyOrder
        ComputerPartyOrder computerPartyOrder = new ComputerPartyOrder();

        // Add various items to the order
        computerPartyOrder.addComputerPart(new Motherboard("Gigabyte", 250));
        computerPartyOrder.addComputerPart(new RAM("Kingston", 32, 120));
        computerPartyOrder.addPeripheral(new Monitor("Dell UltraSharp", 300));
        computerPartyOrder.addCheese(new Cheddar(20));
        computerPartyOrder.addCheese(new Mozzarella(15));
        computerPartyOrder.addFruit(new Apple(3));
        computerPartyOrder.addFruit(new Orange(4));
        computerPartyOrder.addService(new DeliveryService("UPS", 30));
        computerPartyOrder.addService(new AssemblyService("BuildPro", 60));

        // Display the details of the order
        computerPartyOrder.displayOrderDetails();

        // Pass the order to the OrderProcessor
        OrderProcessor processor = new OrderProcessor();
        String orderId = processor.accept(computerPartyOrder);

        // Process and dispatch orders
        processor.process();
    }
}
