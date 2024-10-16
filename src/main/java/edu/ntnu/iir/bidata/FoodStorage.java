/**
 * The FoodStorage class represents a storage system for ingredients.
 * It allows adding ingredients to the storage and displaying all stored ingredients.
 * The ingredients are stored in a HashMap with the ingredient name as the key.
 * 
 * <p>This class provides methods to:
 * <ul>
 *   <li>Add an ingredient to the storage</li>
 *   <li>Display all ingredients in a tabular format</li>
 * </ul>
 * 
 * <p>Example usage:
 * <pre>
 * {@code
 * FoodStorage storage = new FoodStorage();
 * Ingredient ingredient = new Ingredient("Tomato", 5, "kg");
 * storage.addIngredient(ingredient);
 * storage.displayAllIngredients();
 * }
 * </pre>
 * 
 * <p>Note: The displayAllIngredients method currently has a placeholder for additional functionality.
 * 
 * @see Ingredient
 * @see FoodWasteSystemPrints
*/


package edu.ntnu.iir.bidata;

import java.util.HashMap;





public class FoodStorage{

    private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();

    private HashMap<String, Ingredient> ingredientMap; //Creating HashMap for Ingredients


    public FoodStorage(){
        this.ingredientMap = new HashMap<>(); //Inisilizing HashMap
    }


    /**
     * Adds an ingredient to the storage.
     * 
     * @param ingredient the ingredient to be added to the storage
    */
    public void addIngredient(Ingredient ingredient){
        String ingredientName = ingredient.getIngredientName();
        this.ingredientMap.put(ingredientName, ingredient);    
    }




    /**
     * Displays all ingredients in the food storage.
     * The ingredients are displayed in a tabular format with columns for the ingredient name and amount.
     * Each row represents an ingredient with its name and amount formatted for readability.
     * The table is enclosed within horizontal lines for better visual separation.
    */
    public void displayAllIngredients(){
        // //! | %-10s | %-8s | %4s |%n sizes
        foodWasteSystemPrints.userDisplayFoodStorage(); //Welcome Message to Application
        this.ingredientMap.forEach((ingredientName, ingredient)-> {//lamda
            System.out.printf("| %-13s | %-13s | %-16s |%n", ingredient.getIngredientName(), ingredient.getIngredientAmout()+" "+ingredient.getIngredientMeagurmentType(),"NotDoneYet");
            System.out.println("----------------------------------------------------");
        });
        

    }




    
}
