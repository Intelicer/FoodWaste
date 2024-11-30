package edu.ntnu.iir.bidata.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.ntnu.iir.bidata.logic.FoodStorage;

/**
 * The Ingredient class represents an ingredient with its name, amount,
 * measurement type, expiration
 * date, and price. It provides methods to create an ingredient and validate its
 * properties.
 *
 *<p>This class provides methods to:
 *
 * <ul>
 * <li>Create an ingredient with specified properties
 * <li>Validate the ingredient's name, amount, and measurement type
 * </ul>
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * Ingredient ingredient = new Ingredient("Tomato", 5.0, 1, 2.5, "2023-10-10");
 * }</pre>
 *
 * 
 * <p>Note: The constructor validates the input parameters and throws an {@link
 * IllegalArgumentException} if invalid values are provided.
 *
 * @see FoodStorage
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class Ingredient {

  private String ingredientName;
  private double ingredientAmount;
  private int ingredientMeasurement;
  private LocalDate ingredientExpireDate;
  private double ingreadientPrice;
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  /**
   * Constructs an Ingredient object with the specified parameters.
   *
   * @param ingredientName        the name of the ingredient. Must not be blank.
   * @param ingredientAmount      the amount of the ingredient. Must be greater
   *                              than 0.
   * @param ingredientMeasurement the measurement type of the ingredient. Must be
   *                              between 0 and 2.
   * @param ingreadientPrice      the price of the ingredient. Must not be
   *                              negative.
   * @param ingredientExpireDate  the expiration date of the ingredient in the
   *                              format "yyyy-MM-dd".
   * @throws IllegalArgumentException if the ingredientName is blank.
   * @throws IllegalArgumentException if the ingredientMeasurement is not between
   *                                  0 and 2.
   * @throws IllegalArgumentException if the ingredientAmount is less than or
   *                                  equal to 0.
   * @throws IllegalArgumentException if the ingreadientPrice is negative.
   * @throws IllegalArgumentException if the ingredientExpireDate is in the wrong
   *                                  format.
   */
  public Ingredient(
      String ingredientName,
      double ingredientAmount,
      int ingredientMeasurement,
      double ingreadientPrice,
      String ingredientExpireDate) { // ^ Test this

    // ? Guard Statement for ingredientName
    if ((ingredientName.isBlank())) {
      throw new IllegalArgumentException("ERR_INGREDIENT_NAME_BE_EMPTY_OR_BLANK");
    }
    // ? Guard Statement for the Measurement
    if (ingredientMeasurement >= 1 && ingredientMeasurement > 2) { // ! Types from 0-2
      throw new IllegalArgumentException("ERR_THERE_IS_ONLY_3_MEAGUERMENTS");
    }
    // ? Guard Statement for the Amount
    if (ingredientAmount <= 0) {
      throw new IllegalArgumentException("ERR_INGREDIENT_AMOUNT_CANT_BE_0_OR_NEGATIVE");
    }

    // ? Guard Statement for the Price
    if (ingreadientPrice < 0) {
      throw new IllegalArgumentException("ERR_INGREDIENT_PRICE_CANT_BE_0_OR_NEGATIVE");
    }

    // ? Guard Statement for the Expire Date
    try {
      LocalDate.parse(
          ingredientExpireDate,
          formatter); // ! To check if ingredientExpireDate is parsed as same as the format
    } catch (Exception e) {
      throw new IllegalArgumentException("ERR_INGREDIENT_EXPIRE_DATE_WRONG_FORMAT");
    }

    this.ingredientName = ingredientName.substring(0, 1).toUpperCase()
        + ingredientName.substring(1, ingredientName.length()).toLowerCase();
    this.ingredientMeasurement = ingredientMeasurement;
    this.ingredientAmount = ingredientAmount;
    this.ingreadientPrice = ingreadientPrice;
    this.ingredientExpireDate = LocalDate.parse(ingredientExpireDate, formatter);
  }




  /**
   * Constructs an Ingredient object with the specified parameters.
   *
   * @param ingredientName        the name of the ingredient. Must not be blank.
   * @param ingredientAmount      the amount of the ingredient. Must be greater
   *                              than 0.
   * @param ingredientMeasurement the measurement type of the ingredient. Must be
   *                              between 0 and 2.
   * @throws IllegalArgumentException if the ingredientName is blank.
   * @throws IllegalArgumentException if the ingredientMeasurement is not between
   *                                  0 and 2.
   * @throws IllegalArgumentException if the ingredientAmount is less than or
   *                                  equal to 0.
   */
  public Ingredient(
      String ingredientName,
      double ingredientAmount,
      int ingredientMeasurement) { // ^ Test this

    // ? Guard Statement for ingredientName
    if ((ingredientName.isBlank())) {
      throw new IllegalArgumentException("ERR_INGREDIENT_NAME_BE_EMPTY_OR_BLANK");
    }
    // ? Guard Statement for the Measurement
    if (ingredientMeasurement >= 1 && ingredientMeasurement > 2) { // ! Types from 0-2
      throw new IllegalArgumentException("ERR_THERE_IS_ONLY_3_MEAGUERMENTS");
    }
    // ? Guard Statement for the Amount
    if (ingredientAmount <= 0) {
      throw new IllegalArgumentException("ERR_INGREDIENT_AMOUNT_CANT_BE_0_OR_NEGATIVE");
    }


    this.ingredientName = ingredientName.substring(0, 1).toUpperCase()
        + ingredientName.substring(1, ingredientName.length()).toLowerCase();
    this.ingredientMeasurement = ingredientMeasurement;
    this.ingredientAmount = ingredientAmount;
  }


  public String getIngredientName() {
    return this.ingredientName;
  }

  /**
 * Returns the name of the ingredient.
 *
 * @return the name of the ingredient.
 */
  public double getIngredientAmount() {
    return this.ingredientAmount;
  }


  /**
 * Returns the expiration status or date of the ingredient.
 *
 * @return "Expired" if the ingredient is expired, "Expired Today" if it expires today,
 *         or the expiration date as a string if it expires in the future.
 */
  public String getIngredientExpireDate() {
    String expired = "Expired";
    String expiresToday = "Expires Today";
    if (this.ingredientExpireDate.isBefore(LocalDate.now())) {
      return expired;
    } else if (this.ingredientExpireDate.isEqual(LocalDate.now())) {
      return expiresToday;
    } else {
      return this.ingredientExpireDate.toString();
    }
  }

  /**
 * Returns the expiration status or date of the ingredient.
 *
 * @return "Expired" if the ingredient is expired, "Expired Today" if it expires today,
 *         or the expiration date as a string if it expires in the future.
 */
  public String getIngredientMeasurment() {
    String[] ingredientMeasurementType = { "Unit", "G", "L" }; //! kan utvides videre
    return ingredientMeasurementType[this.ingredientMeasurement];
  }

  /**
 * Returns the price of the ingredient.
 *
 * @return ingredient price.
 */
  public double getIngredientPrice() {
    if (this.ingredientMeasurement == 0) {
      return this.ingreadientPrice / this.ingredientAmount;
    }
    return this.ingreadientPrice;
  }


  /**
 * Adds an extra amount to the current amount of the ingredient.
 *
 * @param addExtraAmountofIngredient the extra amount to be added. Must be greater than zero.
 * @throws IllegalArgumentException if the extra amount is less than or equal to zero.
 */
  public void setExtraIngredientAmount(double addExtraAmountofIngredient) { // ^ Test this
    if (addExtraAmountofIngredient <= 0) {
      throw new IllegalArgumentException(
          "ERR_NOT_ALLOWED_TO_ADD_EXTRA_AMOUNT_IN_NEGATIVE_OR_ZERO_VALUE");
    } else {
      this.ingredientAmount += addExtraAmountofIngredient;
    }
  }

  /**
 * Uses a specified amount of the ingredient, reducing the current amount.
 *
 * @param amountOfUsedIngredient the amount of the ingredient to use. Must be greater than zero and 
 *                               less than or equal to the current amount.
 * @throws IllegalArgumentException if the amount to use is less than or equal to zero, or greater 
 *                                  than the current amount.
 */
  public void setUsedIngredientAmount(double amountOfUsedIngredient) { // ^ Test this
    if (amountOfUsedIngredient <= 0) { // ? guard-Statement
      throw new IllegalArgumentException("ERR_AMOUNT_TO_USE_IS_LOWER_OR_EQUALS_0");
    }
    if (amountOfUsedIngredient > 0 && amountOfUsedIngredient <= this.ingredientAmount) { // Check
      this.ingredientAmount -= amountOfUsedIngredient;
    } else {
      throw new IllegalArgumentException(
          "ERR_THE_AMOUNT_YOU_WANT_TO_USE_IS_HIGHER_WHAT_WE_HAVE");
    }
  }


  // Validation method
  public boolean isValid() {
    return ingredientName != null && !ingredientName.isBlank();
  }



}
