/**
 * This class serves as the test driver for the Circle program, providing
 * predefined tests to verify its functionality and ensure it operates
 * correctly.
 * Alternatively, the Circle program can be tested interactively by using its
 * user-friendly interface, allowing users to input data and experiment with the
 * program's features.
 */

public class CircleTest {

    public void CircleTestRuns() {

        /**
         * --- Test 1 ---
         * Create a circle with valid parameters and create a circle without parameters.
         */

        System.out.println("These are my test circles");
        System.out
                .println("------------------------------------------------------------------------------------------");

        Circle circleValid = new Circle(1, 3, 2);

        Circle circleAlsoValid = new Circle();

        /**
         * --- Test 2 ---
         * Print the information based on the circles created above.
         */

        circleValid.printAttributes();

        System.out.println();

        circleAlsoValid.printAttributes();

        System.out.println();

        System.out.println("Test ends here.");

        System.out.println();

        /**
         * --- Test 3 ---
         * Creating a circle with a zero radius
         */
        try {
            System.out.println("\nTest 2: Circle with Zero Radius");
            Circle zeroRadiusCircle = new Circle(0, 0, 0);
            zeroRadiusCircle.printAttributes();
        } catch (Exception e) {
            System.out.println("Test 2 Failed: " + e.getMessage());
        }

        /**
         * --- Test 4 ---
         * Creating a circle with neative radius
         */

        try {
            System.out.println("\nTest 3: Circle with Negative Radius");
            Circle negativeRadiusCircle = new Circle(0, 0, -10);
            negativeRadiusCircle.printAttributes();
        } catch (Exception e) {
            System.out.println("Test 3 Failed: " + e.getMessage());
        }

        /**
         * --- Test 5 ---
         * Creating a circle with a very large radius
         */

        try {
            System.out.println("\nTest 4: Circle with Extremely Large Radius");
            Circle largeRadiusCircle = new Circle(0, 0, 1_000_000);
            largeRadiusCircle.printAttributes();
        } catch (Exception e) {
            System.out.println("Test 4 Failed: " + e.getMessage());
        }
    }
}