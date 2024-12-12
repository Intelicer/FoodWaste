package edu.ntnu.iir.bidata.ui;

//IMPORT CUSTOM PACKAGES
import edu.ntnu.iir.bidata.entity.Ingredient;
import edu.ntnu.iir.bidata.entity.Recipe;
import edu.ntnu.iir.bidata.logic.FoodStorage;
import edu.ntnu.iir.bidata.logic.RecipeBook;
import edu.ntnu.iir.bidata.untility.ValidationUtil;
//IMPORT JAVA UTILITIES
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The UserInterface class provides a command-line interface for 
 * interacting with the FoodStorage and RecipeBook.
 * It allows users to add ingredients to the food storage, 
 * create and view recipes, and perform various operations
 * on the stored ingredients and recipes.
 * 
 * <p>The class includes methods for initializing the interface, 
 * starting the application, adding ingredients to storage,
 * displaying the food storage, writing recipes in the recipe book, 
 * generating random ingredients and recipes,
 * finding ingredients in storage, using or adding amounts of ingredients, 
 * searching for recipes, cooking recipes,
 * suggesting recipes to make, and removing expired ingredients.
 * 
 * <p>The class also provides helper methods for prompting the user for input, 
 * displaying menus, and checking if recipes
 * can be made with the available ingredients.
 * 
 * <p>The UserInterface class relies on the FoodStorage, RecipeBook, 
 * Ingredient, Recipe, and ValidationUtil classes.
 * 
 * <p>The main entry point for the application is the applicationStart() method, 
 * which runs the main loop of the application
 * and handles user input to perform various operations.
 * 
 * <p>The class uses constants to represent menu options and other fixed values.

 * 
 * @see FoodStorage
 * @see RecipeBook
 * @see Ingredient
 * @see Recipe
 * @see ValidationUtil
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class UserInterface {
  // ! Declearing and inizilizing classes
  private FoodStorage foodStorage = new FoodStorage(new HashMap<>());
  private RecipeBook recipeBook = new RecipeBook(new HashMap<>());
  private Scanner userInput;

  
  // ! Declearing and inizilizing classes
  // ? use static final to constant for appStart()
  private static final int ADD_INGREDIENT_TO_STORAGE = 1;
  private static final int FIND_INGREDIENT_IN_STORAGE = 2;
  private static final int DISPLAY_FOODSTORAGE = 3;
  private static final int ADD_RECIPE_TO_RECIPE_BOOK = 4;
  private static final int DISPLAY_RECIPE_BOOK = 5;
  private static final int SEARCH_FOR_RECIPE = 6;
  private static final int SUGGEST_RECIPES_TO_MAKE = 7;
  private static final int GENERATE_RECIPE_AND_INGREDIENTS = 99;
  private static final int QUIT_APP = 0;

  // ? constant for ingredientMenu() in sea
  private static final int USE_INGREDIENT_AMOUNT = 1;
  private static final int ADD_INGREDIENT_AMOUNT = 2;
  private static final int REMOVE_INGREDIENT = 3;
  private static final int QUIT_INGREDIENT_AMOUNT_MENU = 0;
  
  // ? Constant for displayFoodStorage()
  private static final int REMOVE_EXPIRED_INGREDIENTS = 1;
  private static final int CHECK_VALUE_FOODSTORAGE_INGREDIENTS = 2;
  private static final int REDISPLAY_FOODSTORAGE = 3;

  // ? Constant for recipeMenu() in searchRecipe()
  private static final int COOKABLE_RECIPE = 1;
  private static final int COOK_RECIPE = 2;
  private static final int REMOVE_RECIPE = 3;
  private static final int QUIT_RECIPE_MENU = 0;

  
  private int appStartSkip = 0;


  public UserInterface() { 
  }

  /**
 * Initializes the UserInterface by displaying the current state of the food storage
 * and the recipe book. This method is intended to be called at the start of the application
 * to provide the user with an overview of the available ingredients and recipes.
 */
  public void inti() {
    displayFoodStorage();
    displayRecipeBook();
  }

  /**
   * Starts the FoodWasteApp. Displays a welcome message and a selection menu.
   * Runs the main loop of
   * the application.
  */
  public void applicationStart() {
    userInput = new Scanner(System.in);
    // ? Declearing Loop and Insilizing it
    boolean mainRunForever = true;

    // ? Use of main class
    System.out.println("\nWelcome To FoodWaste Application"); // Welcome Message to Application
    System.out.println("Here you will get a selection menu to make it easy for you :)");
    while (mainRunForever == true) {
      applicationStartMenu();
      int choosenSelection = ValidationUtil.isVaildIntInput(userInput, "Menu Selection");
      switch (choosenSelection) {
        case ADD_INGREDIENT_TO_STORAGE -> addIngredientToStorage(userInput);
        case FIND_INGREDIENT_IN_STORAGE -> findIngredientInStorage(userInput);
        case DISPLAY_FOODSTORAGE -> displayFoodStorage();
        case ADD_RECIPE_TO_RECIPE_BOOK -> writeRecipeInBook(userInput);
        case DISPLAY_RECIPE_BOOK -> displayRecipeBook();
        case SEARCH_FOR_RECIPE -> searchForRecipe(userInput);
        case SUGGEST_RECIPES_TO_MAKE -> suggestRecipesToMake();
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
 * Prompts the user to add ingredients to the food storage.
 * The method repeatedly asks the user to input ingredient details until the user decides to stop.
 *
 * @param userInput a Scanner object to read user input
 */
  public void addIngredientToStorage(Scanner userInput) {
    System.out.println("Now you will get some question "
                      + "to set you ingredient in storage");
    boolean addIngredientForever = true; // add ingredients loop
    while (addIngredientForever == true) {


      String ingredientName = askAboutIngredientName(userInput);
      
      if (!foodStorage.getIngredients().containsKey(ingredientName)) {
        int ingredientMeasurement = askAboutIngredientMessurment(userInput);
        double ingreadientAmount = askAboutIngredientAmount(userInput, ingredientName);
        double ingredientPrice = askAboutIngredientPrice(userInput, ingredientName);
        String ingredientExpireDate = askAboutIngredientExpireDate(userInput);
        Ingredient ingredient = new Ingredient(ingredientName, 
                                              ingreadientAmount, 
                                              ingredientMeasurement, 
                                              ingredientPrice, 
                                              ingredientExpireDate);
        this.foodStorage.addIngredient(ingredient);
        
        System.out.println(
            "\nPress (N) or (n) if you are finished from adding "
            + "and want to see your foodStorage,"
            + "\nor if you want to add more ingredients write any letter.");
        char loopExit = ValidationUtil.isValidCharInput(userInput, "Exiting");
        if (loopExit == 'n' || loopExit == 'N') {
          addIngredientForever = false;
        } 
      } else {
        System.out.println("\nThe ingredient is in the storage."
                          + "\nYou can search for it in your foodStorage");
        addIngredientForever = false;
     
      }




    }
    addIngredientForever = true;
  }


  /**
   * Displays all ingredients stored in the food storage. This method calls the
   * displayAllIngredients() method of the this.foodStorage object to print out
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
    Iterator<Ingredient> iterator = this.foodStorage.getIterator();

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


    if (this.foodStorage.getIngredients().size() > 0) {

      if (appStartSkip == 1) {
        Scanner userInput = new Scanner(System.in);
        boolean switchLoop = true;
        System.out.println("Welcome to ur storage."
                            + "\nHere you will get a navigation menu for the storage");
        while (switchLoop == true) {
          foodStorageMenu();
          int useAddSelection = ValidationUtil.isVaildIntInput(userInput, "storage menu");
          switch (useAddSelection) {
            case REMOVE_EXPIRED_INGREDIENTS -> removeExipredIngredients();
            case CHECK_VALUE_FOODSTORAGE_INGREDIENTS -> {
              System.out.println("\nPrice of expired Ingredients: " 
                                  + sumOfExpiredIngredientPrices + "$");
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
            case QUIT_INGREDIENT_AMOUNT_MENU -> {
              switchLoop = false;
              appStartSkip = 1;
            } 
            default -> System.out.println("Invalid selection. Please try again.");
          }
        }
      }
    } else {
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
    String recipeName = askAboutRecipeName(userInput);
    if (!recipeBook.getRecipes().containsKey(recipeName)) {
      String recipeDescription = askAboutRecipeDescription(userInput, recipeName);
      String recipeInstructions = askAboutRecipeInstructions(userInput, 
                                                            recipeName);
      int recipeServing = askAboutRecipeServing(userInput, recipeName);
      Boolean addIngredientToRecipe = true;
      HashMap<String, Ingredient> recipeIngredients = new HashMap<>();
      while (addIngredientToRecipe == true) {
        System.out.println("\n\nNow you will get some repeatable question about"
                          + "ingreadients and you can exit after putting the amount");
        System.out.println("\nWhat are the ingredient that in the recipe:");
        String ingredientName = askAboutIngredientName(userInput);
        int ingredientMeasurement = askAboutIngredientMessurment(userInput);
        double ingredientAmout = askAboutIngredientAmount(userInput, ingredientName);
        recipeIngredients.put(ingredientName, new Ingredient(
                                                            ingredientName,
                                                            ingredientAmout,
                                                            ingredientMeasurement));
  
        System.out.println("Press (N) or (n) if you are finished.");
        String loopExit = userInput.nextLine().substring(0);
        if (loopExit.equals("N") || loopExit.equals("n")) {
          addIngredientToRecipe = false; // change value to get out of loop
        }
      }
      Recipe userRecipe = new Recipe(recipeName,
                                      recipeDescription,
                                      recipeInstructions,
                                      recipeServing,
                                      recipeIngredients);
      this.recipeBook.addRecipe(userRecipe);
    } else {
      System.out.println("\nThe recipe you want to add is already in the book.");
    }
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
        "Tomato", "Onion", "Garlic", "Carrot", "Lemon"
      };

      for (int i = 0; i < 5; i++) {
        this.foodStorage.addIngredient(new Ingredient(ingredientInPieces[i], 
                                            500, 0, 100, "2024-12-31"));
      }
      ;

      //! Ingredient in gram
      String[] ingredientInGram = {
        "Chicken", "Salt", "Lamb meat", "ground meat", "Flour"
      };
      for (int i = 0; i < 5; i++) {
        this.foodStorage.addIngredient(new Ingredient(ingredientInGram[i], 500.0, 
                                            1, 150, "2024-12-31"));
      }
      ;

      //! Ingredient in gram
      String[] ingredientInLiter = {
        "Water", "Milk", "food cream", "juice", "Flour"
      }
      ;

      for (int i = 0; i < 5; i++) {
        this.foodStorage.addIngredient(new Ingredient(ingredientInLiter[i], 200.0, 
                                            2, 100, "2024-12-31"));
      }
      ;



      //Expired ingredients:
      this.foodStorage.addIngredient(new Ingredient("kiwi", 20.0, 
                                                    0, 100, "2022-12-31"));
      this.foodStorage.addIngredient(new Ingredient("sweet chili", 20.0, 
                                                    0, 100, "2022-10-31"));





      // Create recipes based on the ingredients
      HashMap<String, Ingredient> recipe1Ingredients = new HashMap<>();
      recipe1Ingredients.put("Tomato", new Ingredient("Tomato", 2, 0));
      recipe1Ingredients.put("Onion", new Ingredient("Onion", 1, 0));
      recipe1Ingredients.put("Garlic", new Ingredient("Garlic", 3, 0));
      recipe1Ingredients.put("Chicken", new Ingredient("Chicken", 500, 1));
      Recipe recipe1 = new Recipe("Chicken Stew", "A delicious chicken stew.",
                          "Cook all ingredients together.", 4, recipe1Ingredients);
      this.recipeBook.addRecipe(recipe1);

      HashMap<String, Ingredient> recipe2Ingredients = new HashMap<>();
      recipe2Ingredients.put("Lamb meat", new Ingredient("Lamb meat", 500, 1));
      recipe2Ingredients.put("Salt", new Ingredient("Salt", 10, 1));
      recipe2Ingredients.put("Carrot", new Ingredient("Carrot", 2, 0));
      recipe2Ingredients.put("Onion", new Ingredient("Onion", 1, 0));
      Recipe recipe2 = new Recipe("Lamb Soup", "A hearty lamb soup.",
                          "Boil all ingredients together.", 4, recipe2Ingredients);
      this.recipeBook.addRecipe(recipe2);

      HashMap<String, Ingredient> recipe3Ingredients = new HashMap<>();
      recipe3Ingredients.put("Flour", new Ingredient("Flour", 200, 1));
      recipe3Ingredients.put("Milk", new Ingredient("Milk", 500, 2));
      recipe3Ingredients.put("Egg", new Ingredient("Egg", 2, 0));
      Recipe recipe3 = new Recipe("Pancakes", "Fluffy pancakes.", 
                          "Mix all ingredients and cook on a griddle.", 4, recipe3Ingredients);
      this.recipeBook.addRecipe(recipe3);

      System.out.println("\nSuccessfully generated.");
    }

  }



  /**
   * Displays all recipes stored in the recipe book. This method delegates the
   * task to the
   * this.recipeBook's displayRecipeBook method.
   */
  public void displayRecipeBook() {
    System.out.println("\n");
    System.out.println("---------------------------------------------------------");
      
    System.out.printf("| %-20s  %-13s  %-16s |%n", " ", "RecipeBook", " ");
    System.out.println("---------------------------------------------------------");

    Iterator<Recipe> iterator = this.recipeBook.getIterator();
    while (iterator.hasNext()) {
      Recipe recipe = iterator.next();
      System.out.println("Recipe Name: " + recipe.getRecipeName());
      System.out.println("Description: " + recipe.getRecipeDescription());
      System.out.println("Instruction: " + recipe.getRecipeInstructions());
      System.out.println("Ingredients & Amount:");
      recipe.getIngredients().forEach((name, ingredient) -> {
        System.out.println(name 
            + " " 
            + ingredient.getIngredientAmount() 
            + ingredient.getIngredientMeasurment());
      });
      System.out.println("---------------------------------------------------------");

    }
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
    Ingredient ingredient = this.foodStorage.getIngredient(ingredientName);
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
    System.out.println("\nNow you will recive a menu for the ingredient:");
    while (switchLoop == true) {
      ingredientMenuText(ingredient);
      int useAddSelection = ValidationUtil.isVaildIntInput(userInput, "ingredient menu");
      switch (useAddSelection) {
        case USE_INGREDIENT_AMOUNT -> {
          if (ingredient.getIngredientAmount() != 0) {
            useAmoutOfIngredient(userInput, ingredient);
          } else {
            System.out.println("\nThere is no amount left of the ingredient");
          }
        }
        case ADD_INGREDIENT_AMOUNT -> increaseIngredientAmount(userInput, ingredient);
        case REMOVE_INGREDIENT -> {
          this.foodStorage.removeIngredient(ingredient.getIngredientName());
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
    Recipe recipe = this.recipeBook.getRecipe(recipeName);
    if (recipe == null) {
      System.out.println("\nRecipe doesn't exist.");
    } else {
      showRecipeInfo(recipe);
      allRecipeIngreidents(recipe);
      recipeMenu(userInput, recipe);
    }
  }



  /**
 * Displays a menu for the given recipe and handles user input to perform actions on the recipe.
 * The menu provides options to make the recipe, remove the recipe, or quit the menu.
 *
 * @param userInput a Scanner object to read user input
 * @param recipe the Recipe object for which the menu is displayed
 */
  public void recipeMenu(Scanner userInput, Recipe recipe) {
    boolean switchLoop = true;
    System.out.println("\nNow you will recive a menu for the ingredient:");
    while (switchLoop == true) {
      recipeMenuText(recipe);
      int useAddSelection = ValidationUtil.isVaildIntInput(userInput, "recipe menu");
      switch (useAddSelection) {
        case COOKABLE_RECIPE -> {
          checkIfCookable(recipe);  
        }
        case COOK_RECIPE -> cookRecipe(recipe);
        case REMOVE_RECIPE -> { 
          this.recipeBook.removeRecipe(recipe.getRecipeName());
        }
        case QUIT_RECIPE_MENU -> switchLoop = false;
        default -> System.out.println("\nInvalid selection in recipe menu");
      }
    }
  }


  /**
  * Attempts to cook a recipe by checking if all required 
  * ingredients are available in the food storage.
  * If all ingredients are available, their amounts are updated to reflect usage, 
  * and a success message is printed.
  * If any ingredients are missing, an error message is printed.
  *
  * @param recipe the Recipe object to be cooked
  */
  public void cookRecipe(Recipe recipe) {
    int recipeIngredientStored = 0;
    for (Ingredient ingredient : recipe.getIngredients().values()) {
      if (this.foodStorage.getIngredients().containsKey(ingredient.getIngredientName())) {
        recipeIngredientStored++;
      } 
    }

    if (recipeIngredientStored == recipe.getIngredients().size()) {
      for (Ingredient recipeIngredient : recipe.getIngredients().values()) {
        this.foodStorage.getIngredient(recipeIngredient.getIngredientName())
              .setUsedIngredientAmount(recipeIngredient.getIngredientAmount());

        double ingredientAmount = this.foodStorage.getIngredient(recipeIngredient
                                                        .getIngredientName()).getIngredientAmount();

        if (ingredientAmount == 0) {
          this.foodStorage.removeIngredient(recipeIngredient.getIngredientName());
          System.out.println("U ran out of " + recipeIngredient.getIngredientName());
        }
      }
      System.out.println("Recipe has been made.");
    } else {
      System.out.println("Recipe missing ingredient.");
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
                      + recipe.getRecipeName()
                      + "\nDescirption: "
                      + recipe.getRecipeDescription()
                      + "\nInstruction: " 
                      + recipe.getRecipeInstructions()
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
    recipe.getIngredients().forEach((name, recipeIngredient) -> {
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
  public void removeExipredIngredients() { //* saw */
    System.out.println("\nDo you want to get rid of expired ingredient?"  
                     + " ([y/Y]=Yes Or anything to exit must be one charcter.)");
    Scanner userInput = new Scanner(System.in);
    char choiceInput = ValidationUtil.isValidCharInput(userInput, "removing expired ingredients");
    double sumOfExpiredIngredientPrices = 0.0;
    if (choiceInput == 'y' || choiceInput == 'Y') {
      Iterator<Ingredient> iterator = this.foodStorage.getIterator();
      while (iterator.hasNext()) {
        Ingredient ingredient = iterator.next();
        if (ingredient.getIngredientExpireDate().equals("Expired")) {
          sumOfExpiredIngredientPrices += ingredient.getIngredientPrice();
          iterator.remove();
          System.out.println("Removed expired ingredient: " + ingredient.getIngredientName());
        }
      }
      System.out.println("\n Succesfully removed expired ingredients.");
      System.out.println("Total price of expired Ingredients: " + sumOfExpiredIngredientPrices);
    } else {
      System.out.println("\nNo ingredients were removed.");
    }
  }



  /**
   * Checks if all ingredients required for a given recipe are available in the food storage.
   *
   * @param recipe the Recipe object to check for available ingredients
   */
  public void checkIfCookable(Recipe recipe) {
    List<String> expiredIngredients = new ArrayList<>();
    List<String> missingIngredients = new ArrayList<>();
    Map<String, String> lowAmountIngredients = new HashMap<>();
    int readyStorageIngredients = 0;
    Iterator<Ingredient> iterator = recipe.getIngredientIterator();
    while (iterator.hasNext()) {
      Ingredient recipeIngredient = iterator.next();

      if (this.foodStorage.getIngredients().containsKey(recipeIngredient.getIngredientName())) {
        double storedIngredientAmount = this.foodStorage
                                        .getIngredient(recipeIngredient.getIngredientName())
                                        .getIngredientAmount();

        String storedIngredientDate = this.foodStorage
                .getIngredient(recipeIngredient.getIngredientName())
                .getIngredientExpireDate();

        if (!this.foodStorage.getIngredients().containsKey(recipeIngredient.getIngredientName())) {
          missingIngredients.add(recipeIngredient.getIngredientName());
        } else if (recipeIngredient.getIngredientAmount() <= storedIngredientAmount 
            && !storedIngredientDate.equals("Expired")) {
          readyStorageIngredients++;
        } else if (recipeIngredient.getIngredientAmount() > storedIngredientAmount 
                                      && !storedIngredientDate.equals("Expired")) {
          lowAmountIngredients.put(recipeIngredient.getIngredientName(),
                      (storedIngredientAmount - recipeIngredient.getIngredientAmount())
                      + recipeIngredient.getIngredientMeasurment());
        } else {
          expiredIngredients.add(recipeIngredient.getIngredientName());
        }
      } else {
        missingIngredients.add(recipeIngredient.getIngredientName());
      }
      

    }

    if (readyStorageIngredients == recipe.getIngredients().size()) {
      System.out.println("\nThis recipe can be made.");
    } else {
      System.out.println("\nThis recipe cant be made.");

      if (missingIngredients.size() > 0) {
        System.out.println("The following ingredient isn't in the storage:");
        missingIngredients.forEach(ingredientName -> System.out.println(ingredientName));
      }

      if (lowAmountIngredients.size() > 0) {
        System.out.println("\nThe following ingredients have a lower amount than required:");
        lowAmountIngredients.forEach((ingredient, ingreadients) -> {
          System.out.println(ingredient + " missing: " + ingreadients);
        });
      }

      if (expiredIngredients.size() > 0) {
        System.out.println("\nThe following ingredients is expired");
        expiredIngredients.forEach(ingredientName -> System.out.println(ingredientName));
      }
    }
  }




  /**
 * Suggests recipes that can be made with the ingredients available in the food storage.
 * It checks all available recipes in the recipe book and prints the names of the recipes
 * that can be made with the current ingredients.
 */
  public void suggestRecipesToMake() {
    List<String> readyRecipes = new ArrayList<>();
    Iterator<Recipe> iterator = this.recipeBook.getIterator();
    while (iterator.hasNext()) {
      Recipe recipe = iterator.next();
      int totalIngredientStored = 0;
      for (Ingredient ingredient : recipe.getIngredients().values()) {
        if (this.foodStorage.getIngredients().containsKey(ingredient.getIngredientName())) {
          totalIngredientStored++;
        } 
      }

      if (totalIngredientStored == recipe.getIngredients().values().size()) {
        readyRecipes.add(recipe.getRecipeName());
      }
    }

    if (readyRecipes.size() == 0) {
      System.out.println("\nYou cant make any recipes from the book");
    } else {
      System.out.println("\nYou can cook the following recipes");
      for (String recipe : readyRecipes) {
        System.out.println(recipe);
      }
    }

  }



  














  
  /**
 * Prompts the user to input the name of a recipe.
 *
 * @param userInput the Scanner object to read user input
 * @return the name of the recipe
 */  
  public String askAboutRecipeName(Scanner userInput) {
    System.out.println("\nWhat is the name of recipe you want to add in the book?");
    String recipeName = ValidationUtil.isVaildStringInput(userInput, "recipe name");
    return recipeName;
  }


  /**
 * Prompts the user to input a description for a recipe.
 *
 * @param userInput the Scanner object to read user input
 * @param userRecipeName the name of the recipe for which the description is being asked
 * @return the description for the recipe
 */
  public String askAboutRecipeDescription(Scanner userInput, String userRecipeName) {
    System.out.println("Write a Description about "
                          + userRecipeName 
                          + ":");        
    String recipeDescription = ValidationUtil.isVaildStringInput(userInput, "recipe description");
    return recipeDescription;
  }
    

  /**
 * Prompts the user to input instructions for a recipe.
 *
 * @param userInput the Scanner object to read user input
 * @param userRecipeName the name of the recipe for which the instructions are being asked
 * @return the instructions for the recipe
 */    
  public String askAboutRecipeInstructions(Scanner userInput, String userRecipeName) {
    System.out.println("Give instruction on how to make "
                          + userRecipeName 
                          + ":");
    String recipeInstructions = ValidationUtil.isVaildStringInput(userInput, "recipe instruction");
    return recipeInstructions;
  }

  /**
 * Prompts the user to input the number of servings for a recipe.
 *
 * @param userInput the Scanner object to read user input
 * @param userRecipeName the name of the recipe for which the servings are being asked
 * @return the number of servings for the recipe
 */
  public int askAboutRecipeServing(Scanner userInput, String userRecipeName) {
    System.out.println("How many people its made to?");
    int recipeServing = ValidationUtil.isVaildIntInput(userInput, "Amount of People");
    return recipeServing;
  }
  


  /**
   * Asks the user for the name of the ingredient.
   *
   * @param userInput the Scanner object to read user input
   * @return the name of the ingredient as a String
   */
  public String askAboutIngredientName(Scanner userInput) {
    System.out.println("\nWhat is the name of the ingredient?");
    String ingredientName = ValidationUtil.isVaildStringInput(userInput, "ingredient name");
    return ingredientName;
  }
  
  /**
   * Asks the user for the ingredient measurement type.
   *
   * @param userInput the Scanner object to read user input
   * @return the ingredient measurement type as an integer
   */
  public int askAboutIngredientMessurment(Scanner userInput) {
    System.out.println("\nWhat does it measure? (the number to the left) ");
    System.out.println("0. Unit/Units ");
    System.out.println("1. Gram ");
    System.out.println("2. Liter ");
    int ingredientMeasurement = ValidationUtil.isVaildMesurmentInput(userInput);
    return ingredientMeasurement;
  }
  
  
  /**
   * Asks the user for the amount of the ingredient.
   *
   * @param userInput the Scanner object to read user input
   * @param ingredientName the name of the ingredient
   * @return the amount of the ingredient as a double
   */
  public double askAboutIngredientAmount(Scanner userInput, String ingredientName) {
    System.out.println("\nWhat is the amount you have of "
                                + ingredientName + "?");
    double ingredientAmount = ValidationUtil.isVaildDoubleInput(userInput, "ingredient amount");
    return ingredientAmount;
  }
  
  /**
   * Asks the user for the price of the ingredient.
   *
   * @param userInput the Scanner object to read user input
   * @param ingredientName the name of the ingredient
   * @return the price of the ingredient as a double
   */
  public double askAboutIngredientPrice(Scanner userInput, String ingredientName) {
    System.out.println("\nWhat is the price of it "
                            + ingredientName 
                            + "? (If you selected an mesurment as unit the price is per unit)");
    double ingredientPrice = ValidationUtil.isVaildDoubleInput(userInput, "ingredient price");
    return ingredientPrice;
  }
  
  
  /**
   * Asks the user for the expiration date of the ingredient.
   *
   * @param userInput the Scanner object to read user input
   * @return the expiration date of the ingredient as a String
   */
  public String askAboutIngredientExpireDate(Scanner userInput) {
    System.out.println("\nEnter the ingredient expiration date (yyyy-MM-dd):");
    String ingredientExpireDate = ValidationUtil.isValidDateInput(userInput, 
                                          "ingredient expire date");
    return ingredientExpireDate;
  }
  
  

  /**
 * Displays the recipe menu for a given recipe.
 * The menu provides options to:
 * 1. Make the recipe
 * 2. Remove the recipe
 *
 * @param recipe the Recipe object for which the menu is displayed
 */
  public void recipeMenuText(Recipe recipe) {
    System.out.println("\nRecipe menu for "
                      + recipe.getRecipeName()
                      + ":"
                      + "\n1. Check if the recipe could be make"
                      + "\n2. Make the recipe"
                      + "\n3. Remove recipe"
                      + "\n0. Go back to start menu");
  }



  /**
 * Displays the food storage menu to the user.
 * The menu provides options to:
 * 1. Remove expired ingredients
 * 2. Check the value of the storage
 * 3. Redisplay the food storage
 * 0. Go back to the start menu
 */
  public void foodStorageMenu() {
    System.out.println("\nFood storage menu:"
            + "\n1. Remove expire ingredients" 
            + "\n2. Check the value of the storage"
            + "\n3. Redisplay food storage"
            + "\n0. Go back to start menu");
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
  public void applicationStartMenu() {
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
 * Displays the ingredient menu for a given ingredient.
 * The menu provides options to:
 * 1. View ingredient details
 * 2. Remove the ingredient
 *
 * @param ingredient the Ingredient object for which the menu is displayed
 */
  public void ingredientMenuText(Ingredient ingredient) {
    System.out.println("\nIngredient menu:"
            + "\n1. Use amoumt of " + ingredient.getIngredientName()
            + "\n2. Add amount of " + ingredient.getIngredientName()
            + "\n3. Remove " + ingredient.getIngredientName()
            + "\n0. Go back to start menu");
  }


}