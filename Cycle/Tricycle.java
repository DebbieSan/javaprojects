class Tricycle extends Cycle {

    public int wheels() {
        return 3;
    }

    @Override
    public void ride() {
        System.out.println("I am riding my tricycle!");
        wheels();
        System.out.println("It has " + wheels() + " wheels.");

    }
}