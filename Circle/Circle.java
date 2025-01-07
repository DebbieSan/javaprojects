
/**
 * This program enables users to create a Circle and access detailed information about it. 
 * Using user-provided input, the program's methods calculate the circle's circumference, 
 * area, and determine whether a given point lies inside the circle.
 */

import java.util.Scanner;

public class Circle {

    private double x;
    private double y;
    private double radius;
    private static double maxradius = 200.00;
    public double point;

    /**
     * @param x      the x-coordinate
     * 
     * @param y      the y-coordinate
     * 
     * @param radius the radius of the circle
     * 
     */

    public Circle() {
        this.x = 2.0;
        this.y = 2.0;
        this.radius = 1;

    }

    public Circle(double cx, double cy, double r) {
        this.x = cx;
        this.y = cy;
        setRadius(r);

    }

    /**
     * the method below calculates the circunference of the circle
     * 
     * @return the circumference of the circle
     */

    public double circumference() {
        return 2 * Math.PI * radius;

    }

    /**
     * the method below calculates the area of the circle
     * 
     * @return the area of the circle
     */

    public double area() {
        return Math.PI * radius * radius;
    }

    public void setRadius(double r) {
        this.radius = (Math.abs(r) > maxradius) ? maxradius : Math.abs(r);
    }

    public void printAttributes() {
        System.out.println("Here is the circle information:");
        System.out.printf("The coordinates are: (%.2f, %.2f) %n", this.x, this.y);
        System.out.printf("The radius is: %.2f%n", this.radius);
        System.out.printf("The circumference is: %.2f%n", circumference());
        System.out.printf("The area is: %.2f%n", area());

    }

    /**
     * The following method checks if a point (x, y) lies inside or on the boundary
     * of the circle.
     * It uses the Pythagorean theorem to calculate the straight-line distance from
     * the
     * point (x, y) to the center of the circle (this.x, this.y), and then compares
     * that distance to the radius of the circle.
     *
     * In this method, the Pythagorean theorem is applied as follows:
     * - (x - this.x) represents the horizontal distance between the point
     * and the circle's center.
     * - (y - this.y) represents the vertical distance between the point and
     * the circle's center.
     * - The distance is the hypotenuse, which is the straight-line distance between
     * the point and the center.
     *
     * The formula applied is:
     * distance = √[(x - this.x)^2 + (y - this.y)^2]
     *
     * After calculating the distance, it is compared with the radius of the circle:
     * - If the distance is less than or equal to the radius, the point is inside or
     * on the circle,
     * so the method returns true.
     * - If the distance is greater than the radius, the point is outside the
     * circle, and the method returns false.
     */

    public boolean isInside(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        System.out.println("Distance from point to centre: " + distance);
        System.out.println("Circle radius: " + this.radius);

        if (distance <= this.radius) {
            System.out.println("The point (" + x + ", " + y + ") is inside the circle.");
            return true;
        } else {
            System.out.println("The point (" + x + ", " + y + ") is outside the circle.");
            return false;
        }
    }

    /**
     * Moves the circle's center by the specified amounts in the x and y directions.
     *
     * @param x the amount to move the circle horizontally
     * @param y the amount to move the circle vertically
     */

    public void move(double x, double y) {
        this.x += x;
        this.y += y;
        System.out.println("Your new center is: " + this.x + ", " + this.y);

    }

    public static void main(String[] args) {
        System.out
                .println("------------------------------------------------------------------------------------------");
        System.out
                .println(
                        "Welcome to Circle world! This program let's you find information about your favourite circle!");
        System.out
                .println("------------------------------------------------------------------------------------------");
        System.out.println();

        /**
         * ----- IN CODE TEST ZONE ------
         * the code below showcases the class methods. It is a testing code use to
         * demonstrate to the user how their information will be generated.
         * You may comment it out if you want to just use the interactive program
         * instead.
         */

        System.out.println("This is my circle.");
        System.out
                .println("------------------------------------------------------------------------------------------");
        Circle circle = new Circle(1.00, 2.00, 0);
        circle.printAttributes();

        System.out.println("Moving my circle");
        circle.move(3, 1);

        System.out.println("Checking to see if a point is inside my circle");
        circle.isInside(50.00, 100.00);

        System.out.println();

        /**
         * --- TEST DRIVER RUNS---
         * The code below runs the CircleTest class that contains tests for Circle.java
         */

        CircleTest testrun = new CircleTest();

        testrun.CircleTestRuns();

        /** ------ INTERACTIVE PROGRAM STARTS HERE ---------- */

        Scanner scanner = new Scanner(System.in); // Use the scanner class to obtain input from user
        boolean makeCircles = true; // Controls the while loop

        while (makeCircles) {

            System.out.println("Would you like to create a circle ? Type Y for Yes and N for No");

            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println(
                        "Great! Let's create your circle, learn about it and play with it! Please use numerical values only.");
                try {
                    // Get initial circle details
                    System.out.println("Enter the x-coordinate (horizontal position) of your circle's center:");
                    double userX = scanner.nextDouble();

                    System.out.println("Enter the y-coordinate (vertical position) of your circle's center:");
                    double userY = scanner.nextDouble();

                    System.out.println("Enter your circle's radius:");
                    double userRadius = scanner.nextDouble();

                    // Create a Circle object
                    Circle yourCircle = new Circle(userX, userY, userRadius);

                    // Print circle attributes
                    System.out.println("Here are the attributes of your circle:");
                    yourCircle.printAttributes();

                    // Move the circle
                    System.out.println("Great! Now let's move your circle.");
                    System.out.println("Enter the new x-coordinate to move the circle horizontally:");
                    double newX = scanner.nextDouble();

                    System.out.println("Enter the new y-coordinate to move the circle vertically:");
                    double newY = scanner.nextDouble();

                    yourCircle.move(newX, newY);
                    System.out
                            .println(
                                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Your circle has been moved.");
                    System.out
                            .println(
                                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    yourCircle.printAttributes();

                    System.out.println();

                    // Check if a point is inside the circle
                    System.out.println("Let's check if a specific point is inside your circle.");
                    System.out.println("Enter the x-coordinate of the point to check:");
                    double pointX = scanner.nextDouble();

                    System.out.println("Enter the y-coordinate of the point to check:");
                    double pointY = scanner.nextDouble();

                    boolean isInside = yourCircle.isInside(pointX, pointY);
                    if (isInside) {
                        System.out.println("The point (" + pointX + ", " + pointY + ") is inside the circle!");
                    } else {
                        System.out.println("The point (" + pointX + ", " + pointY + ") is outside the circle.");
                    }
                    System.out
                            .println(
                                    "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("So much fun!");
                    System.out.println(
                            "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    // Clear the scanner buffer
                    scanner.nextLine();

                } catch (Exception e) {
                    // Handles invalid input

                    System.out.println("Invalid input. Please enter a double value for coordinates and radius");
                }

            } else if (answer.equalsIgnoreCase("N")) {
                // Exits the program if the user decides not to make more circles.
                System.out.println("No problem. Have a nice day!");
                makeCircles = false;

            } else {
                // Handles invalid input
                System.out.println("Invalid option. Please type Y for Yes or N for No.");
            }

        }
        scanner.close(); // closes the scanner to protect resources
    }

}
