//: innerclasses/GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

// ***********************************************************************

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

import tme3.*;

public class GreenhouseControls extends Controller {
  private boolean light = false;
  private boolean water = false;
  private String thermostat = "Day";
  private String eventsFile = "examples1.txt";
  private boolean fans = false;

  public class LightOn extends Event {
    public LightOn(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here to
      // physically turn on the light.
      light = true;
    }

    public String toString() {
      return "Light is on";
    }
  }

  public class LightOff extends Event {
    public LightOff(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here to
      // physically turn off the light.
      light = false;
    }

    public String toString() {
      return "Light is off";
    }
  }

  public class WaterOn extends Event {
    public WaterOn(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here.
      water = true;
    }

    public String toString() {
      return "Greenhouse water is on";
    }
  }

  public class WaterOff extends Event {
    public WaterOff(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here.
      water = false;
    }

    public String toString() {
      return "Greenhouse water is off";
    }
  }

  public class ThermostatNight extends Event {
    public ThermostatNight(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here.
      thermostat = "Night";
    }

    public String toString() {
      return "Thermostat on night setting";
    }
  }

  public class ThermostatDay extends Event {
    public ThermostatDay(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Put hardware control code here.
      thermostat = "Day";
    }

    public String toString() {
      return "Thermostat on day setting";
    }
  }

  // An example of an action() that inserts a
  // new one of itself into the event list:
  public class Bell extends Event {
    private int ringsRemaining;

    public Bell(long delayTime, int rings) {
      super(delayTime);
      this.ringsRemaining = rings;
    }

    public void action() {
      // nothing to do
    }

    public String toString() {
      return "Bing!";
    }
  }

  public class Restart extends Event {
    public Restart(long delayTime, String filename) {
      super(delayTime);
      eventsFile = filename;
    }

    public void action() {

      /*
       * addEvent(new ThermostatNight(0));
       * addEvent(new LightOn(2000));
       * addEvent(new WaterOff(8000));
       * addEvent(new ThermostatDay(10000));
       * addEvent(new Bell(9000));
       * addEvent(new WaterOn(6000));
       * addEvent(new LightOff(4000));
       * addEvent(new Terminate(12000));
       **/
      try {
        Scanner scanner = new Scanner(new File(eventsFile));
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();

          // splitWords ==> String[4] { "Event", "ThermostatNight", "time", "0" }
          // splitWords ==> String[6] { "Event", "Bell", "time", "9000", "rings", "5" }
          String[] splitWords = line.split("\\=|,");
          String eventType = splitWords[1];
          long delay = Long.parseLong(splitWords[3]);

          switch (eventType) {
            case "ThermostatNight":
              addEvent(new ThermostatNight(delay));
              break;

            case "LightOn":
              addEvent(new LightOn(delay));
              break;

            case "WaterOff":
              addEvent(new WaterOff(delay));
              break;

            case "ThermostatDay":
              addEvent(new ThermostatDay(delay));
              break;

            case "Bell":
              String ringsStr = splitWords[5];
              int rings = Integer.parseInt(ringsStr);
              addEvent(new Bell(delay, rings));
              break;

            case "WaterOn":
              addEvent(new WaterOn(delay));
              break;

            case "LightOff":
              addEvent(new LightOff(delay));
              break;

            case "Terminate":
              addEvent(new Terminate(delay));
              break;

          }
        }

        scanner.close();

      } catch (FileNotFoundException e) {

      } catch (Exception e) {

      }

    }
  }

  public String toString() {
    return "Restarting system";
  }
}

public class Terminate extends Event {
  public Terminate(long delayTime) {
    super(delayTime);
  }

  public void action() {
    System.exit(0);
  }

  public String toString() {
    return "Terminating";
  }

  public static void printUsage() {
    System.out.println("Correct format: ");
    System.out.println("  java GreenhouseControls -f <filename>, or");
    System.out.println("  java GreenhouseControls -d dump.out");
  }

  public class FansOn extends Event {
    public FansOn(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Code to physically turn on the fans
      fans = true;
    }

    public String toString() {
      return "Fans are on";
    }
  }

  public class FansOff extends Event {
    public FansOff(long delayTime) {
      super(delayTime);
    }

    public void action() {
      // Code to physically turn off the fans
      fans = false;
    }

    public String toString() {
      return "Fans are off";
    }
  }

  // ---------------------------------------------------------
  public static void main(String[] args) {
    try {
      String option = args[0];
      String filename = args[1];

      if (!(option.equals("-f")) && !(option.equals("-d"))) {
        System.out.println("Invalid option");
        printUsage();
      }

      GreenhouseControls gc = new GreenhouseControls();

      if (option.equals("-f")) {
        gc.addEvent(gc.new Restart(0, filename));
      }

      gc.run();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid number of parameters");
      printUsage();
    }
  }

} /// :~
