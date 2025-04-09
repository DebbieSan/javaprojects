import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Restore {

    GreenhouseControls gc2;

    public Restore() {

        try (FileInputStream copyFile = new FileInputStream("./dump.out");
                ObjectInputStream restoreSystem = new ObjectInputStream(copyFile)) {

            GreenhouseControls gc2 = (GreenhouseControls) restoreSystem.readObject();
            System.out.println(gc2);
            gc2.getStatus();
            gc2 = gc2;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Oh no! What's happening! Something is going wrong! I am melting! AAAAAh!");
            System.err.println(e);

        }

    }

}
