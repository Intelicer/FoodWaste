package edu.ntnu.iir.bidata;

import java.util.HashMap;

/**
 * The FoodStorage class represents a storage system for ingredients. It allows adding ingredients
 * to the storage, retrieving specific ingredients, and displaying all stored ingredients. The
 * ingredients are stored in a HashMap with the ingredient name as the key.
 *
 * <p>This class provides methods to:
 *
 * <ul>
 *   <li>Add an ingredient to the storage
 *   <li>Retrieve a specific ingredient by name
 *   <li>Check the amount of a specific ingredient in the storage
 *   <li>Use a specified amount of an ingredient if it exists in the storage
 *   <li>Display all ingredients in a tabular format
 * </ul>
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * FoodStorage storage = new FoodStorage();
 * Ingredient ingredient = new Ingredient("Tomato", 5, "kg");
 * storage.addIngredient(ingredient);
 * storage.displayAllIngredients();
 * Ingredient retrievedIngredient = storage.getIngredient("Tomato");
 * }</pre>
 *
 * <p>Note: The displayAllIngredients method currently has a placeholder for additional
 * functionality.
 *
 * @see Ingredient
 * @see FoodWasteSystemPrints
 */
public class FoodStorage {

  private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();

  private HashMap<String, Ingredient> ingredientMap; // Creating HashMap for Ingredients

  public FoodStorage() {
    ingredientMap = new HashMap<>();
  }

  /**
   * Adds an ingredient to the storage.
   *
   * @param ingredient the ingredient to be added to the storage
   */
  public void addIngredient(Ingredient ingredient) {
    String ingredientName = ingredient.getIngredientName();
    this.ingredientMap.put(ingredientName, ingredient);
  }

  /**
   * Displays all ingredients in the food storage. The ingredients are displayed in a tabular format
   * with columns for the ingredient name and amount. Each row represents an ingredient with its
   * name and amount formatted for readability. The table is enclosed within horizontal lines for
   * better visual separation.
   */
  public void displayAllIngredients() {
    // declare a variable to get sum price for all ingredients
    final double[] sumOfIngredientPrices = {
      0.0
    }; // must use final because the variable are used in lambda expression.
    final double[] sumOfExpiredIngredientPrices = {
      0.0
    }; // must use final because the variable are used in lambda expression.

    // //! | %-10s | %-8s | %4s |%n sizes
    foodWasteSystemPrints.userDisplayFoodStorage(); // Welcome Message to Application

    String expired = "Expired";

    this.ingredientMap.forEach(
        (ingredientName, ingredient) -> { // lamda
          System.out.printf(
              "| %-13s | %-13s | %-13s | %-16s |%n",
              ingredient.getIngredientName(),
              ingredient.getIngredientAmout() + " " + ingredient.getIngredientMeasurmentmentType(),
              ingredient.getIngredientPriceWithMoneySymbol(),
              ingredient.getIngredientExpireDate());
          System.out.println(
              "--------------------------------------------------------------------");

          if (ingredient.getIngredientExpireDate().equals(expired)) {
            sumOfExpiredIngredientPrices[0] += ingredient.getIngredientPrice();
          } else {
            sumOfIngredientPrices[0] += ingredient.getIngredientPrice();
          }
        });
    System.out.println("Price of expired Ingredients: " + sumOfExpiredIngredientPrices[0] + "$");
    System.out.println("Price of valid Ingredients: " + sumOfIngredientPrices[0] + "$");
    System.out.println(
        "Total Price : " + (sumOfIngredientPrices[0] + sumOfExpiredIngredientPrices[0]) + "$");
  }

  /**
   * Checks if an ingredient exists in the storage and prints its details.
   *
   * @param nameOfIngredientTofind the name of the ingredient to find
   */
  public void checkIngredientExistensInStorage(String nameOfIngredientTofind) {
    if (nameOfIngredientTofind.isBlank()) {
      throw new IllegalArgumentException("ERR_NAME_CANT_BE_BLANK_OR_EMPTY");
    }
    nameOfIngredientTofind =
        nameOfIngredientTofind.substring(0, 1).toUpperCase()
            + nameOfIngredientTofind.substring(1, nameOfIngredientTofind.length()).toLowerCase();
    if (this.ingredientMap.containsKey(nameOfIngredientTofind)) {
      System.out.println("\nThe ingredient existes in foodstorage");
      System.out.println(
          "Name: " + this.ingredientMap.get(nameOfIngredientTofind).getIngredientName());
      System.out.println(
          "Price: " + this.ingredientMap.get(nameOfIngredientTofind).getIngredientPrice());
      System.out.println(
          "Amount: " + this.ingredientMap.get(nameOfIngredientTofind).getIngredientAmout());
      System.out.println(
          "Measurment: "
              + this.ingredientMap.get(nameOfIngredientTofind).getIngredientMeasurmentmentType());
      System.out.println(
          "Date of Expire: "
              + this.ingredientMap.get(nameOfIngredientTofind).getIngredientExpireDate());

    } else {
      System.out.println("\nThe ingredient doesnt exist");
    }
  }

  /**
   * Uses a specified amount of an ingredient if it exists in the storage.
   *
   * @param nameOfIngredientToUse the name of the ingredient to use
   * @param amountOfIngredientToUse the amount of the ingredient to use
   * @throws IllegalArgumentException if the amount to use is less than or equal to 0
   * @throws IllegalArgumentException if the amount to use is greater than the amount in storage
   */
  public void useIngredientExitstenInStorage(
      String nameOfIngredientToUse, double amountOfIngredientToUse) {
    if (nameOfIngredientToUse.isBlank()) {
      throw new IllegalArgumentException("ERR_NAME_CANT_BE_BLANK_OR_EMPTY");
    }
    if (amountOfIngredientToUse <= 0) {
      throw new IllegalArgumentException("ERR_NAME_CANT_BE_BLANK_OR_EMPTY");
    }

    nameOfIngredientToUse =
        nameOfIngredientToUse.substring(0, 1).toUpperCase()
            + nameOfIngredientToUse.substring(1, nameOfIngredientToUse.length()).toLowerCase();
    if (this.ingredientMap.containsKey(nameOfIngredientToUse)) {
      if (amountOfIngredientToUse <= 0) {
        throw new IllegalArgumentException("ERR_AMOUNT_OF_USE_I_NEGATIVE_OR_0");
      } else if (amountOfIngredientToUse
          > this.ingredientMap.get(nameOfIngredientToUse).getIngredientAmout()) {
        throw new IllegalArgumentException(
            "ERR_AMOUNT_OF_USE_IS_HIGHER_THAT_EXISTED_AMOUNT_IN_STORAGE");
      } else {
        this.ingredientMap.get(nameOfIngredientToUse).useIngredientAmount(amountOfIngredientToUse);
      }
    } else {
      System.out.println("\nThe ingredient doesnt exist");
    }
  }

  /**
   * Checks the size of the storage.
   *
   * @return the number of ingredients in the storage
   */
  public int getFoodStorageSize() {
    return this.ingredientMap.size();
  }

  /**
   * Checks the amount of a specific ingredient in the storage.
   *
   * @param nameOfIngredientTofindAmount the name of the ingredient to find the amount of
   * @return the amount of the ingredient if it exists, or 0 if it does not exist
   */
  public double checkIngredientAmountInStorage(String nameOfIngredientTofindAmount) {
    if (nameOfIngredientTofindAmount.isBlank()) {
      throw new IllegalArgumentException("ERR_NAME_CANT_BE_BLANK_OR_EMPTY");
    }
    nameOfIngredientTofindAmount =
        nameOfIngredientTofindAmount.substring(0, 1).toUpperCase()
            + nameOfIngredientTofindAmount
                .substring(1, nameOfIngredientTofindAmount.length())
                .toLowerCase();
    if (this.ingredientMap.containsKey(nameOfIngredientTofindAmount)) {
      return this.ingredientMap.get(nameOfIngredientTofindAmount).getIngredientAmout();
    } else {
      System.out.println("\nThe ingredient doesnt exist");
    }
    return 0;
  }

  /**
   * Checks if a given ingredient is present in the storage.
   *
   * @param ingredientNameChecker the name of the ingredient to check
   * @return true if the ingredient is present in the storage, false otherwise
   * @throws IllegalArgumentException if the ingredient name is blank or empty
   */
  public boolean checkIfIngredientInStorage(String ingredientNameChecker) {
    if (ingredientNameChecker.isBlank()) {
      throw new IllegalArgumentException("ERR_NAME_CANT_BE_BLANK_OR_EMPTY");
    }
    if (this.ingredientMap.containsKey(ingredientNameChecker) == true) {
      // System.out.println(ingredientNameChecker + ": " + "is in the fridge with this amount "+
      // "("+this.ingredientMap.get(ingredientNameChecker).getIngredientAmout()+"
      // "+this.ingredientMap.get(ingredientNameChecker).getIngredientMeasurmentmentType()+")");
      // this.ingredientMap.get(ingredientNameChecker).getIngredientAmout();
      return true;
    }
    return false;
    // else{
    //     System.out.println(ingredientNameChecker + ": " + "Dosent exist in food storage");
    // }
  }

  // public HashMap<String,Double> getAllIngredientsAndAmount(String
  // recipeIngredientFoodStorageCheck){
  //     HashMap<String,Double> recipeIngredientFoodStorageCheck = new HashMap<>();
  //     for (String ingredientKey: this.ingredientMap. ) {
  //         recipeIngredientFoodStorageCheck.put(ingredientKey, ingredientKey.se);
  //     }
  // }
}
