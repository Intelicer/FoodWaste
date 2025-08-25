package edu.ntnu.iir.bidata.logic;

import edu.ntnu.iir.bidata.entity.Ingredient;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * The FoodStorage class represents a storage for ingredients.
 * It provides methods to add, retrieve, remove, and iterate over ingredients.
 * The storage is backed by a map where the keys are 
 * ingredient names and the values are Ingredient objects.
 * 
 * <p>This class ensures that ingredients are validated 
 * before being added or retrieved from the storage.
 * It also provides an unmodifiable view of the ingredients in the storage.</p>
 * 
 * <p>Usage example:</p>
 * <pre>{@code
 * Map<String, Ingredient> initialStorage = new HashMap<>();
 * FoodStorage foodStorage = new FoodStorage(initialStorage);
 * 
 * Ingredient ingredient = new Ingredient("Tomato");
 * foodStorage.addIngredient(ingredient);
 * 
 * Ingredient retrievedIngredient = foodStorage.getIngredient("Tomato");
 * 
 * Iterator<Ingredient> iterator = foodStorage.getIterator();
 * while (iterator.hasNext()) {
 *     System.out.println(iterator.next().getIngredientName());
 * }
 * 
 * Map<String, Ingredient> ingredients = foodStorage.getIngredients();
 * 
 * Ingredient removedIngredient = foodStorage.removeIngredient("Tomato");
 * }</pre>
 * 
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */


public class FoodStorage {


  private final Map<String, Ingredient> foodStorage;

  /**
   * Constructs a new FoodStorage with the specified initial storage.
   *
   * @param foodStorage the initial storage of ingredients
   */
  public FoodStorage(Map<String, Ingredient> foodStorage) {
    this.foodStorage = foodStorage;
  }

  /**
   * Adds an ingredient to the storage.
   *
   * @param ingredient the ingredient to be added
   * @throws IllegalArgumentException if the ingredient is invalid
   */
  public void addIngredient(Ingredient ingredient) {
    validateIngredient(ingredient);
    if (!this.foodStorage.containsKey(ingredient.getIngredientName())) {
      this.foodStorage.put(ingredient.getIngredientName(), ingredient);
    }
  }

  /**
   * Retrieves an ingredient from the storage by its name.
   *
   * @param ingredientName the name of the ingredient to retrieve
   * @return the ingredient with the specified name, or null if not found
   * @throws IllegalArgumentException if the ingredient name is blank, empty, or null
   */
  public Ingredient getIngredient(String ingredientName) {
    validateIngredientName(ingredientName);
    if (this.foodStorage.containsKey(ingredientName)) {
      return this.foodStorage.get(ingredientName);
    }
    return null;
  }


  /**
   * Returns an iterator over the ingredients in the storage.
   *
   * @return an iterator over the ingredients
   */
  public Iterator<Ingredient> getIterator() {
    return this.foodStorage.values().iterator();
  }

  /**
   * Returns an unmodifiable view of the ingredients in the storage.
   *
   * @return an unmodifiable map of the ingredients
   */
  public Map<String, Ingredient> getIngredients() {
    return Collections.unmodifiableMap(this.foodStorage);
  }

  /**
   * Removes an ingredient from the storage by its name.
   *
   * @param ingredientName the name of the ingredient to remove
   * @return the removed ingredient, or null if not found
   * @throws IllegalArgumentException if the ingredient name is blank, empty, or null
   */
  public Ingredient removeIngredient(String ingredientName) {
    validateIngredientName(ingredientName);
    return this.foodStorage.remove(ingredientName);
  }

  /**
   * Validates the specified ingredient.
   *
   * @param ingredient the ingredient to validate
   * @throws IllegalArgumentException if the ingredient is null or invalid
   */
  private void validateIngredient(Ingredient ingredient) {
    if (ingredient == null) {
      throw new IllegalArgumentException("Invalid ingredient cant be added");
    }
  }

  /**
   * Validates the specified ingredient name.
   *
   * @param ingredientName the ingredient name to validate
   * @throws IllegalArgumentException if the ingredient name is blank, empty, or null
   */
  private void validateIngredientName(String ingredientName) {
    if (ingredientName == null || ingredientName.isBlank()) {
      throw new IllegalArgumentException("Ingredient name can't be blank, empty or null");
    }
  }

  
}