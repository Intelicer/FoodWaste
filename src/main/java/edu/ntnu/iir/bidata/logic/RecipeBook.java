package edu.ntnu.iir.bidata.logic;

import edu.ntnu.iir.bidata.entity.Recipe;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * The RecipeBook class represents a collection of recipes. It provides methods
 * to add recipes and
 * display all recipes in the recipe book. The recipes are stored in a Map
 * with the recipe name
 * as the key and the Recipe object as the value.
 *
 * <p>Usage example:
 *
 * <pre>{@code
 * RecipeBook recipeBook = new RecipeBook(new HashMap<>());
 * Recipe recipe = new Recipe("Pasta", "Delicious pasta recipe", ingredients, ingredientAmounts);
 * recipeBook.addRecipe(recipe);
 * recipeBook.displayRecipeBook();
 * }</pre>
 *
 * <p>Note: This class depends on the FoodWasteApplicationRespond and Recipe classes.
 *
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class RecipeBook {

  // Creating Map for Ingredients
  private final Map<String, Recipe> recipeBook;

  /**
   * Constructs a RecipeBook with the specified map of recipes.
   *
   * @param recipeBook the map of recipes to initialize the recipe book with
   */
  public RecipeBook(Map<String, Recipe> recipeBook) {
    this.recipeBook = recipeBook;
  }

  /**
   * Adds a recipe to the recipe book.
   *
   * @param recipe the Recipe object to be added to the recipe book
   */
  public void addRecipe(Recipe recipe) {
    validateRecipe(recipe);
    String recipeName = recipe.getRecipeName();
    recipeBook.put(recipeName, recipe);
  }

  /**
   * Displays all recipes in the recipe book.
   *
   * <p>This method iterates through the recipeBookMap and prints out the details of
   * each recipe,
   * including the recipe name, description, and ingredients with their amounts.
   *
   * <p>The ingredients and their amounts are printed in the order they are stored in
   * the recipe.
   */
  public Iterator<Recipe> getIterator() {
    return recipeBook.values().iterator();
  }

  public Map<String, Recipe> getRecipes() {
    return Collections.unmodifiableMap(this.recipeBook);
  }

  public int getRecipeBookSize() {
    return this.recipeBook.size();
  }

  /**
   * Removes a recipe from the recipe book by its name.
   *
   * @param recipeName the name of the recipe to remove
   * @throws IllegalArgumentException if the recipe name is blank or empty
   */
  public void removeRecipe(String recipeName) {
    validateRecipeName(recipeName);
    if (recipeBook.containsKey(recipeName)) {
      recipeBook.remove(recipeName);
    }
  }

  /**
   * Retrieves a recipe by its name.
   *
   * @param recipeName the name of the recipe to retrieve
   * @return the Recipe object if found, or null if not found
  */
  public Recipe getRecipe(String recipeName) {
    validateRecipeName(recipeName);
    if (recipeBook.containsKey(recipeName)) {
      return recipeBook.get(recipeName);
    }
    return null;
  }



  /**
   * Validates the specified ingredient.
   *
   * @param ingredient the ingredient to validate
   * @throws IllegalArgumentException if the ingredient is null or invalid
   */
  private void validateRecipe(Recipe recipe) {
    if (recipe == null) {
      throw new IllegalArgumentException("Invalid recipe cant be added");
    }
  }

  /**
   * Validates the specified recipe name.
   *
   * @param recipeName the recipe name to validate
   * @throws IllegalArgumentException if the recipe name is blank, empty, or null
   */
  private void validateRecipeName(String recipeName) {
    if (recipeName == null || recipeName.isBlank()) {
      throw new IllegalArgumentException("ERR: Recipe name cant be blank or empty");
    }
  }
}
