

package edu.ntnu.iir.bidata;

import java.util.ArrayList;
import java.util.List;

/**
 * The Recipe class represents a recipe with a name, description, list of ingredients, and their corresponding amounts.
 * It provides methods to retrieve these details.
 * 
 * <p>Example usage:
 * <pre>
 * {@code
 * List<String> ingredients = Arrays.asList("Flour", "Sugar", "Eggs");
 * List<Double> amounts = Arrays.asList(2.0, 1.5, 3.0);
 * Recipe recipe = new Recipe("Cake", "A delicious cake recipe", ingredients, amounts);
 * 
 * String name = recipe.getRecipeName(); // Returns "Cake"
 * String description = recipe.getRecipeDescription(); // Returns "A delicious cake recipe"
 * List<String> recipeIngredients = recipe.getRecipeIngredients(); // Returns ["Flour", "Sugar", "Eggs"]
 * List<Double> recipeAmounts = recipe.getRecipeIngredientsAmount(); // Returns [2.0, 1.5, 3.0]
 * }
 * </pre>
 * </p>
 * 
 * <p>Attributes:
 * <ul>
 *   <li>{@code recipeName} - The name of the recipe.</li>
 *   <li>{@code recipeDescription} - A brief description of the recipe.</li>
 *   <li>{@code ingredientsForRecipe} - A list of ingredients required for the recipe.</li>
 *   <li>{@code ingredientAmounts} - A list of amounts corresponding to each ingredient in the recipe.</li>
 * </ul>
 * </p>
 * 
 * <p>Methods:
 * <ul>
 *   <li>{@link #getRecipeName()} - Returns the name of the recipe.</li>
 *   <li>{@link #getRecipeDescription()} - Returns a brief description of the recipe.</li>
 *   <li>{@link #getRecipeIngredients()} - Returns a list of ingredients required for the recipe.</li>
 *   <li>{@link #getRecipeIngredientsAmount()} - Returns a list of amounts corresponding to each ingredient in the recipe.</li>
 * </ul>
 * </p>
 * 
 * @see java.util.List
 * @see java.util.ArrayList
 */
public class Recipe {

    private String recipeName; //The name of the recipe.
    private String recipeDescription; //A brief description of the recipe.
    private List<String> ingredientsForRecipe;// A list of ingredients required for the recipe.
    private List<Double> ingredientAmounts;//A list of amounts corresponding to each ingredient in the recipe.



    
    /**
     * Constructs a new Recipe with the specified name, description, ingredients, and their amounts.
     *
     * @param recipeName The name of the recipe.
     * @param recipeDescription A brief description of the recipe.
     * @param userIngredientsToMakeTheRecipe A list of ingredients required for the recipe.
     * @param ingredientAmounts A list of amounts corresponding to each ingredient in the recipe.
     */
    public Recipe(String recipeName, String recipeDescription, ArrayList<String> userIngredientsToMakeTheRecipe, List<Double> ingredientAmounts) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.ingredientsForRecipe = userIngredientsToMakeTheRecipe;
        this.ingredientAmounts = ingredientAmounts;
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
     * Returns a list of ingredients required for the recipe.
     *
     * @return A list of ingredients required for the recipe.
     */
    public List<String> getRecipeIngredients() {
        return this.ingredientsForRecipe;
    }

    /**
     * Returns a list of amounts corresponding to each ingredient in the recipe.
     *
     * @return A list of amounts corresponding to each ingredient in the recipe.
     */
    public List<Double> getRecipeIngredientsAmount() {
        return this.ingredientAmounts;
    }
}