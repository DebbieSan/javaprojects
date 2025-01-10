class Unicycle extends Cycle {

    @Override
    public int wheels() {
        return 1;
    }

    @Override
    public void ride() {
        System.out.println("I am riding my unicycle!");
        wheels();
        System.out.println("It has " + wheels() + " wheel.");

    }

}