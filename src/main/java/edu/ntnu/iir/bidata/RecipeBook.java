/**
 * The RecipeBook class represents a collection of recipes.
 * It provides methods to add recipes and display all recipes in the recipe book.
 * The recipes are stored in a HashMap with the recipe name as the key and the Recipe object as the value.
 * 
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * RecipeBook recipeBook = new RecipeBook();
 * Recipe recipe = new Recipe("Pasta", "Delicious pasta recipe", ingredients, ingredientAmounts);
 * recipeBook.addRecipe(recipe);
 * recipeBook.displayAllRecipes();
 * }
 * </pre>
 * 
 * <p>Note: This class depends on the FoodWasteSystemPrints and Recipe classes.</p>
 * 
 * @see Recipe
*/
package edu.ntnu.iir.bidata;

import java.util.HashMap;

public class RecipeBook {
    private HashMap<String, Recipe> recipeBookMap; // Creating HashMap for Ingredients

    public RecipeBook() {
        this.recipeBookMap = new HashMap<>();
    }

    /**
     * Adds a recipe to the recipe book.
     *
     * @param recipe the Recipe object to be added to the recipe book
     */
    public void addRecipe(Recipe recipe) {
        String recipeName = recipe.getRecipeName();
        this.recipeBookMap.put(recipeName, recipe);    
    }

    /**
     * Displays all recipes in the recipe book.
     * This method iterates through the recipeBookMap and prints out the details of each recipe.
     * For each recipe, it prints the recipe name, description, ingredients, and ingredient amounts.
     */
    public void displayAllRecipes() {
        this.recipeBookMap.forEach((recipeName, recipe) -> { // lambda
            System.out.println("\n");
            System.out.println(recipe.getRecipeName());
            System.out.println(recipe.getRecipeDescription());
            System.out.println(recipe.getRecipeIngredients());
            System.out.println(recipe.getRecipeIngredientsAmount());
        });
    }
}
