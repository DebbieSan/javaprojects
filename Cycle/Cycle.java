public class Cycle {

    int numberOfWheels;

    public void ride() {

        System.out.println("I am riding");

    }

    public static void main(String[] args) {

        Cycle cycle = new Unicycle();

        cycle.ride();

        Cycle cycle2 = new Bicycle();

        cycle2.ride();

        Cycle cycle3 = new Tricycle();

        cycle3.ride();

    }

}