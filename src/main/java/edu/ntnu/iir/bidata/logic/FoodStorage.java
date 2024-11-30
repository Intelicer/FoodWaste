
package edu.ntnu.iir.bidata.logic;

import edu.ntnu.iir.bidata.entity.Ingredient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The FoodStorage class represents a storage system for ingredients.
 * It provides methods to add, display, search, and use ingredients in the storage.
 * The ingredients are stored in a HashMap with their names as keys.
 * 
 * <p>Features:
 * <ul>
 *   <li>Add ingredients to the storage</li>
 *   <li>Display all ingredients in a tabular format</li>
 *   <li>Search for an ingredient by name</li>
 *   <li>Use a specified amount of an ingredient</li>
 *   <li>Check the size of the storage</li>
 *   <li>Check the amount of a specific ingredient</li>
 *   <li>Check if a given ingredient is present in the storage</li>
 * </ul>
 */
public class FoodStorage {

  // Creating HashMap for Ingredients
  private HashMap<String, Ingredient> foodStorage = new HashMap<>(); 


  

  // Constructor to inject the HashMap dependency
  public FoodStorage() {
    this.foodStorage =  new HashMap<>();
  }

  /**
   * Adds an ingredient to the storage.
   *
   * @param ingredient the ingredient to be added to the storage
   */
  public void addIngredient(Ingredient ingredient) {
    if (ingredient == null || !ingredient.isValid()) {
      throw new IllegalArgumentException("Invalid ingredient");
    }
    String ingredientName = ingredient.getIngredientName();
    this.foodStorage.put(ingredientName, ingredient);  
  }





  /**
   * Returns an iterator over the ingredients in the food storage.
   *
   * @return an {@code Iterator<Ingredient>} over the ingredients in the food storage.
   */
  public Iterator<Ingredient> getIterator() {
    return this.foodStorage.values().iterator();
  }



  public Map<String, Ingredient> getIngredients() {
    return this.foodStorage;
  }


  

  /**
   * Checks the size of the storage.
   *
   * @return the number of ingredients in the storage
   */
  public int getFoodStorageSize() {
    return this.foodStorage.size();
  }

  
  /**
   * Retrieves an ingredient from the food storage by its name.
   *
   * @param ingredientName the name of the ingredient to retrieve
   * @return the Ingredient object associated with the given name, 
   *          or null if no such ingredient exists
  */
  public Ingredient getIngredient(String ingredientName) {
    if (ingredientName == null || ingredientName.isBlank()) {
      throw new IllegalArgumentException("Invalid ingredient name input, cant be blank");
    }
    return this.foodStorage.get(ingredientName);
  }
  





  public void removeIngredient(String ingredientName) {
    if (ingredientName == null || ingredientName.isBlank()) {
        throw new IllegalArgumentException("Invalid ingredient name input, cannot be null or blank");
    }
    this.foodStorage.remove(ingredientName);
  }


  
}
