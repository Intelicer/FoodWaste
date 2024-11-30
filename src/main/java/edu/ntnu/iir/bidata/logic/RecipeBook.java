package edu.ntnu.iir.bidata.logic;

import edu.ntnu.iir.bidata.entity.Recipe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * The RecipeBook class represents a collection of recipes. It provides methods
 * to add recipes and
 * display all recipes in the recipe book. The recipes are stored in a HashMap
 * with the recipe name
 * as the key and the Recipe object as the value.
 *
 * <p>Usage example:
 *
 * <pre>{@code
 * RecipeBook recipeBook = new RecipeBook();
 * Recipe recipe = new Recipe("Pasta", "Delicious pasta recipe", ingredients, ingredientAmounts);
 * recipeBook.addRecipe(recipe);
 * recipeBook.displayRecipeBook();
 * }</pre>
 *
 * <p>Note: This class depends on the FoodWasteApplicationRespond and Recipe classes.
 *
 * @see Recipe
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class RecipeBook {

  // Creating HashMap for Ingredients
  private HashMap<String, Recipe> recipeBook = new HashMap<>();







  
  /**
   * Adds a recipe to the recipe book.
   *
   * @param recipe the Recipe object to be added to the recipe book
   */
  public void addRecipe(Recipe recipe) { // ^ Test this
    String recipeName = recipe.getName();
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


  public Map<String, Recipe> getRecipes(){
    return this.recipeBook;
  }



  public int getFoodStorageSize() {
    return this.recipeBook.size();
  }

  /**
   * Retrieves a recipe by its name.
   *
   * @param recipeName the name of the recipe to retrieve
   * @return the Recipe object if found, or null if not found
   */
  public Recipe getRecipe(String recipeName) {
    if (recipeName.isBlank()) {
      throw new IllegalArgumentException("ERR: Name cant be empty or blank.");
    }
    if (recipeBook.containsKey(recipeName)) {
      return recipeBook.get(recipeName);
    }
    return null;
  }

}
