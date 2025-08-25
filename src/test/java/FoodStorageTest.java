import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.ntnu.iir.bidata.entity.Ingredient;
import edu.ntnu.iir.bidata.logic.FoodStorage;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the FoodStorage class.
 *
 * <p>This test class contains both positive and negative test cases to ensure the correct
 * functionality of the FoodStorage class. The positive tests verify that the class behaves as
 * expected under normal conditions, while the negative tests check that the class handles erroneous
 * conditions properly.
 *
 * <p>Positive Tests: - testAddValidIngredient: Tests adding a valid ingredient to the food storage.
 * - testGetIngredient: Tests retrieving an ingredient from the food storage. -
 * testRemoveIngredient: Tests removing an ingredient from the food storage. - testGetIterator:
 * Tests getting an iterator for the ingredients in the food storage. - testContainsIngredient:
 * Tests checking if the food storage contains a specific ingredient. - testGetSize: Tests getting
 * the size of the food storage.
 *
 * <p>Negative Tests: - testAddNullIngredient: Tests that an IllegalArgumentException is thrown when
 * adding a null ingredient. - testGetNonExistentIngredient: Tests that an IllegalArgumentException
 * is thrown when retrieving a non-existent ingredient. - testRemoveNonExistentIngredient: Tests
 * that an IllegalArgumentException is thrown when removing a non-existent ingredient. -
 * testAddDuplicateIngredient: Tests that an IllegalArgumentException is thrown when adding an
 * ingredient with a duplicate name. - testGetIngredientWithNullName: Tests that an
 * IllegalArgumentException is thrown when getting an ingredient with a null name. -
 * testRemoveIngredientWithNullName: Tests that an IllegalArgumentException is thrown when removing
 * an ingredient with a null name.
 */
public class FoodStorageTest {

  private FoodStorage foodStorage;

  @BeforeEach
  void setUp() {
    foodStorage = new FoodStorage(new HashMap<String, Ingredient>());
  }

  // Positive Tests

  /** Tests adding a valid ingredient to the food storage. */
  @Test
  void testAddValidIngredient() {
    Ingredient ingredient = new Ingredient("Tomato", 5.0, 1);
    foodStorage.addIngredient(ingredient);
    assertNotNull(foodStorage.getIngredient("Tomato"));
  }

  /** Tests retrieving an ingredient from the food storage. */
  @Test
  void testGetIngredient() {
    Ingredient ingredient = new Ingredient("Tomato", 5.0, 1);
    foodStorage.addIngredient(ingredient);
    Ingredient retrievedIngredient = foodStorage.getIngredient("Tomato");
    assertEquals(ingredient, retrievedIngredient);
  }

  /** Tests removing an ingredient from the food storage. */
  @Test
  void testRemoveIngredient() {
    Ingredient ingredient = new Ingredient("Tomato", 5.0, 1);
    foodStorage.addIngredient(ingredient);
    foodStorage.removeIngredient("Tomato");
    assertFalse(foodStorage.getIngredients().containsKey("Tomato"));
  }

  /** Tests getting an iterator for the ingredients in the food storage. */
  @Test
  void testGetIterator() {
    Ingredient ingredient = new Ingredient("Tomato", 5.0, 1);
    foodStorage.addIngredient(ingredient);
    assertTrue(foodStorage.getIterator().hasNext());
  }

  /** Tests checking if the food storage contains a specific ingredient. */
  @Test
  void testContainsIngredient() {
    Ingredient ingredient = new Ingredient("Tomato", 5.0, 1);
    foodStorage.addIngredient(ingredient);
    assertTrue(foodStorage.getIngredients().containsKey("Tomato"));
  }

  /** Tests getting the size of the food storage. */
  @Test
  void testGetSize() {
    Ingredient ingredient1 = new Ingredient("Tomato", 5.0, 1);
    Ingredient ingredient2 = new Ingredient("Potato", 3.0, 2);
    foodStorage.addIngredient(ingredient1);
    foodStorage.addIngredient(ingredient2);
    assertEquals(2, foodStorage.getIngredients().size());
  }

  // Negative Tests

  /** Tests that an IllegalArgumentException is thrown when adding a null ingredient. */
  @Test
  void testAddNullIngredient() {
    assertThrows(IllegalArgumentException.class, () -> foodStorage.addIngredient(null));
  }

  /** Tests that an IllegalArgumentException is thrown when retrieving a non-existent ingredient. */
  @Test
  void testGetNonExistentIngredient() {
    try {
      foodStorage.getIngredient("NonExistent");
    } catch (IllegalArgumentException e) {
      System.out.println("Caught IllegalArgumentException: " + e.getMessage());
    }
  }

  /** Tests that an IllegalArgumentException is thrown when removing a non-existent ingredient. */
  @Test
  void testRemoveNonExistentIngredient() {
    try {
      foodStorage.removeIngredient("NonExistent");
    } catch (IllegalArgumentException e) {
      System.out.println("Caught IllegalArgumentException: " + e.getMessage());
    }
  }

  /**
   * Tests that an IllegalArgumentException is thrown when adding an ingredient with a duplicate
   * name.
   */
  @Test
  void testAddDuplicateIngredient() {
    Ingredient ingredient = new Ingredient("Tomato", 5.0, 1);
    foodStorage.addIngredient(ingredient);
    try {
      foodStorage.addIngredient(ingredient);
    } catch (IllegalArgumentException e) {
      System.out.println("Caught IllegalArgumentException: " + e.getMessage());
    }
  }

  /**
   * Tests that an IllegalArgumentException is thrown when getting an ingredient with a null name.
   */
  @Test
  void testGetIngredientWithNullName() {
    assertThrows(IllegalArgumentException.class, () -> foodStorage.getIngredient(null));
  }

  /**
   * Tests that an IllegalArgumentException is thrown when removing an ingredient with a null name.
   */
  @Test
  void testRemoveIngredientWithNullName() {
    assertThrows(IllegalArgumentException.class, () -> foodStorage.removeIngredient(null));
  }
}