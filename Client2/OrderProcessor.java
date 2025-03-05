// OrderProcessor class

import java.util.*;

class OrderProcessor {
    private final Map<String, GenericOrder<?>> orders = new HashMap<>();

    // Accept a GenericOrder or its subclass
    public String accept(GenericOrder<?> order) {
        orders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    // Process orders into categorized collections
    public void process() {
        Map<String, List<ComputerPart>> computerParts = new HashMap<>();
        Map<String, List<Peripheral>> peripherals = new HashMap<>();
        Map<String, List<Cheese>> cheeses = new HashMap<>();
        Map<String, List<Fruit>> fruits = new HashMap<>();
        Map<String, List<Service>> services = new HashMap<>();

        for (Map.Entry<String, GenericOrder<?>> entry : orders.entrySet()) {
            String orderId = entry.getKey();
            GenericOrder<?> order = entry.getValue();

            List<ComputerPart> cpList = new ArrayList<>();
            List<Peripheral> pList = new ArrayList<>();
            List<Cheese> cList = new ArrayList<>();
            List<Fruit> fList = new ArrayList<>();
            List<Service> sList = new ArrayList<>();

            for (Product product : order.getProducts()) {
                if (product instanceof ComputerPart) {
                    cpList.add((ComputerPart) product);
                } else if (product instanceof Peripheral) {
                    pList.add((Peripheral) product);
                } else if (product instanceof Cheese) {
                    cList.add((Cheese) product);
                } else if (product instanceof Fruit) {
                    fList.add((Fruit) product);
                } else if (product instanceof Service) {
                    sList.add((Service) product);
                }
            }

            if (!cpList.isEmpty())
                computerParts.put(orderId, cpList);
            if (!pList.isEmpty())
                peripherals.put(orderId, pList);
            if (!cList.isEmpty())
                cheeses.put(orderId, cList);
            if (!fList.isEmpty())
                fruits.put(orderId, fList);
            if (!sList.isEmpty())
                services.put(orderId, sList);
        }

        // Dispatch sorted collections
        dispatchComputerParts(computerParts);
        dispatchPeripherals(peripherals);
        dispatchCheeses(cheeses);
        dispatchFruits(fruits);
        dispatchServices(services);
    }

    // Dispatch ComputerParts
    private void dispatchComputerParts(Map<String, List<ComputerPart>> computerParts) {
        System.out.println("------------------------------");
        System.out.println("Dispatching Computer Parts...");
        System.out.println("------------------------------");
        for (Map.Entry<String, List<ComputerPart>> entry : computerParts.entrySet()) {
            String orderId = entry.getKey();
            for (ComputerPart part : entry.getValue()) {
                String details = (part instanceof Motherboard) ? "name=" + ((Motherboard) part).getManufacturer()
                        : (part instanceof RAM)
                                ? "name=" + ((RAM) part).getManufacturer() + ", size=" + ((RAM) part).size
                                : "Unknown";
                System.out.println(part.getClass().getSimpleName() + " - " + details + ", price=$" + part.price()
                        + ", order number=" + orderId);
            }
        }
    }

    // Dispatch Peripherals
    private void dispatchPeripherals(Map<String, List<Peripheral>> peripherals) {
        System.out.println("------------------------------");
        System.out.println("Dispatching Peripherals...");
        System.out.println("------------------------------");
        for (Map.Entry<String, List<Peripheral>> entry : peripherals.entrySet()) {
            String orderId = entry.getKey();
            for (Peripheral peripheral : entry.getValue()) {
                String details = (peripheral instanceof Printer) ? "model=" + ((Printer) peripheral).getModel()
                        : (peripheral instanceof Monitor) ? "model=" + ((Monitor) peripheral).getModel() : "Unknown";
                System.out.println(peripheral.getClass().getSimpleName() + " - " + details + ", price=$"
                        + peripheral.price() + ", order number=" + orderId);
            }
        }
    }

    // Dispatch Cheeses
    private void dispatchCheeses(Map<String, List<Cheese>> cheeses) {
        System.out.println("------------------------------");
        System.out.println("Dispatching Cheeses...");
        System.out.println("------------------------------");
        for (Map.Entry<String, List<Cheese>> entry : cheeses.entrySet()) {
            String orderId = entry.getKey();
            for (Cheese cheese : entry.getValue()) {
                System.out.println(cheese.getClass().getSimpleName() + " - price=$" + cheese.price() + ", order number="
                        + orderId);
            }
        }
    }

    // Dispatch Fruits
    private void dispatchFruits(Map<String, List<Fruit>> fruits) {
        System.out.println("------------------------------");
        System.out.println("Dispatching Fruits...");
        System.out.println("------------------------------");
        for (Map.Entry<String, List<Fruit>> entry : fruits.entrySet()) {
            String orderId = entry.getKey();
            for (Fruit fruit : entry.getValue()) {
                System.out.println(
                        fruit.getClass().getSimpleName() + " - price=$" + fruit.price() + ", order number=" + orderId);
            }
        }
    }

    // Dispatch Services
    private void dispatchServices(Map<String, List<Service>> services) {
        System.out.println("------------------------------");
        System.out.println("Dispatching Services...");
        System.out.println("------------------------------");
        for (Map.Entry<String, List<Service>> entry : services.entrySet()) {
            String orderId = entry.getKey();
            for (Service service : entry.getValue()) {
                String details = (service instanceof AssemblyService)
                        ? "provider=" + ((AssemblyService) service).getProvider()
                        : (service instanceof DeliveryService) ? "courier=" + ((DeliveryService) service).getCourier()
                                : "Unknown";
                System.out.println(service.getClass().getSimpleName() + " - " + details + ", price=$" + service.price()
                        + ", order number=" + orderId);
            }
        }
    }
}
