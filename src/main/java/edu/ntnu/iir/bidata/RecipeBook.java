package edu.ntnu.iir.bidata;

import java.util.HashMap;
import java.util.Iterator;

/**
 * The RecipeBook class represents a collection of recipes. It provides methods to add recipes and
 * display all recipes in the recipe book. The recipes are stored in a HashMap with the recipe name
 * as the key and the Recipe object as the value.
 *
 * <p>Usage example:
 *
 * <pre>{@code
 * RecipeBook recipeBook = new RecipeBook();
 * Recipe recipe = new Recipe("Pasta", "Delicious pasta recipe", ingredients, ingredientAmounts);
 * recipeBook.addRecipe(recipe);
 * recipeBook.displayAllRecipes();
 * }</pre>
 *
 * <p>Note: This class depends on the FoodWasteSystemPrints and Recipe classes.
 *
 * @see Recipe
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class RecipeBook {
  private HashMap<String, Recipe> recipeBookMap; // Creating HashMap for Ingredients
  private HashMap<String, Double> ingredientsCheckMap; // Creating HashMap for Ingredients
  private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();

  public RecipeBook() {
    this.recipeBookMap = new HashMap<>();
  }

  /**
   * Adds a recipe to the recipe book.
   *
   * @param recipe the Recipe object to be added to the recipe book
   */
  public void addRecipe(Recipe recipe) { // ^ Test this
    String recipeName = recipe.getRecipeName();
    this.recipeBookMap.put(recipeName, recipe);
  }

  /**
   * Displays all recipes in the recipe book.
   *
   * <p>This method iterates through the recipeBookMap and prints out the details of each recipe,
   * including the recipe name, description, and ingredients with their amounts.
   *
   * <p>The ingredients and their amounts are printed in the order they are stored in the recipe.
   */
  public void displayAllRecipeInBook() {
    this.recipeBookMap.forEach(
        (recipeName, recipe) -> { // lambda
          System.out.println("\n");

          foodWasteSystemPrints.userDisplayRecipeBook();
          System.out.println("Name: " + recipe.getRecipeName());
          System.out.println("Description: " + recipe.getRecipeDescription());
          System.out.println("Instructions: " + recipe.getrecipeInstructions());

          Iterator<String> ingredientsNameIterator = recipe.getRecipeIngredients().iterator();
          Iterator<Double> ingredientsAmountIterator =
              recipe.getRecipeIngredientsAmount().iterator();

          System.out.println("Ingreadients:");
          while (ingredientsNameIterator.hasNext()) {
            System.out.println(
                ingredientsNameIterator.next() + " : " + ingredientsAmountIterator.next());
          }
        });
  }

  /**
   * Retrieves and prints the details of a specific recipe from the recipe book. The recipe name is
   * formatted to have the first letter capitalized and the rest in lowercase. If the recipe is
   * found, its name, description, instructions, and ingredients are printed. The ingredients are
   * stored in the provided ingredientsCheckMap and the class-level ingredientsCheckMap.
   *
   * @param nameOfRecipeToSearchAfter The name of the recipe to search for.
   * @param ingredientsCheckMapScope A map to store the ingredients and their amounts for the scope
   *     of this method.
   */
  public void getASpecificRecipe(
      String nameOfRecipeToSearchAfter,
      HashMap<String, Double> ingredientsCheckMapScope) { // Done //^ Test this
    // ingredientsCheckMap is for the scope & this.ingredientsCheckMap is the variable at the start
    // of the class
    nameOfRecipeToSearchAfter =
        nameOfRecipeToSearchAfter.substring(0, 1).toUpperCase()
            + nameOfRecipeToSearchAfter
                .substring(1, nameOfRecipeToSearchAfter.length())
                .toLowerCase();

    this.ingredientsCheckMap = new HashMap<>();
    if (this.recipeBookMap != null) {
      System.out.println(
          "Name: " + this.recipeBookMap.get(nameOfRecipeToSearchAfter).getRecipeName());
      System.out.println(
          "Description: " + this.recipeBookMap.get(nameOfRecipeToSearchAfter).getRecipeName());
      System.out.println(
          "Instructions: " + this.recipeBookMap.get(nameOfRecipeToSearchAfter).getRecipeName());

      Iterator<String> ingredientsNameIterator =
          this.recipeBookMap.get(nameOfRecipeToSearchAfter).getRecipeIngredients().iterator();
      Iterator<Double> ingredientsAmountIterator =
          this.recipeBookMap.get(nameOfRecipeToSearchAfter).getRecipeIngredientsAmount().iterator();

      System.out.println("Ingredients:");
      while (ingredientsNameIterator.hasNext() || ingredientsAmountIterator.hasNext()) {
        ingredientsCheckMap.put(ingredientsNameIterator.next(), ingredientsAmountIterator.next());
      }
      System.out.println(ingredientsCheckMap);
      while (ingredientsNameIterator.hasNext() || ingredientsAmountIterator.hasNext()) {
        this.ingredientsCheckMap.put(
            ingredientsNameIterator.next(), ingredientsAmountIterator.next());
      }
    } else {
      System.out.println("Recipe Book is empty.");
    }
  }

  /**
   * Checks if a recipe with the given name exists in the recipe book.
   *
   * @param nameOfRecipeToSearchAfter the name of the recipe to search for
   * @return true if the recipe exists in the recipe book, false otherwise
   * @throws IllegalArgumentException if the provided recipe name is blank
   */
  public boolean getExistenceOfAnKey(String nameOfRecipeToSearchAfter) { // ^ Test this
    if (nameOfRecipeToSearchAfter.isBlank()) {
      throw new IllegalArgumentException("ERR_GET_EXISTENCE_OF_AN_KEY");
    }

    if (this.recipeBookMap.containsKey(nameOfRecipeToSearchAfter)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Retrieves the map of checked ingredients.
   *
   * <p>This method returns a map containing the ingredients that have been checked. The map's keys
   * are the ingredient names, and the values are the corresponding amounts.
   *
   * @return a HashMap containing the checked ingredients and their amounts
   */
  public HashMap<String, Double> getCheckedMap() {
    return this.ingredientsCheckMap;
  }
}
