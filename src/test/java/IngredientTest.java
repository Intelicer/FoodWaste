import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.ntnu.iir.bidata.entity.Ingredient;
import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class contains unit tests for the {@link Ingredient} class.
 * It tests both positive and negative scenarios to ensure the correct behavior
 * of the Ingredient class.
 * 
 * <p>
 * Positive tests include:
 * <ul>
 * <li>Creating an instance with a valid ingredient name</li>
 * <li>Creating an instance with a valid ingredient amount</li>
 * <li>Creating an instance with a valid ingredient price</li>
 * <li>Creating an instance with a valid ingredient measurement</li>
 * <li>Creating an instance with a valid ingredient expiration date</li>
 * <li>Setting a valid extra ingredient amount</li>
 * <li>Setting a valid used ingredient amount</li>
 * </ul>
 * 
 * <p>
 * Negative tests include:
 * <ul>
 * <li>Creating an instance with a negative ingredient amount</li>
 * <li>Creating an instance with a negative ingredient price</li>
 * <li>Creating an instance with an invalid measurement</li>
 * <li>Creating an instance with a null or empty expiration date</li>
 * <li>Setting a negative extra ingredient amount</li>
 * <li>Setting a negative used ingredient amount</li>
 * <li>Setting an invalid extra ingredient amount</li>
 * <li>Setting an invalid used ingredient amount</li>
 * </ul>
 * 
 * <p>
 * Each test method uses assertions to verify the expected outcomes.
 * The tests ensure that the Ingredient class behaves correctly under various
 * conditions.
 * 
 * @see Ingredient
 */

public class IngredientTest {

  // --------------------------- Positiv TESTS ----------------------------------

  /**
   * Tests the creation of an Ingredient instance with a valid ingredient name.
   */
  @Test
  public void createInstanceWithValidIngredientName() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    String actualName = ingredient.getIngredientName();
    assertEquals("Kiwi", actualName); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with a valid ingredient amount.
   */
  @Test
  public void createInstanceWithValidIngredientAmount() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    double actualAmount = ingredient.getIngredientAmount();
    assertEquals(10, actualAmount); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with a valid ingredient price.
   */
  @Test
  public void createInstanceWithValidIngredientPrice() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    double actualPrice = ingredient.getIngredientPrice();
    assertEquals(10, actualPrice); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with a valid ingredient
   * measurement.
   */
  @Test
  public void createInstanceWithValidIngredientMeasurment() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    String actualMesurment = ingredient.getIngredientMeasurment();
    assertEquals("Unit", actualMesurment); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with a valid ingredient
   * expiration date.
   */
  @Test
  public void createInstanceWithValidIngredientDate() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    String actualExpireDate = ingredient.getIngredientExpireDate();
    assertEquals("Expired", actualExpireDate); // Assert
  }

  /**
   * Tests setting an extra ingredient amount to a valid value.
   */
  @Test
  public void createInstanceWithValidIngredientSetAmount() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    ingredient.setExtraIngredientAmount(1);
    assertEquals(11, ingredient.getIngredientAmount()); // Assert
  }

  /**
   * Tests setting a used ingredient amount to a valid value.
   */
  @Test
  public void createInstanceWithValidIngredientUsedAmount() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 100, "2023-04-25");
    ingredient.setUsedIngredientAmount(1);
    assertEquals(9, ingredient.getIngredientAmount());
  }

  // --------------------------- Negative TESTS ----------------------------------

  /**
   * Tests the creation of an Ingredient instance with an invalid negative amount.
   */
  @Test
  public void createInstanceWithInvalidNegativeAmount() {
    boolean testPassed = false;
    try {
      Ingredient ingredient = new Ingredient("kiwi",
          -10, 0, 100, "2023-04-25");
    } catch (IllegalArgumentException e) {
      testPassed = true;
    }
    assertTrue(testPassed); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with an invalid negative price.
   */
  @Test
  public void createInstanceWithInvalidNegativePrice() {
    boolean testPassed = false;
    try {
      Ingredient ingredient = new Ingredient("kiwi",
          10, 0, -100, "2023-04-25");
    } catch (IllegalArgumentException e) {
      testPassed = true;
    }
    assertTrue(testPassed); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with an invalid measurement.
   */
  @Test
  public void createInstanceWithInvalidMeasurment() {
    boolean testPassed = false;
    try {
      Ingredient ingredient = new Ingredient("kiwi",
          10, 3, 100, "2023-04-25");
    } catch (IllegalArgumentException e) {
      testPassed = true;
    }
    assertTrue(testPassed); // Assert
  }

  /**
   * Tests the creation of an Ingredient instance with a null or empty date.
   */
  @Test
  public void createInstanceWithInvalidNullDate() {
    assertThrows(IllegalArgumentException.class, () -> {
      Ingredient ingredient = new Ingredient("Kiwi",
          10, 0, 100, " ");
    });
  }

  /**
   * Tests setting a negative extra ingredient amount.
   */
  @Test
  public void setNegativeExtraIngredientAmount() {
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 10, "2023-04-25");
    // Test that an IllegalArgumentException is being thrown
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      ingredient.setExtraIngredientAmount(-10);
    });
    // that Ingredient amount didnt change
    assertEquals(10, ingredient.getIngredientAmount());
  }

  /**
   * Tests setting a negative used ingredient amount.
   */
  @Test
  public void setNegativeUsedIngredientAmount() {
    Ingredient ingredient = new Ingredient("kiwi", 5, 0, 10, "2023-04-25");
    // Test that an IllegalArgumentException is being thrown
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      ingredient.setUsedIngredientAmount(-10);
    });
    // that Ingredient amount didnt change
    assertEquals(5.0, ingredient.getIngredientAmount());
  }

  /**
   * Tests setting an invalid extra ingredient amount.
   */
  @Test
  public void setInvalidExtraAmount() {
    // First create an instance with valid parameters
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 10, "2023-04-25");
    // Try setting the phone number with empty string
    assertThrows(IllegalArgumentException.class, () -> {
      ingredient.setExtraIngredientAmount(0);
    });
    // Try setting the phone number with a blank string filled with spaces
    assertThrows(IllegalArgumentException.class, () -> {
      ingredient.setExtraIngredientAmount(-10);
    });
  }

  /**
   * Tests setting an invalid used ingredient amount.
   */
  @Test
  public void setInvalidUsedAmount() {
    // First create an instance with valid parameters
    Ingredient ingredient = new Ingredient("kiwi", 10, 0, 10, "2023-04-25");
    // Try setting the phone number with empty string
    assertThrows(IllegalArgumentException.class, () -> {
      ingredient.setUsedIngredientAmount(-10);
    });
    // Try setting the phone number with a blank string filled with spaces
    assertThrows(IllegalArgumentException.class, () -> {
      ingredient.setUsedIngredientAmount(0);
    });
  }

}
