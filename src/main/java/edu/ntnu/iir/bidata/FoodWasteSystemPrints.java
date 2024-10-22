package edu.ntnu.iir.bidata;

/**
 * The FoodWasteSystemPrints class provides methods to print various messages and menus to the
 * console for a food storage management application. It includes methods for displaying welcome
 * messages, selection menus, food storage contents, and prompts for user input. Additionally, it
 * provides alert messages for invalid input.
 *
 * <p>Methods included in this class:
 *
 * <ul>
 *   <li>{@link #userReciveWelcomeToApplication()} - Prints a welcome message to the user.
 *   <li>{@link #userReciveSelectionMenu()} - Prints the selection menu for the user.
 *   <li>{@link #userReciveExitAddIngredientLoop()} - Prints a message prompting the user to exit
 *       the ingredient addition loop.
 *   <li>{@link #userDisplayFoodStorage()} - Prints the current contents of the food storage.
 *   <li>{@link #userDisplayRecipeBook()} - Placeholder method for displaying the recipe book.
 *   <li>{@link #askUserAboutIngredientName()} - Prompts the user to enter the name of an
 *       ingredient.
 *   <li>{@link #askUserAboutMeasurementType()} - Prompts the user to select a measurement type for
 *       an ingredient.
 *   <li>{@link #askUserAboutAmout()} - Prompts the user to enter the amount of an ingredient.
 *   <li>{@link #alertNameInvalid()} - Alerts the user that the entered name is invalid.
 *   <li>{@link #alertMeasurmentTypeInvalid()} - Alerts the user that the entered measurement type
 *       is invalid.
 *   <li>{@link #alertAmountInvalid()} - Alerts the user that the entered amount is invalid.
 * </ul>
 *
 * <p>Note: The {@link #userDisplayRecipeBook()} method is currently a placeholder and does not have
 * an implementation.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * FoodWasteSystemPrints prints = new FoodWasteSystemPrints();
 * prints.userReciveWelcomeToApplication();
 * prints.userReciveSelectionMenu();
 * }</pre>
 *
 * @see System#println(String)
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class FoodWasteSystemPrints {

  // ! No need for constractor

  /** System response for the program */
  public void userReciveWelcomeToApplication() {
    System.out.println("\nWelcome To FoodWaste Application");
    System.out.println("Here you will get a selection menu to make it easy for you :)");
  }

  public void userReciveSelectionMenu() {
    System.out.println("\nSelection Menu:");
    System.out.println("1. Add Ingredients to foodstorage");
    System.out.println("2. Search for Ingredient in foodStorage");
    System.out.println("3. Display ingredients in the foodstorage");
    System.out.println("4. Use ingredient from Storage");
    System.out.println("5. Create Recipe");
    System.out.println("6. View Recipes");
    System.out.println("7. Check recipes that could be done foodstorage ingredients ");
    System.out.println("8. Advice me of ingredient to make.");
    System.out.println("99. Generate ingredients or recipes");
    System.out.println("*: Type anything to exit.");
  }

  public void userReciveExitAddIngredientLoop() {
    System.out.println(
        "Press (N) or (n) if you are finished from adding and want to see your foodStorage.\n"
            + "Or if you want to add more ingredients write anything.");
  }

  public void userDisplayFoodStorage() {
    System.out.println("\n");
    System.out.println("--------------------------------------------------------------------");
    System.out.printf("| %-23s  %-13s  %-24s |%n", " ", "Ingredients", " ");
    System.out.println("--------------------------------------------------------------------");
    System.out.printf("| %-13s | %-13s | %-13s | %-16s |%n", "Name", "Amount", "Price", "Expires");
    System.out.println("--------------------------------------------------------------------");
  }

  public void userDisplayRecipeBook() {
    System.out.println("--------------------------------------------------------------------");
    System.out.printf("| %-23s  %-13s  %-24s |%n", " ", "RecipeBook", " ");
    System.out.println("--------------------------------------------------------------------");
  }

  /** Question to the user */
  public void askUserAboutIngredientName() {
    System.out.println("\nIngredients Name?");
  }

  public void askUserAbouIngredientAmout() {
    System.out.println("\nIngredients Amount? ");
  }

  public void askUserAboutIngredientPrice() {
    System.out.println("\nIngredients Price?");
  }

  public void askUserAboutIngredientMeasurementType() {
    System.out.println("\nWhat does it measure? (the number to the left) ");
    System.out.println("0. Unit/Units ");
    System.out.println("1. Gram ");
    System.out.println("2. Liter ");
  }

  /** Return messages to the user if there is any invalid info. */
  public void alertNameInvalid() {
    System.out.println("\nName cant be empty or blank");
    System.out.println("Rewrite a name for the Ingreadient: ");
  }

  public void alertMeasurmentTypeInvalid() {
    System.out.println("\nThere is only 3 measurment types:");
    System.out.println("0. Unit/Units ");
    System.out.println("1. Gram ");
    System.out.println("2. Liter ");
    System.out.println("Choose one of the shown measurments: ");
  }

  public void alertAmountInvalid() {
    System.out.println("\nAmount Cant be Negative, 0, or higher that the stored amount");
    System.out.println("Check the Amount again: ");
  }

  public void alertPriceInvalid() {
    System.out.println("\nPrice Cant be Negative or 0");
    System.out.println("Check the price again:");
  }
}
