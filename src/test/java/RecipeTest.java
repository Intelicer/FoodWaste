import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.ntnu.iir.bidata.entity.Ingredient;
import edu.ntnu.iir.bidata.entity.Recipe;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Unit tests for the Recipe class. */
class RecipeTest {

  // Positive Tests

  /** Tests the creation of a valid Recipe object. */
  @Test
  void testValidRecipeCreation() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    ingredients.put("Tomato", new Ingredient("Tomato", 5.0, 1));
    Recipe recipe = new Recipe("Pasta", "Delicious pasta", "Boil pasta and mix", 4, ingredients);
    assertEquals("Pasta", recipe.getRecipeName());
    assertEquals("Delicious pasta", recipe.getRecipeDescription());
    assertEquals("Boil pasta and mix", recipe.getRecipeInstructions());
    assertEquals(4, recipe.getRecipeServing());
    assertFalse(recipe.getIngredients().isEmpty());
  }

  /** Tests the getIngredientIterator method of the Recipe class. */
  @Test
  void testGetIngredientIterator() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    ingredients.put("Tomato", new Ingredient("Tomato", 5.0, 1));
    Recipe recipe = new Recipe("Pasta", "Delicious pasta", "Boil pasta and mix", 4, ingredients);
    assertTrue(recipe.getIngredientIterator().hasNext());
  }

  // Negative Tests

  /**
   * Tests that an IllegalArgumentException is thrown when creating a Recipe with an invalid name.
   */
  @Test
  void testInvalidRecipeName() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    ingredients.put("Tomato", new Ingredient("Tomato", 5.0, 1));
    assertThrows(
        IllegalArgumentException.class,
        () -> new Recipe("", "Description", "Instructions", 4, ingredients));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating a Recipe with an invalid
   * description.
   */
  @Test
  void testInvalidRecipeDescription() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    ingredients.put("Tomato", new Ingredient("Tomato", 5.0, 1));
    assertThrows(
        IllegalArgumentException.class,
        () -> new Recipe("Pasta", "", "Instructions", 4, ingredients));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating a Recipe with invalid
   * instructions.
   */
  @Test
  void testInvalidRecipeInstructions() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    ingredients.put("Tomato", new Ingredient("Tomato", 5.0, 1));
    assertThrows(
        IllegalArgumentException.class,
        () -> new Recipe("Pasta", "Description", "", 4, ingredients));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating a Recipe with invalid servings.
   */
  @Test
  void testInvalidRecipeServings() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    ingredients.put("Tomato", new Ingredient("Tomato", 5.0, 1));
    assertThrows(
        IllegalArgumentException.class,
        () -> new Recipe("Pasta", "Description", "Instructions", 0, ingredients));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when creating a Recipe with empty ingredients.
   */
  @Test
  void testEmptyIngredients() {
    Map<String, Ingredient> ingredients = new HashMap<>();
    assertThrows(
        IllegalArgumentException.class,
        () -> new Recipe("Pasta", "Description", "Instructions", 4, ingredients));
  }
}