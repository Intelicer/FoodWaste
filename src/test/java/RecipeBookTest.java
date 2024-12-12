import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.ntnu.iir.bidata.entity.Ingredient;
import edu.ntnu.iir.bidata.entity.Recipe;
import edu.ntnu.iir.bidata.logic.RecipeBook;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Unit tests for the RecipeBook class. */
class RecipeBookTest {

  private RecipeBook recipeBook;
  private Recipe recipe1;
  private Recipe recipe2;

  /** Sets up the test environment before each test. */
  @BeforeEach
  void setUp() {
    Map<String, Recipe> recipes = new HashMap<>();
    recipeBook = new RecipeBook(recipes);

    HashMap<String, Ingredient> recipe1Ingredients = new HashMap<>();
    recipe1Ingredients.put("Tomato", new Ingredient("Tomato", 2, 0));
    recipe1Ingredients.put("Onion", new Ingredient("Onion", 1, 0));
    recipe1Ingredients.put("Garlic", new Ingredient("Garlic", 3, 0));
    recipe1Ingredients.put("Chicken", new Ingredient("Chicken", 500, 1));

    recipe1 =
        new Recipe(
            "Pasta", "Delicious pasta recipe", "Boil water, add pasta", 4, recipe1Ingredients);
    recipe2 =
        new Recipe("Salad", "Fresh and healthy salad", "Mix ingredients", 2, recipe1Ingredients);
  }

  // ** Positive Tests **

  /** Tests adding a recipe to the RecipeBook. */
  @Test
  void testAddRecipePositive() {
    recipeBook.addRecipe(recipe1);
    assertEquals(
        1,
        recipeBook.getRecipeBookSize(),
        "RecipeBook size should increase after adding a recipe.");
    assertNotNull(recipeBook.getRecipe("Pasta"), "Added recipe should exist in the RecipeBook.");
  }

  /** Tests removing a recipe from the RecipeBook. */
  @Test
  void testRemoveRecipePositive() {
    recipeBook.addRecipe(recipe1);
    recipeBook.removeRecipe("Pasta");
    assertEquals(
        0,
        recipeBook.getRecipeBookSize(),
        "RecipeBook size should decrease after removing a recipe.");
    assertNull(
        recipeBook.getRecipe("Pasta"), "Removed recipe should no longer exist in the RecipeBook.");
  }

  /** Tests fetching a recipe from the RecipeBook. */
  @Test
  void testGetRecipePositive() {
    recipeBook.addRecipe(recipe1);
    Recipe fetchedRecipe = recipeBook.getRecipe("Pasta");
    assertNotNull(fetchedRecipe, "Fetching an existing recipe should return a non-null object.");
    assertEquals(
        "Pasta", fetchedRecipe.getRecipeName(), "Fetched recipe should match the added recipe.");
  }

  /** Tests getting an iterator for the recipes in the RecipeBook. */
  @Test
  void testGetIteratorPositive() {
    recipeBook.addRecipe(recipe1);
    recipeBook.addRecipe(recipe2);
    Iterator<Recipe> iterator = recipeBook.getIterator();
    assertNotNull(iterator, "Iterator should not be null.");
    assertTrue(iterator.hasNext(), "Iterator should have elements.");
  }

  // ** Negative Tests **

  /** Tests that adding a null recipe throws an IllegalArgumentException. */
  @Test
  void testAddNullRecipeThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> recipeBook.addRecipe(null));
  }

  /** Tests that fetching a non-existent recipe throws an IllegalArgumentException. */
  @Test
  void testGetNonExistentRecipeThrowsException() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              recipeBook.getRecipe("NonExistent");
            });
    System.out.println("Caught IllegalArgumentException: " + thrown.getMessage());
  }

  /** Tests that removing a non-existent recipe throws an IllegalArgumentException. */
  @Test
  void testRemoveNonExistentRecipeThrowsException() {
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              recipeBook.removeRecipe("NonExistent");
            });
    System.out.println("Caught IllegalArgumentException: " + thrown.getMessage());
  }
}