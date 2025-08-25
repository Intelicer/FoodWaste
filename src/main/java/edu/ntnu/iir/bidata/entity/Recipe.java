package edu.ntnu.iir.bidata.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
/**
 * Represents a recipe with a name, description, instructions, servings, and ingredients.
 * This class provides methods to access the recipe details and ensures that the recipe
 * details are valid upon creation.
 * 
 * <p>Each recipe has the following attributes:
 * <ul>
 *   <li>recipeName: The name of the recipe.</li>
 *   <li>recipeDescription: A brief description of the recipe.</li>
 *   <li>recipeInstructions: Instructions for preparing the recipe.</li>
 *   <li>recipeServings: The number of servings the recipe makes.</li>
 *   <li>recipeIngredients: A map of ingredients required for the recipe.</li>
 * </ul>
 * 
 * <p>The class provides methods to retrieve these attributes and ensures that the
 * recipe details are valid upon creation.
 * 
 * <p>Example usage:
 * <pre>
 * {@code
 * Map<String, Ingredient> ingredients = new HashMap<>();
 * ingredients.put("Flour", new Ingredient("Flour", 2, "cups"));
 * Recipe recipe = new Recipe("Pancakes", "Fluffy pancakes", "Mix and cook", 4, ingredients);
 * System.out.println(recipe.getRecipeName()); // Outputs: Pancakes
 * }
 * </pre>
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */

public class Recipe {

  private String recipeName; // The name of the recipe.
  private String recipeDescription; // A brief description of the recipe.
  private String recipeInstructions; // A brief Instructions of the recipe.
  private int recipeServings; // A brief Instructions of the recipe.
  private final Map<String, Ingredient> recipeIngredients; // Collection of Ingredients


  /**
   * Constructs a new Recipe object with the specified details.
   *
   * @param recipeName the name of the recipe, must not be blank
   * @param recipeDescription the description of the recipe, must not be blank
   * @param recipeInstructions the instructions for the recipe, must not be blank
   * @param recipeServings the number of people the recipe is made for, must be greater than 0
   * @param recipeIngredients the ingredients required for the recipe, must not be empty
   * @throws IllegalArgumentException if any of the parameters are invalid
   */
  public Recipe(
      String recipeName,
      String recipeDescription,
      String recipeInstructions,
      int recipeServings,
      Map<String, Ingredient> recipeIngredients) { // ^ Test this

    if (recipeName.isBlank()) {
      throw new IllegalArgumentException("ERR: recipe name cant be blank");
    }
    if (recipeDescription.isBlank()) {
      throw new IllegalArgumentException("ERR: recipe description cant be blank");
    }
    if (recipeInstructions.isBlank()) {
      throw new IllegalArgumentException("ERR: recipe instructions cant be blank");
    }
    if (recipeServings <= 0) {
      throw new IllegalArgumentException("ERR: recipe serving cant be negative or 0");
    }
    if (recipeIngredients.size() == 0) {
      throw new IllegalArgumentException("ERR: recipe doesnt contain ingredients.");
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
            + recipeInstructions.substring(1, recipeInstructions.length()).toLowerCase();

    this.recipeServings = recipeServings;        
    this.recipeIngredients = recipeIngredients;
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
   * Returns a brief recipe Instructions.
   *
   * @return A brief recipe Instruction.
   */
  public String getRecipeInstructions() {
    return this.recipeInstructions;
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
   * Returns the number of people the recipe is made for.
   *
   * @return The number of people the recipe is made for.
   */
  public int getRecipeServing() {
    return this.recipeServings;
  }

  /**
   * Returns a list of ingredients required for the recipe.
   *
   * @return A list of ingredients required for the recipe.
  */
  public Iterator<Ingredient> getIngredientIterator() {
    return this.recipeIngredients.values().iterator();
  }


  /**
 * Returns an unmodifiable view of the ingredients required for the recipe.
 *
 * @return An unmodifiable map of ingredients required for the recipe.
 */
  public Map<String, Ingredient> getIngredients() {
    return Collections.unmodifiableMap(this.recipeIngredients);
  }





}