package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.ui.FoodWasteUserInterface;

/**
 * The Main class serves as the entry point for the FoodWasteApp application. It contains the main
 * method which initializes and starts the application.
 *
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class FoodWasteApp {
  private static FoodWasteUserInterface applicationStart = new FoodWasteUserInterface();

  /**
   * Initializes the application by displaying the ingredients.
   * This method is typically called at the start of the application to set up the initial state.
   */
  public static void init() {
    applicationStart.displayFoodStorage();
    applicationStart.displayRecipeBook();
  }


  /**
   * The entry point of the application.
   * 
   * <p>This method initializes the application and starts the FoodWasteApp.
   *
   * @param arg Command line arguments (not used).
   */
  public static void main(String[] arg) {
    // creating intance of FoodWasteApp
    // ? working ingredient code.
    init();    
    applicationStart.appStart();



  }

}

