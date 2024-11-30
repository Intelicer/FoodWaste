package edu.ntnu.iir.bidata.ui;

//IMPORT ENTITY AND LOGIC PACKAGES
import edu.ntnu.iir.bidata.entity.Ingredient;
import edu.ntnu.iir.bidata.entity.Recipe;
import edu.ntnu.iir.bidata.logic.FoodStorage;
import edu.ntnu.iir.bidata.logic.RecipeBook;
import edu.ntnu.iir.bidata.untility.ValidationUtil;

import java.util.ArrayList;
//JAVA LIBARIES
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * The FoodWasteUserInterface class provides a user interface for the FoodWasteApp.
 * It allows the user to interact with the application by adding ingredients to the food storage,
 * creating recipes, and generating random recipes and ingredients.
 */
public class FoodWasteUserInterface {
  // ! Used Classes
  private FoodStorage foodStorage = new FoodStorage();
  private RecipeBook recipeBook = new RecipeBook();
  // ? use static final to constant for appStart()
  private static final int ADD_INGREDIENT_TO_FOOD_STORAGE = 1;
  private static final int SEARCH_FOR_INGREDIENT_IN_FOODSTORAGE = 2;
  private static final int DISPLAY_FOODSTORAGE = 3;
  private static final int ADD_RECIPE_TO_RECIPE_BOOK = 4;
  private static final int DISPLAY_RECIPE_BOOK = 5;
  private static final int SEARCH_FOR_RECIPE = 6;
  private static final int ADVICE_READY_TO_COOK_RECIPES = 7;
  private static final int GENERATE_RECIPE_AND_INGREDIENTS = 99;
  private static final int QUIT_APP = 0;

  // ? use static final to constant for ingredientMenu()
  private static final int USE_INGREDIENT_AMOUNT = 1;
  private static final int ADD_INGREDIENT_AMOUNT = 2;
  private static final int REMOVE_INGREDIENT = 3;
  private static final int QUIT_INGREDIENT_AMOUNT_MENU = 0;
  
  // ? Constant for openFoodStorage()
  private static final int REMOVE_EXPIRED_INGREDIENTS = 1;
  private static final int CHECK_VALUE_FOODSTORAGE_INGREDIENTS = 2;
  private static final int REDISPLAY_FOODSTORAGE = 3;

  
  private int appStartSkip = 0;



  /**
   * Starts the FoodWasteApp. Displays a welcome message and a selection menu.
   * Runs the main loop of
   * the application.
   */
  public void appStart() {
    Scanner userInput = new Scanner(System.in);
    // ? Declearing Loop and Insilizing it
    boolean mainRunForever = true;

    // ? Use of main class
    System.out.println("\nWelcome To FoodWaste Application"); // Welcome Message to Application
    System.out.println("Here you will get a selection menu to make it easy for you :)");
    while (mainRunForever == true) {
      applicationMenu();
      int choosenSelection = ValidationUtil.isVaildIntInput(userInput, "Menu Selection");
      switch (choosenSelection) {
        case ADD_INGREDIENT_TO_FOOD_STORAGE -> addIngredientToFoodStorage(userInput);
        case SEARCH_FOR_INGREDIENT_IN_FOODSTORAGE -> findIngredientInStorage(userInput);
        case DISPLAY_FOODSTORAGE -> displayFoodStorage();
        case ADD_RECIPE_TO_RECIPE_BOOK -> writeRecipeInBook(userInput);
        case DISPLAY_RECIPE_BOOK -> displayRecipeBook();
        case SEARCH_FOR_RECIPE -> searchForRecipe(userInput);
        case ADVICE_READY_TO_COOK_RECIPES -> adviceMeARecipeMake();
        case GENERATE_RECIPE_AND_INGREDIENTS -> generateRecipesAndIngredients();
        case QUIT_APP -> {
          userInput.close();
          mainRunForever = false;
        }
        default -> System.out.println("Invalid selection. Please try again.");
      }
    }
  }



  /**
   * Adds an ingredient to the food storage by prompting the user for input.
   * The user is asked to provide the name, measurement type, 
   *    amount, price, and expiration date of the ingredient.
   * The ingredient is then created and added to the food storage.
   * The user can continue adding ingredients until they choose to stop.
   *
   * @param userInput the Scanner object used to read user input
   */
  public void addIngredientToFoodStorage(Scanner userInput) {

    boolean addIngredientForever = true; // add ingredients loop
    while (addIngredientForever == true) {

      System.out.println("\nWhat do you have to add in your Storage? (Write A Name)");
      String ingredientName = ValidationUtil.isVaildStringInput(userInput, "ingredient name");

      System.out.println("\nWhat does it measure? (the number to the left) ");
      System.out.println("0. Unit/Units ");
      System.out.println("1. Gram ");
      System.out.println("2. Liter ");
      int ingredientMeasurement = ValidationUtil.isVaildMesurmentInput(userInput);
      
      System.out.println("\nWhat is the amount you have of "
                        + ingredientName + "?");
      double ingredientAmount = ValidationUtil.isVaildDoubleInput(userInput, "ingredient amount");

      System.out.println("\nWhat is the price of it "
                        + ingredientName 
                        + "? (If you selected an mesurment as unit the price is per unit)");
      double ingredientPrice = ValidationUtil.isVaildDoubleInput(userInput, "ingredient price");

      System.out.println("Enter the ingredient expiration date (yyyy-MM-dd):");
      String ingredientExpireDate = ValidationUtil.isValidDateInput(userInput, 
                "ingredient expire date");

      Ingredient ingredient = new Ingredient(
          ingredientName,
          ingredientAmount,
          ingredientMeasurement,
          ingredientPrice,
          ingredientExpireDate);

      foodStorage.addIngredient(ingredient);

      System.out.println(
          "\nPress (N) or (n) if you are finished from adding"
              +
              "and want to see your foodStorage."
              + "\nOr if you want to add more ingredients write anything.");
      char loopExit = ValidationUtil.isValidCharInput(userInput, "Exiting");
      if (loopExit == 'n' || loopExit == 'N') {
        addIngredientForever = false;
      }
    }
    addIngredientForever = true;
  }



  /**
   * Displays all ingredients stored in the food storage. This method calls the
   * displayAllIngredients() method of the foodStorage object to print out
   * the
   * list of all
   * ingredients currently available.
  */
  public void displayFoodStorage() {


    System.out.println(
        "\n---------------------------"
            +
            "---------------------------------------------------");
    System.out.printf("| %-31s  %-13s  %-26s |%n", " ", "FoodStorage", " ");
    System.out.println(
        "---------------------------"
            +
            "---------------------------------------------------");
    System.out.printf("| %-20s | %-15s | %-15s | %-15s |%n",
        "Name",
        "Amount",
        "Price",
        "Expire Date");
    System.out.println(
        "---------------------------"
            +
            "---------------------------------------------------");
    String expired = "Expired";

    double sumOfIngredientPrices = 0.0;
    double sumOfExpiredIngredientPrices = 0.0;
    Iterator<Ingredient> iterator = foodStorage.getIterator();

    while (iterator.hasNext()) {
      Ingredient ingredient = iterator.next();
      System.out.printf(
          "| %-20s | %-15s | %-15s | %-15s |%n",
          ingredient.getIngredientName(),
          ingredient.getIngredientAmount()
              +
              " "
              +
              ingredient.getIngredientMeasurment(),
          ingredient.getIngredientPrice()
              +
              "$",
          ingredient.getIngredientExpireDate());

          
        System.out.println(
            "---------------------------"
            +
            "---------------------------------------------------");



      if (ingredient.getIngredientExpireDate().equals(expired)) {
        sumOfExpiredIngredientPrices += ingredient.getIngredientPrice();
      } else {
        sumOfIngredientPrices += ingredient.getIngredientPrice();
      }
      ingredient.getIngredientExpireDate();
    }


    if(foodStorage.getFoodStorageSize() > 0){

      if(appStartSkip == 1){
        Scanner userInput = new Scanner(System.in);
        boolean switchLoop = true;
        while (switchLoop == true) {
          foodStorageMenu();
          int useAddSelection = ValidationUtil.isVaildIntInput(userInput, "Storage menu");
          switch (useAddSelection) {
            case REMOVE_EXPIRED_INGREDIENTS -> removeExipredIngredients();
            case CHECK_VALUE_FOODSTORAGE_INGREDIENTS -> {
              System.out.println("\nPrice of expired Ingredients: " + sumOfExpiredIngredientPrices + "$");
              System.out.println("Price of valid Ingredients: " + sumOfIngredientPrices + "$");
              System.out.println(
                  "Total Price : " + (sumOfIngredientPrices
                  +
                  sumOfExpiredIngredientPrices) + "$");
                }
                case REDISPLAY_FOODSTORAGE -> {
                  appStartSkip++;
                  displayFoodStorage();
                }
                case QUIT_INGREDIENT_AMOUNT_MENU ->{
                  switchLoop = false;
                  appStartSkip = 1;
                } 
                default -> System.out.println("Invalid selection. Please try again.");
          }
        }
      }
    }else{
      appStartSkip = 1;
    }
  }



  /**
   * Prompts the user to input details for a new recipe and adds it to the recipe book.
   * The user is asked to provide the recipe 
   * name, description, instructions, and the number of people the recipe serves.
   * The user is then prompted to add ingredients to the recipe, including the 
   * ingredient name, amount, and measurement unit.
   * The process of adding ingredients continues until the user indicates they are finished.
   *
   * @param userInput a Scanner object to read user input from the console
   */
  public void writeRecipeInBook(Scanner userInput) {

    System.out.println("\nWhat is the name of recipe you want to add in the book?");
    final String userRecipeName = ValidationUtil.isVaildStringInput(userInput, "recipe name");

    System.out.println("Write a Description about "
              + userRecipeName 
              + ":");
    final String userRecipeDescription = ValidationUtil.isVaildStringInput(userInput, 
              "recipe description");

    System.out.println("Give instruction on how to make "
              + userRecipeName 
              + ":");
    final String userRecipeInstructions = ValidationUtil.isVaildStringInput(userInput,
              "recipe instruction");

    System.out.println("How many people its made to?");

    final int userAmountOfPeople = ValidationUtil.isVaildIntInput(userInput, "Amount of People");

    Boolean addIngredientToRecipe = true;
    HashMap<String, Ingredient> userRecipeIngredients = new HashMap<>();

    while (addIngredientToRecipe == true) {

      System.out.println("\n\nNow you will get some repeatable question about"
                        + "ingreadients and you can exit after putting the amount");
      System.out.println("\nWhat are the ingredient that in the recipe:");
      String userIngredientName = ValidationUtil.isVaildStringInput(userInput,  "ingredient name");


      System.out.println("\nAmount of that ingreadient");
      double userIngredientAmout = ValidationUtil.isVaildDoubleInput(userInput, 
              "ingredient amount");

      System.out.println("\nWhat does it measure? (the number to the left) ");
      System.out.println("0. Unit/Units ");
      System.out.println("1. Gram ");
      System.out.println("2. Liter ");
      int userIngredientMeasurement = ValidationUtil.isVaildMesurmentInput(userInput);

      Ingredient ingredient = new Ingredient(
            userIngredientName,
            userIngredientAmout,
            userIngredientMeasurement);

      userRecipeIngredients.put(userIngredientName, ingredient);

      System.out.println("Press (N) or (n) if you are finished.");
      String loopExit = userInput.nextLine().substring(0);
      if (loopExit.equals("N") || loopExit.equals("n")) {
        addIngredientToRecipe = false; // change value to get out of loop
      }
    }
    Recipe userRecipe = new Recipe(
        userRecipeName,
        userRecipeDescription,
        userRecipeInstructions,
        userAmountOfPeople,
        userRecipeIngredients);
    recipeBook.addRecipe(userRecipe);
  }



  /**
   * Generates random ingredients and recipes and adds them to the food storage and recipe book.
   * This method can only be called once.
   */
  public void generateRecipesAndIngredients() {
    boolean generate = true;

    if (generate == true) {

      //! Ingredient in pieces
      String[] ingredientInPieces = {
        "Tomato", "Onion", "Garlic","Carrot","Lemon"
      };

      for(int i = 0; i < 5 ; i++){
        Ingredient ingredient = new Ingredient(ingredientInPieces[i], 20.0, 0, 100, "2024-12-31");
        foodStorage.addIngredient(ingredient);
      };

      //! Ingredient in gram
      String[] ingredientInGram = {
        "Chicken", "Salt", "Lamb meat","ground meat","Flour"
      };
      for(int i = 0; i < 5 ; i++){
        Ingredient ingredient = new Ingredient(ingredientInGram[i], 20.0, 1, 3000, "2024-12-31");
        foodStorage.addIngredient(ingredient);
      };

      //! Ingredient in gram
      String[] ingredientInLiter = {
        "Water", "Milk", "food cream","juice","Flour"
      };
      for(int i = 0; i < 5 ; i++){
        Ingredient ingredient = new Ingredient(ingredientInLiter[i], 20.0, 2, 20, "2024-12-31");
        foodStorage.addIngredient(ingredient);
      };  





      // Create recipes based on the ingredients
      HashMap<String, Ingredient> recipe1Ingredients = new HashMap<>();
      recipe1Ingredients.put("Tomato", new Ingredient("Tomato", 2, 0));
      recipe1Ingredients.put("Onion", new Ingredient("Onion", 1, 0));
      recipe1Ingredients.put("Garlic", new Ingredient("Garlic", 3, 0));
      recipe1Ingredients.put("Chicken", new Ingredient("Chicken", 500, 1));
      Recipe recipe1 = new Recipe("Chicken Stew", "A delicious chicken stew.", "Cook all ingredients together.", 4, recipe1Ingredients);
      recipeBook.addRecipe(recipe1);

      HashMap<String, Ingredient> recipe2Ingredients = new HashMap<>();
      recipe2Ingredients.put("Lamb meat", new Ingredient("Lamb meat", 500, 1));
      recipe2Ingredients.put("Salt", new Ingredient("Salt", 10, 1));
      recipe2Ingredients.put("Carrot", new Ingredient("Carrot", 2, 0));
      recipe2Ingredients.put("Onion", new Ingredient("Onion", 1, 0));
      Recipe recipe2 = new Recipe("Lamb Soup", "A hearty lamb soup.", "Boil all ingredients together.", 4, recipe2Ingredients);
      recipeBook.addRecipe(recipe2);

      HashMap<String, Ingredient> recipe3Ingredients = new HashMap<>();
      recipe3Ingredients.put("Flour", new Ingredient("Flour", 200, 1));
      recipe3Ingredients.put("Milk", new Ingredient("Milk", 500, 2));
      recipe3Ingredients.put("Egg", new Ingredient("Egg", 2, 0));
      Recipe recipe3 = new Recipe("Pancakes", "Fluffy pancakes.", "Mix all ingredients and cook on a griddle.", 4, recipe3Ingredients);
      recipeBook.addRecipe(recipe3);


    }

  }



  /**
   * Displays all recipes stored in the recipe book. This method delegates the
   * task to the
   * recipeBook's displayRecipeBook method.
   */
  public void displayRecipeBook() {
    System.out.println("\n");
    System.out.println("---------------------------------------------------------");
      
    System.out.printf("| %-20s  %-13s  %-16s |%n", " ", "RecipeBook", " ");
    System.out.println("---------------------------------------------------------");

    Iterator<Recipe> iterator = recipeBook.getIterator();
    while (iterator.hasNext()) {
      Recipe recipe = iterator.next();
      System.out.println("Recipe Name: " + recipe.getName());
      System.out.println("Description: " + recipe.getDescription());
      System.out.println("Instruction: " + recipe.getInstructions());
      System.out.println("Ingredients & Amount:");
      recipe.getRecipeIngredients().forEach((name, ingredient) -> {
        System.out.println(name + " " + ingredient.getIngredientAmount() + ingredient.getIngredientMeasurment());
      });
      System.out.println("---------------------------------------------------------");

    }
  }



  /**
   * Displays the application menu with various options,
   * for the user to interact with the food storage and recipes.
   * The menu includes options to:
   * <ul>
   *   <li>Add ingredients to the food storage</li>
   *   <li>Search for an ingredient in the food storage</li>
   *   <li>Display ingredients in the food storage</li>
   *   <li>Use an ingredient from the storage</li>
   *   <li>Create a recipe</li>
   *   <li>View recipes</li>
   *   <li>Check recipes that can be made with the ingredients in the food storage</li>
   *   <li>Get advice on a recipe to make with the ingredients in the storage</li>
   *   <li>Generate ingredients or recipes</li>
   *   <li>Exit the application</li>
   * </ul>
   */
  public void applicationMenu() {
    System.out.println("\nSelection Menu:"
                    + "\n1. Add Ingredients to your food storage"
                    + "\n2. Search for Ingredient in storage"
                    + "\n3. Display ingredients in the food storage"
                    + "\n4. Create Recipe"
                    + "\n5. View Recipes."
                    + "\n6. Search for recipe."
                    + "\n7. Advice me of Recipe to make with ingredients in my storage."
                    + "\n99. Generate ingredients or recipes"
                    + "\n0. Exit app");
  }



  /**
   * Displays a menu for the user to choose whether 
   * to use or add an amount of the specified ingredient.
   *
   * @param ingredient the Ingredient object for which the menu is displayed
   */
  public void ingredientMenuText(Ingredient ingredient) {
    System.out.println("\nIngredient selection menu:"
            + "\n1. Use amoumt of " + ingredient.getIngredientName()
            + "\n2. Add amount of " + ingredient.getIngredientName()
            + "\n3. Remove " + ingredient.getIngredientName()
            + "\n0. Go back to start menu");
  }



  public void foodStorageMenu() {
    System.out.println("\nIngredient selection menu:"
            + "\n1. Remove expire ingredients" 
            + "\n2. Check the value of the storage"
            + "\n3. Redisplay food storage"
            + "\n0. Go back to start menu");
  }



  /**
   * Searches for an ingredient in the food storage by name.
   *
   * @param userInput the Scanner object used to read user input
   */
  public void findIngredientInStorage(Scanner userInput) {
    
  
    
    System.out.println("\nEnter the name of the ingredient to search: ");
    String ingredientName = ValidationUtil.isVaildStringInput(userInput, "ingredient name");
    ingredientName = ingredientName.substring(0, 1).toUpperCase() 
                    + ingredientName.substring(1, ingredientName.length());
    Ingredient ingredient = foodStorage.getIngredient(ingredientName);
    if (ingredient == null) {
      System.out.println("\nIngredient doesn't exist.");
    } else {
      System.out.println("\nThe ingredient you are looking for is in the storage:"
                        + "\nIngredient info"
                        + "\nName: " 
                        + ingredient.getIngredientName()
                        + "\nAmount: "
                        + ingredient.getIngredientAmount()
                        + ingredient.getIngredientMeasurment()
                        + "\nPrice: " 
                        + ingredient.getIngredientPrice() + "$"
                        + "\nExpire Date: "    
                        + ingredient.getIngredientExpireDate());


      ingredientMenu(userInput, ingredient);   
    }
  }


  /**
   * Prompts the user to either use or add an amount of the specified ingredient.
   *
   * @param userInput the Scanner object used to read user input
   * @param ingredient the Ingredient object to be used or added
   */
  public void ingredientMenu(Scanner userInput, Ingredient ingredient) {
    boolean switchLoop = true;
    while (switchLoop == true) {
      ingredientMenuText(ingredient);
      int useAddSelection = ValidationUtil.isVaildIntInput(userInput, "menu selection");
      switch (useAddSelection) {
        case USE_INGREDIENT_AMOUNT -> useAmoutOfIngredient(userInput, ingredient);
        case ADD_INGREDIENT_AMOUNT -> increaseIngredientAmount(userInput, ingredient);
        case REMOVE_INGREDIENT -> {
          foodStorage.removeIngredient(ingredient.getIngredientName());
          switchLoop = false;
          System.out.println("\nIngredients was successfully removed");
        }
        case QUIT_INGREDIENT_AMOUNT_MENU -> switchLoop = false;
        default -> System.out.println("\nInvalid selection. Please try again.");
      }
    }
  }



  /**
   * Increases the amount of the specified ingredient by prompting the user for input.
   *
   * @param userInput the Scanner object used to read user input
   * @param ingredient the Ingredient object to be increased
   */
  public void increaseIngredientAmount(Scanner userInput, Ingredient ingredient) {
    System.out.println("\nGive us the amount your want to add extra of "
                      + ingredient.getIngredientName()
                      + ": ");

    double addIngredientAmount = ValidationUtil.isVaildDoubleInput(userInput, 
                                                                  "adding extra ingredient amount");

    while (addIngredientAmount <= 0) {
      System.out.println("\nYou cant add nothing or a negative number try again: ");
      addIngredientAmount = ValidationUtil.isVaildDoubleInput(userInput, 
                                                              "adding extra ingredient amount");
    }
    ingredient.setExtraIngredientAmount(addIngredientAmount);

    System.out.println("\nThis is your new amount for "
                      + ingredient.getIngredientName() + ":");
    System.out.println(ingredient.getIngredientAmount());
  }



  /**
   * Uses a specified amount of the given ingredient by prompting the user for input.
   *
   * @param userInput the Scanner object used to read user input
   * @param ingredient the Ingredient object to be used
   */
  public void useAmoutOfIngredient(Scanner userInput, Ingredient ingredient) {
    System.out.println("\nhow much/many of "
                      + ingredient.getIngredientName()
                      + " you want to use? ");
    double useIngredientAmout = ValidationUtil.isVaildDoubleInput(userInput, 
                                                                  "adding extra ingredient amount");

    boolean useLoop = true;                                                       
    while (useLoop) {
      if (useIngredientAmout <= 0 && useIngredientAmout > ingredient.getIngredientAmount()) {
        System.out.println("\nYou cant add negative or than existed amount of the Ingredient.");
        useIngredientAmout = ValidationUtil.isVaildDoubleInput(userInput, 
                                                                "adding extra ingredient amount");
      } else {
        useLoop = false;
        ingredient.setUsedIngredientAmount(useIngredientAmout);
        System.out.println("\nThis is your new amount for "
                          + ingredient.getIngredientName() 
                          + ":");
        System.out.println(ingredient.getIngredientAmount());
      }
    }


  }



  /**
   * Searches for an ingredient in the food storage by name.
   *
   * @param userInput the Scanner object used to read user input
   */
  public void searchForRecipe(Scanner userInput) {
    System.out.println("\nEnter the name of the Recipe to search for: ");
    String recipeName = ValidationUtil.isVaildStringInput(userInput, "recipe name");
    recipeName = recipeName.substring(0, 1).toUpperCase() 
                    + recipeName.substring(1, recipeName.length());
    Recipe recipe = recipeBook.getRecipe(recipeName);
    if (recipe == null) {
      System.out.println("\nRecipe doesn't exist.");
    } else {
      showRecipeInfo(recipe);
      allRecipeIngreidents(recipe);

      System.out.println("\nDo you want to check if you have enough ingredients for this recipe?"
                        + " ([y/Y]=Yes Or anything to exit must be one charcter.)");
      char checkIfReadyToMake = ValidationUtil.isValidCharInput(userInput, "Check on recipe");
      if (checkIfReadyToMake == 'y' || checkIfReadyToMake == 'Y') {
        checkIfRecipeReadyToMake(recipe);  
      } else {
        System.out.println("Getting back to main menu");
      }
    }
  }



  /**
   * Displays the information of a given recipe.
   *
   * @param recipe the Recipe object whose information is to be displayed
   */
  public void showRecipeInfo(Recipe recipe) {
    System.out.println("\nHere i the recipe Info"
                      + "\nName: " 
                      + recipe.getName()
                      + "\nDescirption: "
                      + recipe.getDescription()
                      + "\nInstruction: " 
                      + recipe.getInstructions()
                      + "\nNumber of servings: "    
                      + recipe.getRecipeServing());
  }



  /**
   * Displays all ingredients of a given recipe.
   *
   * @param recipe the Recipe object whose ingredients are to be displayed
  */
  public void allRecipeIngreidents(Recipe recipe) {
    System.out.println("Ingredients & Amount");
    recipe.getRecipeIngredients().forEach((name, recipeIngredient) -> {
      System.out.println(name + ": " + recipeIngredient.getIngredientAmount() 
                        + recipeIngredient.getIngredientMeasurment());
    });
  }



  /**
   * Prompts the user to decide whether to remove expired ingredients from the food storage.
   * If the user confirms, iterates through the food storage 
   * and removes ingredients marked as expired.
   * Prints the name of each removed ingredient and a summary message.
   * If the user declines, prints a message indicating no ingredients were removed.
   */
  public void removeExipredIngredients() {
    System.out.println("\nDo you want to get rid of expired ingredient?"  
                     + " ([y/Y]=Yes Or anything to exit must be one charcter.)");
    Scanner userInput = new Scanner(System.in);
    char choiceInput = ValidationUtil.isValidCharInput(userInput, "removing expired ingredients");
    double sumOfExpiredIngredientPrices = 0.0;
    if (choiceInput == 'y' || choiceInput == 'Y') {
      Iterator<Ingredient> iterator = foodStorage.getIterator();
      while (iterator.hasNext()) {
        Ingredient ingredient = iterator.next();
        if (ingredient.getIngredientExpireDate().equals("Expired")) {
          sumOfExpiredIngredientPrices += ingredient.getIngredientPrice();
          iterator.remove();
          System.out.println("Removed expired ingredient: " + ingredient.getIngredientName());
        }
      }
      System.out.println("Expired ingredients removed.");
      System.out.println("Total price of expired Ingredients: " + sumOfExpiredIngredientPrices);
    } else {
      System.out.println("No ingredients were removed.");
    }
  }



  /**
   * Checks if all ingredients required for a given recipe are available in the food storage.
   *
   * @param recipe the Recipe object to check for available ingredients
   */
  public void checkIfRecipeReadyToMake(Recipe recipe) {

    List<String> nonExistentIngredients = new ArrayList<>();
    List<String> expiredIngredients = new ArrayList<>();
    List<String> lowAmountOfIngredient = new ArrayList<>();
    int availableIngredientCounter = 0;
    for (Ingredient ingredient : recipe.getRecipeIngredients().values()) {
      Ingredient storedIngredient = foodStorage.getIngredient(ingredient.getIngredientName());
      if (storedIngredient == null) {
        nonExistentIngredients.add(ingredient.getIngredientName());
      } else if (storedIngredient.getIngredientExpireDate().equals("Expired")) {
        expiredIngredients.add(ingredient.getIngredientName());
      } else if (storedIngredient.getIngredientAmount() < ingredient.getIngredientAmount()) {
        lowAmountOfIngredient.add(ingredient.getIngredientName());
      } else {
        availableIngredientCounter++;
      }

    }

    if (recipe.getRecipeIngredients().size() ==  availableIngredientCounter) {
      System.out.println("\nAll ingredients for " 
                        + recipe.getName() 
                        + " are available in the food storage.");
    } else {
      System.out.println("\nNot all ingredients for " 
                        + recipe.getName() 
                        + " are available in the food storage.");

      if (nonExistentIngredients.size() > 0) {
        System.out.println("\nThe missing ingredients that arent in storage.");
        for (String notExistentIngredients  : nonExistentIngredients) {
          System.out.print(notExistentIngredients);  
        }
      }                 

      if (expiredIngredients.size() > 0) {
        System.out.println("\nThe following expired ingredients are in storage but cant be used.");
        for (String expired  : expiredIngredients) {
          System.out.println(expired);
        }
      }

      if (lowAmountOfIngredient.size() > 0) {
        System.out.println("\nNot enough amount of following ingredients to make the recipe.");
        for (String notEnough  : lowAmountOfIngredient) {
          System.out.println(notEnough);
        }
      }
    }
  }



  public void adviceMeARecipeMake(){
    List<String> readyRecipes = new ArrayList<>();
    Iterator<Recipe> iterator = recipeBook.getIterator();
    while (iterator.hasNext()) {
      Recipe recipe = iterator.next();
      int totalIngredientStored = 0;
      for (Ingredient ingredient : recipe.getRecipeIngredients().values()) {
        if (foodStorage.getIngredients().containsKey(ingredient.getIngredientName())) {
          totalIngredientStored++;
        } 
      }

      if (totalIngredientStored == recipe.getRecipeIngredients().values().size()){
        readyRecipes.add(recipe.getName());
      }
    }

    if(readyRecipes.size() == 0){
      System.out.println("\nYou cant make any recipe from the book");
    }else{
      System.out.println("\nYou can cook the following recipes");
      for(String recipe : readyRecipes){
        System.out.println(recipe);
      }
    }

  }

  


}