/*
 * This class is the test driver for the Circle program. Add tests in here to
 * ensure the program is running accordingly.
 */

public class CircleTest {

    public void CircleTestRuns() {

        /*
         * --- Test 1 ---
         * Create a circle with valid parameters and create a circle without parameters.
         */

        System.out.println("These are my test circles");
        System.out
                .println("------------------------------------------------------------------------------------------");

        Circle circleValid = new Circle(1, 3, 2);

        Circle circleAlsoValid = new Circle();

        /*
         * --- Test 2 ---
         * Print the information based on the circles created above.
         */

        circleValid.printAttributes();

        System.out.println();

        circleAlsoValid.printAttributes();

        System.out.println();

        System.out.println("Test ends here.");

        System.out.println();

    }
}