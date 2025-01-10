class Bicycle extends Cycle {

    @Override
    public int wheels() {
        return 2;
    }

    @Override
    public void ride() {
        System.out.println("I am riding my bicycle!");
        wheels();
        System.out.println("It has " + wheels() + " wheels.");
    }
}