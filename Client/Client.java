
// This class contains test cases to demonstrate how the program works.

class Client {
    public static void main(String[] args) {

        // Testing multiple orders

        // ComputerOrder 1
        ComputerOrder computerOrder1 = new ComputerOrder();
        computerOrder1.addComputerPart(new Motherboard("Gigabyte", 250));
        computerOrder1.addComputerPart(new RAM("Kingston", 32, 120));
        computerOrder1.addPeripheral(new Monitor("Dell UltraSharp", 300));
        computerOrder1.addService(new AssemblyService("GeekSquadettes", 75));

        // ComputerOrder 2
        ComputerOrder computerOrder2 = new ComputerOrder();
        computerOrder2.addComputerPart(new RAM("Crucial", 16, 90));
        computerOrder2.addPeripheral(new Printer("Canon Pixma", 700));
        computerOrder2.addService(new DeliveryService("FedEx", 40));

        // PartyTrayOrder 1
        PartyTrayOrder partyTrayOrder1 = new PartyTrayOrder();
        partyTrayOrder1.addCheese(new Mozzarella(10));
        partyTrayOrder1.addCheese(new Cheddar(50));
        partyTrayOrder1.addFruit(new Apple(10));
        partyTrayOrder1.addFruit(new Orange(1));
        partyTrayOrder1.addService(new DeliveryService("DHL", 120));

        // OrderProcessor
        OrderProcessor processor = new OrderProcessor();
        String computerOrderId1 = processor.accept(computerOrder1);
        String computerOrderId2 = processor.accept(computerOrder2);
        String partyTrayOrderId1 = processor.accept(partyTrayOrder1);

        // Process and dispatch orders
        processor.process();

        // Testing orders with edge cases

        // ComputerOrder with no computer parts but with peripherals and services
        ComputerOrder computerOrder = new ComputerOrder();
        computerOrder.addPeripheral(new Monitor("Samsung Curve", 250));
        computerOrder.addService(new AssemblyService("FixAit", 200));
        computerOrder.addService(new DeliveryService("SkiptheTech", 15));

        // PartyTrayOrder with only fruits and no cheeses or services
        PartyTrayOrder partyTrayOrder = new PartyTrayOrder();
        partyTrayOrder.addFruit(new Apple(10));
        partyTrayOrder.addFruit(new Orange(1));

        // ComputerOrder with duplicate components
        ComputerOrder duplicateOrder = new ComputerOrder();
        duplicateOrder.addComputerPart(new RAM("PQI Turbo", 1, 80));
        duplicateOrder.addComputerPart(new RAM("KVR 667", 8, 50)); // Duplicate
        duplicateOrder.addPeripheral(new Printer("HP LaserJet M110we", 137));

        // PartyTrayOrder with a single cheese type
        PartyTrayOrder singleCheeseOrder = new PartyTrayOrder();
        singleCheeseOrder.addCheese(new Cheddar(5));

        // OrderProcessor
        OrderProcessor processor2 = new OrderProcessor();
        String computerOrderId = processor2.accept(computerOrder);
        String partyTrayOrderId = processor2.accept(partyTrayOrder);
        String duplicateOrderId = processor2.accept(duplicateOrder);
        String singleCheeseOrderId = processor2.accept(singleCheeseOrder);

        // Process and dispatch orders
        processor.process();

    }
}
