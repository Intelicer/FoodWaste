package edu.ntnu.iir.bidata;

import java.util.ArrayList;

/**
 * The Recipe class represents a recipe with a name, description, list of ingredients, and their
 * corresponding amounts. It provides methods to retrieve these details.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * List<String> ingredients = Arrays.asList("Flour", "Sugar", "Eggs");
 * List<Double> amounts = Arrays.asList(2.0, 1.5, 3.0);
 * Recipe recipe = new Recipe("Cake", "A delicious cake recipe", ingredients, amounts);
 *
 * String name = recipe.getRecipeName(); // Returns "Cake"
 * String description = recipe.getRecipeDescription(); // Returns "A delicious cake recipe"
 * List<String> recipeIngredients = recipe.getRecipeIngredients(); // Returns ["Flour", "Sugar", "Eggs"]
 * List<Double> recipeAmounts = recipe.getRecipeIngredientsAmount(); // Returns [2.0, 1.5, 3.0]
 * }</pre>
 *
 * <p>Attributes:
 *
 * <ul>
 *   <li>{@code recipeName} - The name of the recipe.
 *   <li>{@code recipeDescription} - A brief description of the recipe.
 *   <li>{@code ingredientsForRecipe} - A list of ingredients required for the recipe.
 *   <li>{@code ingredientAmounts} - A list of amounts corresponding to each ingredient in the
 *       recipe.
 * </ul>
 *
 * <p>Methods:
 *
 * <ul>
 *   <li>{@link #getRecipeName()} - Returns the name of the recipe.
 *   <li>{@link #getRecipeDescription()} - Returns a brief description of the recipe.
 *   <li>{@link #getRecipeIngredients()} - Returns a list of ingredients required for the recipe.
 *   <li>{@link #getRecipeIngredientsAmount()} - Returns a list of amounts corresponding to each
 *       ingredient in the recipe.
 * </ul>
 *
 * @see java.util.List
 * @see java.util.ArrayList
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class Recipe {

  private String recipeName; // The name of the recipe.
  private String recipeDescription; // A brief description of the recipe.
  private String recipeInstructions; // A brief Instructions of the recipe.
  private ArrayList<String>
      recipeIngredientsToMakeTheRecipe; // A list of ingredients required for the recipe.
  private ArrayList<Double>
      recipeIngredientAmounts; // A list of amounts corresponding to each ingredient in the recipe.

  /**
   * Constructs a new Recipe with the specified name, description, ingredients, and their amounts.
   *
   * @param recipeName The name of the recipe.
   * @param recipeDescription A brief description of the recipe.
   * @param userIngredientsToMakeTheRecipe A list of ingredients required for the recipe.
   * @param ingredientAmounts A list of amounts corresponding to each ingredient in the recipe.
   */
  // public Recipe(String recipeName, String recipeDescription, String recipeInstructions
  // ,ArrayList<String> recipeIngredientsToMakeTheRecipe, ArrayList<Double> recipeIngredientAmounts,
  // ) {
  public Recipe(
      String recipeName,
      String recipeDescription,
      String recipeInstructions,
      ArrayList<String> recipeIngredientsToMakeTheRecipe,
      ArrayList<Double> recipeIngredientAmounts) { // ^ Test this
    if ((recipeName.isBlank())) {
      throw new IllegalArgumentException("ERR_INGREDIENT_NAME_BE_EMPTY_OR_BLANK");
    }
    if ((recipeDescription.isBlank())) {
      throw new IllegalArgumentException("ERR_INGREDIENT_NAME_BE_EMPTY_OR_BLANK");
    }
    if ((recipeInstructions.isBlank())) {
      throw new IllegalArgumentException("ERR_INGREDIENT_INSTUCTION_BE_EMPTY_OR_BLANK");
    }

    if (recipeIngredientsToMakeTheRecipe == null || recipeIngredientsToMakeTheRecipe.isEmpty()) {
      throw new IllegalArgumentException("ERR_INGREDIENTS_LIST_BE_NULL_OR_EMPTY");
    }
    if (recipeIngredientAmounts == null || recipeIngredientAmounts.isEmpty()) {
      throw new IllegalArgumentException("ERR_INGREDIENT_AMOUNTS_LIST_BE_NULL_OR_EMPTY");
    }
    if (recipeIngredientsToMakeTheRecipe.size() != recipeIngredientAmounts.size()) {
      throw new IllegalArgumentException("ERR_INGREDIENTS_AND_AMOUNTS_SIZE_MISMATCH");
    }
    this.recipeName =
        recipeName.substring(0, 1).toUpperCase()
            + recipeName.substring(1, recipeName.length()).toLowerCase();
    this.recipeDescription =
        recipeDescription.substring(0, 1).toUpperCase()
            + recipeDescription.substring(1, recipeDescription.length()).toLowerCase();
    ;
    this.recipeInstructions =
        recipeInstructions.substring(0, 1).toUpperCase()
            + recipeInstructions.substring(1, recipeName.length()).toLowerCase();
    ;
    this.recipeIngredientsToMakeTheRecipe = recipeIngredientsToMakeTheRecipe;
    this.recipeIngredientAmounts = recipeIngredientAmounts;
  }

  /**
   * Returns the name of the recipe.
   *
   * @return The name of the recipe.
   */
  public String getRecipeName() {
    return this.recipeName;
  }

  /**
   * Returns a brief description of the recipe.
   *
   * @return A brief description of the recipe.
   */
  public String getRecipeDescription() {
    return this.recipeDescription;
  }

  /**
   * Returns a brief recipe Instructions.
   *
   * @return A brief recipe Instruction.
   */
  public String getrecipeInstructions() {
    return this.recipeInstructions;
  }

  /**
   * Returns a list of ingredients required for the recipe.
   *
   * @return A list of ingredients required for the recipe.
   */
  public ArrayList<String> getRecipeIngredients() { // List contain String only
    return this.recipeIngredientsToMakeTheRecipe;
  }

  /**
   * Returns a list of amounts corresponding to each ingredient in the recipe.
   *
   * @return A list of amounts corresponding to each ingredient in the recipe.
   */
  public ArrayList<Double> getRecipeIngredientsAmount() { // List contain Double only
    return this.recipeIngredientAmounts;
  }
}