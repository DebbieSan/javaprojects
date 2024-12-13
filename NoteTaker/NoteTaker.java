import java.util.Scanner;
import java.io.*;

/** A simple program to write notes. */

class NoteTaker {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Let's write notes together!");
        System.out.println("This program helps you write and read your notes so you don't forget them!");

        boolean active = true;

        while (active) {

            System.out.println("\nMenu:");
            System.out.println("1.Add Note");
            System.out.println("2.View Notes");
            System.out.println("3.Clear Notes");
            System.out.println("4.Exit");
            System.out.println("Choose your option");

            int choice = userInput.nextInt();
            userInput.nextLine();

            switch (choice) {

                case 1:
                    // Add Note
                    addNote(userInput);
                    break;

                case 2:
                    // View Notes
                    viewNotes();
                    break;

                case 3:
                    // Clear Notes
                    clearNotes();
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the NoteTaker program. Have a great day!");
                    active = false; // End the loop
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        userInput.close();

    }

    private static void addNote(Scanner userInput) {
        System.out.print("Enter your note: ");
        String note = userInput.nextLine();

        try (FileWriter writer = new FileWriter("notes.txt", true)) {
            writer.write(note + "\n");
            System.out.println("Note saved to notes.txt!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the note: " + e.getMessage());
        }
    }

    private static void viewNotes() {
        File file = new File("notes.txt");
        // Check if notes have been written inside the file.
        if (!file.exists()) {
            System.out.println("No notes found. Add some notes so we can read them!");
            return;
        }

        // Check if the file is empty
        if (file.length() == 0) {
            System.out.println("You haven't written any notes yet. Please write notes so you can read them.");
            return;
        }

        try (FileReader reader = new FileReader(file);
                BufferedReader bread = new BufferedReader(reader)) {

            // Prints content of notes.txt
            System.out.println("\n--- Contents of notes.txt ---");
            String line;
            while ((line = bread.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

    }

    private static void clearNotes() {
        File file = new File("notes.txt");

        if (!file.exists()) {
            System.out.println("No notes to clear. Add some notes first!");
            return;
        }

        try (FileWriter writer = new FileWriter(file)) { // Open file in write mode
            // Truncate the file by doing nothing (empty content)
            System.out.println("All notes cleared successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the notes: " + e.getMessage());
        }

    }

}
