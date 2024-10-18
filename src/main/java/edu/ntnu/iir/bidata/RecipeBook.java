package edu.ntnu.iir.bidata;

import java.util.HashMap;
import java.util.Iterator;
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
 * 
 * 
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
*/



public class RecipeBook {
    private HashMap<String, Recipe> recipeBookMap; // Creating HashMap for Ingredients
    private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();


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
     * 
     * This method iterates through the recipeBookMap and prints out the details
     * of each recipe, including the recipe name, description, and ingredients with their amounts.
     * 
     * The ingredients and their amounts are printed in the order they are stored in the recipe.
     */
    public void displayAllRecipeInBook() {
        this.recipeBookMap.forEach((recipeName, recipe) -> { // lambda
            System.out.println("\n");


            foodWasteSystemPrints.userDisplayRecipeBook();
            System.out.println("Description: "+recipe.getRecipeDescription());
            System.out.println("Instructions: "+recipe.getRecipeDescription());
           
            Iterator<String> ingredientsNameIterator = recipe.getRecipeIngredients().iterator();
            Iterator<Double> ingredientsAmountIterator = recipe.getRecipeIngredientsAmount().iterator();

            System.out.println("Ingreadients:");
            while (ingredientsNameIterator.hasNext()) {
                System.out.println(ingredientsNameIterator.next() +" : " +ingredientsAmountIterator.next());
            }
        });
    }


    public void getRecipeIngredientWithAmount(){
        this.recipeBookMap.forEach((recipeName, recipe) -> { // lambda
            System.out.println("\n");
            Iterator<String> ingredientsNameIterator = recipe.getRecipeIngredients().iterator();
            Iterator<Double> ingredientsAmountIterator = recipe.getRecipeIngredientsAmount().iterator();

            System.out.println("Ingreadients:");
            while (ingredientsNameIterator.hasNext()) {
                System.out.println(ingredientsNameIterator.next() +" : " +ingredientsAmountIterator.next());
            }
        });
    }




}
