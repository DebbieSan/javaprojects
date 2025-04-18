//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

package tme3;

import java.util.*;

public class Controller {
  // A class from java.util to hold Event objects:
  private List<Event> eventList = new ArrayList<Event>();

  public void addEvent(Event c) {
    eventList.add(c);
  }

  public void run() {
    while (eventList.size() > 0)
      // Make a copy so you're not modifying the list
      // while you're selecting the elements in it:

      for (Event e : new ArrayList<Event>(eventList))
        if (e.ready()) {
          System.out.println(e);
          try {
            e.action();
          } catch (ControllerException err) {
            shutDown();
          }
          eventList.remove(e);

        }
  }

  public void shutDown() {
    System.err.println("Shutdown default message!!!!!!!!!");
  }
}
