package edu.ntnu.iir.bidata.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */

public class Ingredient {

  private String ingredientName;
  private double ingredientAmount;
  private int ingredientMeasurement;
  private LocalDate ingredientExpireDate;
  private double ingreadientPrice;
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  /**
   * Constructs an Ingredient object with the specified parameters.
   *
   * @param ingredientName        the name of the ingredient. Must not start or end with a space.
   * @param ingredientAmount      the amount of the ingredient. Must be greater than 0.
   * @param ingredientMeasurement the measurement type of the ingredient. Must be between 0 and 2.
   * @param ingreadientPrice      the price of the ingredient. Must be greater than or equal to 0.
   * @param ingredientExpireDate  the expiration date of the ingredient in the format yyyy-MM-dd.
   * @throws IllegalArgumentException if the ingredientName starts or ends with a space.
   * @throws IllegalArgumentException if the ingredientMeasurement is not between 0 and 2.
   * @throws IllegalArgumentException if the ingredientAmount is less than or equal to 0.
   * @throws IllegalArgumentException if the ingreadientPrice is less than 0.
   * @throws IllegalArgumentException if the ingredientExpireDate is not in the format yyyy-MM-dd.
   */
  public Ingredient(
      String ingredientName,
      double ingredientAmount,
      int ingredientMeasurement,
      double ingreadientPrice,
      String ingredientExpireDate) { // ^ Test this


    if ((ingredientName.startsWith(" ")
          || ingredientName.endsWith(" "))) {
      throw new IllegalArgumentException("ERR: name cant start with space or end with space");
    }
    // ? Guard Statement for the Measurement
    if (ingredientMeasurement >= 1 && ingredientMeasurement > 2) { // ! Types from 0-2
      throw new IllegalArgumentException("ERR: wrong messurment");
    }
    // ? Guard Statement for the Amount
    if (ingredientAmount <= 0) {
      throw new IllegalArgumentException("ERR: amount cant be 0 or negative");
    }

    // ? Guard Statement for the Price
    if (ingreadientPrice < 0) {
      throw new IllegalArgumentException("ERR: price cant be 0 or negative");
    }

    // ? Guard Statement for the Expire Date
    try {
      LocalDate.parse(
          ingredientExpireDate,
          FORMATTER); // ! To check if ingredientExpireDate is parsed as same as the format
    } catch (Exception e) {
      throw new IllegalArgumentException("ERR: Wrong date format i should be (yyyy-MM-dd)");
    }

    this.ingredientName = ingredientName.substring(0, 1).toUpperCase()
        + ingredientName.substring(1, ingredientName.length()).toLowerCase();
    this.ingredientMeasurement = ingredientMeasurement;
    this.ingredientAmount = ingredientAmount;
    this.ingreadientPrice = ingreadientPrice;
    this.ingredientExpireDate = LocalDate.parse(ingredientExpireDate, FORMATTER);
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
      throw new IllegalArgumentException("ERR: name cant be blank or empty");
    }
    if ((ingredientName.startsWith(" ")
        || ingredientName.endsWith(" "))) {
      throw new IllegalArgumentException("ERR: name cant start with space or end with space");
    }
    // ? Guard Statement for the Measurement
    if (ingredientMeasurement >= 1 && ingredientMeasurement > 2) { // ! Types from 0-2
      throw new IllegalArgumentException("ERR: wrong messurment");
    }
    // ? Guard Statement for the Amount
    if (ingredientAmount <= 0) {
      throw new IllegalArgumentException("ERR: amount cant be 0 or negative");
    }


    this.ingredientName = ingredientName.substring(0, 1).toUpperCase()
        + ingredientName.substring(1, ingredientName.length()).toLowerCase();
    this.ingredientMeasurement = ingredientMeasurement;
    this.ingredientAmount = ingredientAmount;
  }








  /**
   * Retrieves the name of the ingredient.
   *
   * @return the name of the ingredient
   */
  public String getIngredientName() {
    return this.ingredientName;
  }




  /**
 * Retrieves the amount of the ingredient.
 *
 * @return the amount of the ingredient
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
 * Retrieves the measurement type of the ingredient.
 *
 * @return the measurement type of the ingredient as a string. Possible values are "Unit", "G", "L".
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
          "ERR: not allowed to set extra amount in negative or 0");
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
      throw new IllegalArgumentException("ERR: used amount cant be in negative or zero");
    }
    if (amountOfUsedIngredient > 0 && amountOfUsedIngredient <= this.ingredientAmount) { // Check
      this.ingredientAmount -= amountOfUsedIngredient;

      if (this.getIngredientPrice() > 0) {
        this.ingreadientPrice -= amountOfUsedIngredient / this.ingreadientPrice;
      }

    } else {
      throw new IllegalArgumentException(
          "ERR: used amount cant be higher than existed amount");
    }
  }



}
