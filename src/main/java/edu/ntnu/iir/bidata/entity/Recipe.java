package edu.ntnu.iir.bidata.entity;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents a recipe with a name, description, instructions, ingredients, and their amounts.
 */

public class Recipe {

  private String recipeName; // The name of the recipe.
  private String recipeDescription; // A brief description of the recipe.
  private String recipeInstructions; // A brief Instructions of the recipe.
  private int recipeServings; // A brief Instructions of the recipe.
  private HashMap<String, Ingredient> recipeIngredients; // Collection of Ingredients


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
      HashMap<String, Ingredient> recipeIngredients) { // ^ Test this

    if (recipeName.isBlank()) {
      throw new IllegalArgumentException("Recipe name cant be blank");
    }
    if (recipeDescription.isBlank()) {
      throw new IllegalArgumentException("Recipe description cant be blank");
    }
    if (recipeInstructions.isBlank()) {
      throw new IllegalArgumentException("Recipe instructions cant be blank");
    }
    if (recipeServings <= 0) {
      throw new IllegalArgumentException("Amount of people that can eat"
        + "the recipe cant be negative or 0");
    }
    if (recipeIngredients.size() == 0) {
      throw new IllegalArgumentException("Recipe ingredients.");
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

    this.recipeServings = recipeServings;        
    this.recipeIngredients = recipeIngredients;
  }

  /**
   * Returns the name of the recipe.
   *
   * @return The name of the recipe.
   */
  public String getName() {
    return this.recipeName;
  }

  /**
   * Returns a brief description of the recipe.
   *
   * @return A brief description of the recipe.
   */
  public String getDescription() {
    return this.recipeDescription;
  }

  /**
   * Returns a brief recipe Instructions.
   *
   * @return A brief recipe Instruction.
   */
  public String getInstructions() {
    return this.recipeInstructions;
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

  public Iterator<Ingredient> getIterator() {
    return this.recipeIngredients.values().iterator();
  }

  public Map<String, Ingredient> getRecipeIngredients() {
    return recipeIngredients;
  }





}