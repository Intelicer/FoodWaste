package edu.ntnu.iir.bidata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * The FoodWasteApp class is the main entry point for the Food Waste Management application. It
 * provides methods to start the application, create ingredients, display ingredients, create
 * recipes, and display recipes. The application interacts with the user through console input and
 * output.
 *
 * <p>Classes used by FoodWasteApp:
 *
 * <ul>
 *   <li>FoodStorage: Manages the storage of ingredients.
 *   <li>RecipeBook: Manages the collection of recipes.
 *   <li>FoodWasteSystemPrints: Handles printing messages and prompts to the user.
 * </ul>
 *
 * <p>Fields:
 *
 * <ul>
 *   <li>foodStorage: An instance of FoodStorage for managing ingredients.
 *   <li>recipeBook: An instance of RecipeBook for managing recipes.
 *   <li>foodWasteSystemPrints: An instance of FoodWasteSystemPrints for printing messages.
 *   <li>userInput: A Scanner object for reading user input from the console.
 * </ul>
 *
 * <p>Methods:
 *
 * <ul>
 *   <li>FoodWasteApp(): Constructor that initializes the FoodWasteApp object.
 *   <li>foodWasteAppStart(): Starts the application, displays a welcome message, and runs the main
 *       loop.
 *   <li>createIngredient(): Facilitates the creation of an ingredient by interacting with the user.
 *   <li>displayIngredients(): Displays all ingredients currently stored in the food storage.
 *   <li>createRecipe(): Prompts the user to create a new recipe by entering details and
 *       ingredients.
 *   <li>displayAllRecipes(): Displays all recipes stored in the recipe book.
 * </ul>
 *
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class FoodWasteApp {
  private Scanner userInput = new Scanner(System.in);
  // ! Used Classes
  private FoodStorage foodStorage = new FoodStorage();
  private RecipeBook recipeBook = new RecipeBook();
  private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  // ! No need for constractor

  /**
   * Starts the FoodWasteApp. Displays a welcome message and a selection menu. Runs the main loop of
   * the application.
   */
  public void foodWasteAppStart() {

    // ? Declearing Loop and Insilizing it
    boolean mainRunForever = true;
    int choosenSelection;
    // ? Use of main class
    FoodWasteApp foodWasteStart = new FoodWasteApp();
    foodWasteSystemPrints.userReciveWelcomeToApplication(); // Welcome Message to Application
    while (mainRunForever == true) {

      foodWasteSystemPrints.userReciveSelectionMenu(); // Selection Menu
      choosenSelection = userInput.nextInt();
      switch (choosenSelection) {
        case 1:
          foodWasteStart.createIngredient();
          break;
        case 2:
          foodWasteStart.checkIngredientExistensInStorage();
          break;
        case 3:
          foodWasteStart.displayIngredients();
          break;
        case 4:
          foodWasteStart.useIngredientExitstenInStorage();
          break;
        case 5:
          foodWasteStart.createRecipe();
          break;
        case 6:
          foodWasteStart.displayAllRecipes();
          break;
        case 7:
          foodWasteStart.checkOfARecipeIngredientsInFoodStorage();
          break;
        case 8:
          foodWasteStart.getsizeoffoodstorage();
          break;
        case 99:
          foodWasteStart.generateRecipesAndIngredients();
          break;
        default:
          break;
      }
    }
    userInput.close();
  }

  /**
   * This method facilitates the creation of an ingredient by interacting with the user. It
   * repeatedly prompts the user for ingredient details until the user decides to stop.
   *
   * <p>The method performs the following steps:
   *
   * <ul>
   *   <li>Prompts the user for the ingredient name and validates it.
   *   <li>Prompts the user for the ingredient measurement type and validates it.
   *   <li>Prompts the user for the ingredient amount and validates it.
   *   <li>Creates an Ingredient object with the provided details and adds it to the food storage.
   *   <li>Asks the user if they want to add more ingredients or exit the loop.
   * </ul>
   *
   * <p>Validation checks ensure that:
   *
   * <ul>
   *   <li>The ingredient name is not empty or blank.
   *   <li>The ingredient measurement type is within the valid range (0-2).
   *   <li>The ingredient amount is greater than 0.
   * </ul>
   *
   * <p>If the user decides to stop adding ingredients, the method exits the loop and terminates.
   */

  /**
   * This method facilitates the creation of an ingredient by prompting the user for various
   * details. It continuously asks the user for input until valid data is provided for each field.
   * The user can add multiple ingredients in one session and choose to exit the loop when done.
   *
   * <p>The method collects the following details for each ingredient: - Name: A non-empty string
   * representing the ingredient's name. - Measurement Type: An integer representing the type of
   * measurement (valid values are 0, 1, or 2). - Amount: A positive double representing the
   * quantity of the ingredient. - Price: A positive double representing the price of the
   * ingredient. - Expire Date: A string representing the expiration date in the format
   * "yyyy-MM-dd".
   *
   * <p>The method performs validation checks for each input and provides feedback if the input is
   * invalid. Once all inputs are valid, an Ingredient object is created and added to the food
   * storage.
   *
   * <p>The user can exit the loop by entering 'N' or 'n' when prompted, which will stop the
   * ingredient addition process.
   *
   * <p>Variables: - userIngredientName: Stores the name of the ingredient. - userIngredientAmount:
   * Stores the amount of the ingredient. - userIngredientMeasurement: Stores the measurement type
   * of the ingredient. - userIngredientPrice: Stores the price of the ingredient. -
   * userIngredientExpireDate: Stores the expiration date of the ingredient. - addIngredientForever:
   * Controls the loop for adding ingredients. - nameIsNotCorrect: Validates the ingredient name. -
   * messurementDontExist: Validates the measurement type. - amountInvalid: Validates the ingredient
   * amount. - ingredientPriceInvalid: Validates the ingredient price. - ingredientExpireDate:
   * Validates the expiration date.
   */
  public void createIngredient() {

    // ? Declearing Loop and Insilizing it
    String userIngredientName;
    double userIngredientAmount;
    int userIngredientMeasurement;
    double userIngredientPrice;
    String userIngredientExpireDate;

    // Declearing Main Loop
    boolean addIngredientForever = true; // add ingredients loop
    // ? A Loop to keep the program running until the user want to exit from it.
    while (addIngredientForever == true) {
      // ? Declearing Loop and Insilizing it
      boolean nameIsNotCorrect = true; // name is not correct
      // ? User input has to be a valid Ingredient name
      foodWasteSystemPrints.askUserAboutIngredientName();
      userIngredientName = userInput.nextLine();
      // ! Name Check Loop
      while (nameIsNotCorrect == true) {
        if ((userIngredientName.isBlank())) {
          foodWasteSystemPrints.alertNameInvalid();
          userIngredientName = userInput.nextLine();
        } else {
          nameIsNotCorrect = false;
        }
      }
      nameIsNotCorrect = true;

      // ?Declearing Loop and Insilizing it
      boolean messurementDontExist = true; // messurement is a wrong value
      // ? User input has to be a valid Ingredient Measurement Type
      foodWasteSystemPrints.askUserAboutIngredientMeasurementType();
      userIngredientMeasurement = userInput.nextInt();
      // ! Measurement Check Loop
      while (messurementDontExist == true) {
        if (userIngredientMeasurement < 0
            || 2 < userIngredientMeasurement) { // ! Types from 0-2 cause of array
          foodWasteSystemPrints.alertMeasurmentTypeInvalid();
          userIngredientMeasurement = userInput.nextInt();
        } else {
          messurementDontExist = false;
        }
      }
      messurementDontExist = true;

      // ?Declearing Loop and Insilizing it
      boolean amountInvalid = true;
      // ? User input has to be a valid Ingredient Amount
      foodWasteSystemPrints.askUserAbouIngredientAmout();
      userIngredientAmount = userInput.nextDouble();
      // ! Amount Check Loop
      while (amountInvalid == true) {
        if (userIngredientAmount <= 0) {
          foodWasteSystemPrints.alertAmountInvalid();
          userIngredientAmount = userInput.nextInt();
        } else {
          amountInvalid = false;
        }
      }
      amountInvalid = true;

      // ?Declearing Loop and Insilizing it
      boolean ingredientPriceInvalid = true;
      // ? User input has to be a valid Ingredient Amount
      foodWasteSystemPrints.askUserAboutIngredientPrice();
      userIngredientPrice = userInput.nextDouble();
      // ! Price Check Loop
      while (ingredientPriceInvalid == true) {
        if (userIngredientPrice <= 0) {
          foodWasteSystemPrints.alertPriceInvalid();
          userIngredientPrice = userInput.nextDouble();
        } else {
          ingredientPriceInvalid = false;
        }
      }
      ingredientPriceInvalid = true;

      // ?Declearing Loop and Insilizing it
      boolean ingredientExpireDate = true;
      userInput.nextLine(); // & without any skip lines
      System.out.println("Enter the ingredient expiration date (yyyy-MM-dd):");
      userIngredientExpireDate = userInput.nextLine();
      // ? User input has to be a valid date for ingreadient expireDate
      // ! Amount Check Loop
      while (ingredientExpireDate == true) {
        try {
          dateFormat.parse(userIngredientExpireDate); // Attempt to parse the date
          ingredientExpireDate = false; // If parsing is successful, exit the loop
        } catch (ParseException e) {
          System.out.println("Wrong format (yyyy-MM-dd)");
        }
      }

      Ingredient Ingredient =
          new Ingredient(
              userIngredientName,
              userIngredientAmount,
              userIngredientMeasurement,
              userIngredientPrice,
              userIngredientExpireDate);
      foodStorage.addIngredient(Ingredient);

      // ? Quit addIngredient Method.
      System.out.println(
          "Press (N) or (n) if you are finished from adding and want to see your foodStorage.\n"
              + "Or if you want to add more ingredients write anything.");
      char loopExit = userInput.next().charAt(0);
      userInput
          .nextLine(); // & runs the code so that we can add more ingredients without any skip lines
      if (loopExit == 'N' || loopExit == 'n') {
        addIngredientForever = false; // change value to get out of loop
      }
    }
    addIngredientForever = true; // restore value so the user can use add ingredients again.
    userInput.close();
  }

  /**
   * Displays all ingredients stored in the food storage. This method calls the
   * displayAllIngredients() method of the foodStorage object to print out the list of all
   * ingredients currently available.
   */
  public void displayIngredients() {
    foodStorage.displayAllIngredients();
  }

  /**
   * Checks if an ingredient exists in the storage and prints its details.
   *
   * <p>This method verifies if the specified ingredient exists in the storage. If the ingredient
   * exists, it prints the ingredient's details including name, price, amount, measurement type, and
   * expiration date. If the ingredient does not exist, it prints a message indicating that the
   * ingredient is not found.
   *
   * @param nameOfIngredientTofind the name of the ingredient to find
   */
  public void checkIngredientExistensInStorage() {
    boolean nameOfIngredientTofindinvalid = true;
    if (foodStorage.getFoodStorageSize() == 0) {
      System.out.println("\nThe storage are empty");
    } else {
      System.out.println("\nWhat are the ingredient u are searching for?");
      String nameOfIngredientTofind = userInput.nextLine();
      while (nameOfIngredientTofindinvalid == true) {
        if ((nameOfIngredientTofind.isBlank())) {
          foodWasteSystemPrints.alertNameInvalid();
          nameOfIngredientTofind = userInput.nextLine();
        } else {
          nameOfIngredientTofindinvalid = false;
        }
      }
      foodStorage.checkIngredientExistensInStorage(nameOfIngredientTofind);
    }
  }

  /**
   * Uses a specified amount of an ingredient if it exists in the storage.
   *
   * <p>This method checks if the storage is empty and prompts the user for the name of the
   * ingredient and the amount to use. It validates the input and uses the ingredient if it exists
   * and the amount is valid.
   *
   * @throws IllegalArgumentException if the amount to use is less than or equal to 0
   * @throws IllegalArgumentException if the amount to use is greater than the amount in storage
   */
  public void useIngredientExitstenInStorage() {
    boolean nameOfIngredientTofindInvalid = true;
    boolean AmoutOfIngredientToUseInvalid = true;
    if (foodStorage.getFoodStorageSize() == 0) {
      System.out.println("\nThe storage are empty");
    } else {
      System.out.println("\nWhat are the ingredient u are searching for?");
      String nameOfIngredientTofind = userInput.nextLine();
      while (nameOfIngredientTofindInvalid == true) {
        if ((nameOfIngredientTofind.isBlank())) {
          foodWasteSystemPrints.alertNameInvalid();
          nameOfIngredientTofind = userInput.nextLine();
        } else {
          nameOfIngredientTofindInvalid = false;
        }
      }

      foodStorage.checkIngredientExistensInStorage(nameOfIngredientTofind);

      System.out.println("\nWhat is the amount you want to use?");
      double AmoutOfIngredientToUse = userInput.nextDouble();
      while (AmoutOfIngredientToUseInvalid == true) {
        if (AmoutOfIngredientToUse <= 0
            || AmoutOfIngredientToUse
                > foodStorage.checkIngredientAmountInStorage(nameOfIngredientTofind)) {
          foodWasteSystemPrints.alertAmountInvalid();
          AmoutOfIngredientToUse = userInput.nextDouble();
        } else {
          AmoutOfIngredientToUseInvalid = false;
        }
      }
      foodStorage.useIngredientExitstenInStorage(nameOfIngredientTofind, AmoutOfIngredientToUse);
    }
  }

  /**
   * Prompts the user to create a new recipe by entering the recipe name, description, and a list of
   * ingredients with their respective amounts. The method continues to prompt for ingredients until
   * the user indicates they are finished. The created recipe is then added to the recipe book.
   *
   * <p>Steps involved in creating a recipe:
   *
   * <ol>
   *   <li>Prompt the user for the recipe name.
   *   <li>Prompt the user for the recipe description.
   *   <li>Enter a loop to add ingredients and their amounts until the user decides to stop.
   *   <li>Create a Recipe object with the provided details.
   *   <li>Add the created Recipe object to the recipe book.
   * </ol>
   *
   * <p>Note: The method assumes that the user input is handled correctly and does not include
   * validation for the input values.
   */
  public void createRecipe() {
    System.out.println("\nName of Recipe:");
    String userRecipeName = userInput.nextLine();
    while (userRecipeName.isBlank()) {
      System.out.println("\nName of Recipe:");
      userRecipeName = userInput.nextLine();
    }

    System.out.println("Description of recipe:");
    String recipeDescription = userInput.nextLine();
    while (recipeDescription.isBlank()) {
      System.out.println("Description of recipe:");
      recipeDescription = userInput.nextLine();
    }

    System.out.println("Instructions of recipe:");
    String recipeInstructions = userInput.nextLine();
    while (recipeInstructions.isBlank()) {
      System.out.println("Instructions of recipe:");
      recipeInstructions = userInput.nextLine();
    }

    ArrayList<String> userIngredientsToMakeTheRecipe = new ArrayList<>();
    ArrayList<Double> userUsedAmountToMakeTheRecipe = new ArrayList<>();

    Boolean addIngredientToRecipe = true;
    while (addIngredientToRecipe == true) {

      System.out.println("\nName of Ingredient used in recipe:");
      String userIngredientNamesForRecipe = userInput.nextLine();
      while (userIngredientNamesForRecipe.isBlank()) {
        System.out.println("\nThe name inputed is either blank or empty");
        System.out.println("Name of Ingredient used in recipe:");
        userIngredientNamesForRecipe = userInput.nextLine();
      }
      userIngredientsToMakeTheRecipe.add(userIngredientNamesForRecipe);

      System.out.println("\nAmount of that ingreadient");
      double userIngredientAmoutForRecipe = userInput.nextDouble();
      while (userIngredientAmoutForRecipe <= 0) {
        System.out.println("The amount cant be negative or 0");
        userIngredientAmoutForRecipe = userInput.nextDouble();
      }

      userUsedAmountToMakeTheRecipe.add(userIngredientAmoutForRecipe);

      System.out.println("Press (N) or (n) if you are finished.");
      char loopExit = userInput.next().charAt(0);
      userInput
          .nextLine(); // & runs the code so that we can add more ingredients without any skip lines
      if (loopExit == 'N' || loopExit == 'n') {
        addIngredientToRecipe = false;
      }
      userInput.close();
    }
    addIngredientToRecipe = true;
    Recipe userRecipe =
        new Recipe(
            userRecipeName,
            recipeDescription,
            recipeInstructions,
            userIngredientsToMakeTheRecipe,
            userUsedAmountToMakeTheRecipe);
    recipeBook.addRecipe(userRecipe);
    userInput.close();
  }

  /**
   * Generates random recipes and ingredients and adds them to the food storage.
   *
   * <p>This method creates random ingredients with random amounts, prices, and expiration dates. It
   * uses three predefined arrays of ingredient names categorized by measurement types (pieces,
   * grams, liters). Each ingredient is assigned a random amount (up to 2000), a random price (up to
   * 50), and a random expiration date. The generated ingredients are then added to the food
   * storage.
   *
   * <p>The random values are generated using the {@link java.util.Random} class.
   *
   * <p>The expiration date is formatted as "YYYY-MM-DD" where the year is fixed to 2024, and the
   * month and day are randomly generated.
   *
   * <p>Example of generated ingredients: - Ingredient 1: Egg, 1500 pieces, price 20.0, expires on
   * 2024-05-15 - Ingredient 2: Flour, 1000 grams, price 10.0, expires on 2024-03-22 - Ingredient 3:
   * Milk, 500 liters, price 5.0, expires on 2024-11-09
   *
   * <p>Note: The method assumes that the food storage object and the Ingredient class are properly
   * defined elsewhere in the codebase.
   */
  public void generateRecipesAndIngredients() {
    boolean generate = true;

    if (generate == true) {

      Random rand = new Random();

      String[] ingredientNamePieces = {"Egg", "Tomato", "Potato", "Avocado", "Lemon"};
      String[] ingredientNameGram = {"Flour", "Sugar", "salt", "Seasme Seeds", "Butter"};
      String[] ingredientNameLiter = {
        "Milk", "Water", "Desert cream", "Food cream", "Chocolate souce"
      };
      // MeasurmentType

      int i;
      for (i = 0; i < 5; i++) {

        int randomIngredientAmount = rand.nextInt(2000);
        Double.valueOf(randomIngredientAmount);
        int randomIngredientPrice = rand.nextInt(50);
        Double.valueOf(randomIngredientPrice);
        int randomDay = rand.nextInt(28);
        int randomMonth = rand.nextInt(12);
        String dateOfExpire;
        String randomDayNeedZero;
        String randomMonthNeedZero;

        if (randomDay == 0) {
          randomDay = 1;
        }

        if (randomMonth == 0) {
          randomMonth = 1;
        }

        if (randomDay <= 9) {
          randomDayNeedZero = "0" + Integer.toString(randomDay);
        } else {
          randomDayNeedZero = Integer.toString(randomDay);
        }

        if (randomMonth <= 9) {
          randomMonthNeedZero = "0" + Integer.toString(randomMonth);
        } else {
          randomMonthNeedZero = Integer.toString(randomMonth);
        }

        dateOfExpire = "2024-" + randomMonthNeedZero + "-" + randomDayNeedZero;

        Ingredient newIngredient1 =
            new Ingredient(
                ingredientNamePieces[i],
                randomIngredientAmount,
                0,
                randomIngredientPrice,
                dateOfExpire);
        Ingredient newIngredient2 =
            new Ingredient(
                ingredientNameGram[i],
                randomIngredientAmount,
                1,
                randomIngredientPrice,
                dateOfExpire);
        Ingredient newIngredient3 =
            new Ingredient(
                ingredientNameLiter[i],
                randomIngredientAmount,
                2,
                randomIngredientPrice,
                dateOfExpire);
        foodStorage.addIngredient(newIngredient1);
        foodStorage.addIngredient(newIngredient2);
        foodStorage.addIngredient(newIngredient3);

        // ? Recipe
        String userRecipeName = "Kofta";
        String recipeDescription = "Palestinian";
        String recipeInstraction = "uuuuuuu";
        ArrayList<String> userIngredientsToMakeTheRecipe = new ArrayList<>();
        ArrayList<Double> userUsedAmountToMakeTheRecipe = new ArrayList<>();

        userIngredientsToMakeTheRecipe.add("Tomato");
        userIngredientsToMakeTheRecipe.add("Onion");
        userIngredientsToMakeTheRecipe.add("Potato");
        userIngredientsToMakeTheRecipe.add("Tahini");

        userUsedAmountToMakeTheRecipe.add(20.0);
        userUsedAmountToMakeTheRecipe.add(10.0);
        userUsedAmountToMakeTheRecipe.add(5.0);
        userUsedAmountToMakeTheRecipe.add(9.0);

        Recipe userRecipe =
            new Recipe(
                userRecipeName,
                recipeDescription,
                recipeInstraction,
                userIngredientsToMakeTheRecipe,
                userUsedAmountToMakeTheRecipe);
        recipeBook.addRecipe(userRecipe);

        // ? Recipe
        String userRecipeName2 = "Kofta2";
        ArrayList<String> userIngredientsToMakeTheRecipe2 = new ArrayList<>();
        ArrayList<Double> userUsedAmountToMakeTheRecipe2 = new ArrayList<>();

        userIngredientsToMakeTheRecipe2.add("Tomato");
        userIngredientsToMakeTheRecipe2.add("Onion");
        userIngredientsToMakeTheRecipe2.add("Potato");
        userIngredientsToMakeTheRecipe2.add("Tahini");
        userIngredientsToMakeTheRecipe2.add("humus");

        userUsedAmountToMakeTheRecipe2.add(20.0);
        userUsedAmountToMakeTheRecipe2.add(10.0);
        userUsedAmountToMakeTheRecipe2.add(5.0);
        userUsedAmountToMakeTheRecipe2.add(9.0);
        userUsedAmountToMakeTheRecipe2.add(9.0);

        Recipe userRecipe2 =
            new Recipe(
                userRecipeName2,
                recipeDescription,
                recipeInstraction,
                userIngredientsToMakeTheRecipe2,
                userUsedAmountToMakeTheRecipe2);
        recipeBook.addRecipe(userRecipe2);
        generate = false;
      }
    } else {
      System.out.println("You can only generate one time.");
    }

    // ! Rethink about it
    // for (String ingredient : ingredientName) {
    //     Ingredient newIngredient = new Ingredient(ingredient, randomIngredientAmount, 1,
    // randomIngredientPrice, dateOfExpire);
    //     foodStorage.addIngredient(newIngredient);
    // }

    // Ingredient flour = new Ingredient("Flour", 2000.0, 1, 6.59, "01-01-2024");
    // Ingredient sugar = new Ingredient("Sugar", 1000.0, 1, 1.20, "01-01-2024");
    // Ingredient eggs = new Ingredient("Eggs", 12.0, 0, 3.0, "01-01-2024");
    // Ingredient milk = new Ingredient("Milk", 3.0, 2, 3.6, "01-01-2024");
    // Ingredient water = new Ingredient("Water", 50.0, 2, 0.0, "01-01-2024");
    // Ingredient salt = new Ingredient("salt", 2.0, 1, 2.5, "01-01-2024");
    // Ingredient cheese = new Ingredient("cheese", 2.5, 1, 10.5, "01-01-2024");
    // Ingredient tomatoPaste = new Ingredient("tomatoPaste", 2.0, 1, 5.35, "01-01-2024");

    // // Add ingredients to storage
    // foodStorage.addIngredient(flour);
    // foodStorage.addIngredient(sugar);
    // foodStorage.addIngredient(eggs);
    // foodStorage.addIngredient(milk);
    // foodStorage.addIngredient(water);
    // foodStorage.addIngredient(salt);
    // foodStorage.addIngredient(cheese);

  }

  /**
   * Displays all recipes stored in the recipe book. This method delegates the task to the
   * recipeBook's displayAllRecipes method.
   */
  public void displayAllRecipes() {
    recipeBook.displayAllRecipeInBook();
  }

  /**
   * This method checks if the ingredients of a specified recipe are available in the food storage.
   * It prompts the user to enter the name of the recipe and verifies its existence in the recipe
   * book. If the recipe exists, it retrieves the ingredients and asks the user if they want to
   * check if the recipe can be made with the available ingredients. If the user agrees, it checks
   * the food storage for the availability of each ingredient. Finally, it informs the user whether
   * the recipe can be made or not based on the availability of the ingredients.
   *
   * <p>Steps performed by this method:
   *
   * <ol>
   *   <li>Prompts the user to enter the name of the recipe to search for.
   *   <li>Validates that the recipe name is not blank or empty.
   *   <li>Formats the recipe name to have the first letter capitalized and the rest in lowercase.
   *   <li>Checks if the recipe exists in the recipe book.
   *   <li>If the recipe exists, retrieves the ingredients of the recipe.
   *   <li>Asks the user if they want to check if the recipe can be made with the available
   *       ingredients.
   *   <li>If the user agrees, checks the food storage for the availability of each ingredient.
   *   <li>Informs the user whether the recipe can be made or not based on the availability of the
   *       ingredients.
   * </ol>
   */
  public void checkOfARecipeIngredientsInFoodStorage() {
    HashMap<String, Double> returnedIngredientsOfRecipe;
    System.out.println(foodStorage.getFoodStorageSize());
    if (foodStorage.getFoodStorageSize() > 0) {
      System.out.println(
          "\nWhat are the recipe you want to search for if Ingreadients available in storage? ");
      String nameOfRecipeToSearchAfter = userInput.nextLine();
      while (nameOfRecipeToSearchAfter.isBlank()) {
        System.out.println("the name of the recipe your want to search for cant be blank or empty");
        nameOfRecipeToSearchAfter = userInput.nextLine();
      }
      nameOfRecipeToSearchAfter =
          nameOfRecipeToSearchAfter.substring(0, 1).toUpperCase()
              + nameOfRecipeToSearchAfter
                  .substring(1, nameOfRecipeToSearchAfter.length())
                  .toLowerCase();

      if (recipeBook.getExistenceOfAnKey(nameOfRecipeToSearchAfter) == true) {

        returnedIngredientsOfRecipe = new HashMap<>();
        recipeBook.getASpecificRecipe(nameOfRecipeToSearchAfter, returnedIngredientsOfRecipe);

        System.out.println(
            "\n"
                + "Do you want to check if your can make the ingredient? (true to continue, false"
                + " for exiting)");
        boolean canMakeRecipeWithIngredients = userInput.nextBoolean();
        while (canMakeRecipeWithIngredients != true && canMakeRecipeWithIngredients != false) {
          System.out.println("\nThe value you entered is not a boolean value");
          System.out.println(
              "Do you want to check if your can make the ingredient? (true to continue, false for"
                  + " exiting)");
          canMakeRecipeWithIngredients = userInput.nextBoolean();
        }
        if (canMakeRecipeWithIngredients == true) {

          int trueCounterForIngredient = 0;
          for (String IngredientKey : recipeBook.getCheckedMap().keySet()) {
            if (foodStorage.checkIfIngredientInStorage(IngredientKey) == true) {
              trueCounterForIngredient++;
            }
          }

          if (trueCounterForIngredient == recipeBook.getCheckedMap().keySet().size()) {
            System.out.println("\nYou can make the recipe.");

          } else {
            System.out.println("\nRecipe cant be made.");
          }
        }

      } else {
        System.out.println("\nThe recipe your searching for doesnt exist");
      }
    } else {
      System.out.println("\nfood storage is empty");
    }
  }

  public int getsizeoffoodstorage() {
    return foodStorage.getFoodStorageSize();
  }
}
