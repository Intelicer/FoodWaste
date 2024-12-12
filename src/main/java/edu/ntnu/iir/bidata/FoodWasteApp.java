package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.ui.UserInterface;

/**
 * The Main class serves as the entry point for the FoodWasteApp application. It contains the main
 * method which initializes and starts the application.
 *
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class FoodWasteApp {

  
  /**
   * The main method which initializes and starts the application.
   *
   * @param arg command line arguments
   */
  public static void main(String[] arg) {
    // creating intance of FoodWasteApp
    // ? working ingredient code.
    UserInterface application = new UserInterface();
    application.inti();
    application.applicationStart();



  }

}

