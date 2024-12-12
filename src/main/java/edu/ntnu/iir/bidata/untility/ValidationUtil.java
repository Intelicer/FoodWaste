package edu.ntnu.iir.bidata.untility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The ValidationUtil class provides utility methods for validating user input.
 * It includes methods to validate string input, integer input, double input, 
 * date input, and single character input. These methods ensure that the user 
 * input meets specific criteria and prompts the user to re-enter the input 
 * if it is invalid.
 * 
 * <p>Methods included in this class:
 * <ul>
 *   <li>{@link #isVaildStringInput(Scanner, String)}: Validates a string input.
 *   <li>{@link #isVaildMesurmentInput(Scanner)}: Validates an integer measurement input.
 *   <li>{@link #isVaildDoubleInput(Scanner, String)}: Validates a double input.
 *   <li>{@link #isVaildIntInput(Scanner, String)}: Validates an integer input.
 *   <li>{@link #isValidDateInput(Scanner, String)}: Validates a date input.
 *   <li>{@link #isValidCharInput(Scanner, String)}: Validates a single character input.
 * </ul>
 * 
 * <p>Each method reads user input from the console using a Scanner object and 
 * ensures that the input meets the required criteria. If the input is invalid, 
 * the user is prompted to re-enter the input until a valid input is provided.
 * 
 * <p>Example usage:
 * <pre>
 * {@code
 * Scanner scanner = new Scanner(System.in);
 * String ingredientName = ValidationUtil.isVaildStringInput(scanner, "Ingredient Name");
 * int measurement = ValidationUtil.isVaildMesurmentInput(scanner);
 * double quantity = ValidationUtil.isVaildDoubleInput(scanner, "Quantity");
 * int someInt = ValidationUtil.isVaildIntInput(scanner, "Some Integer");
 * String date = ValidationUtil.isValidDateInput(scanner, "Date");
 * char singleChar = ValidationUtil.isValidCharInput(scanner, "Single Character");
 * }
 * </pre>
 * 
 * <p>Note: The methods in this class assume that the Scanner object is properly 
 * initialized and passed to the methods.
 * 
 * @see java.util.Scanner
 * @see java.time.LocalDate
 * @see java.time.format.DateTimeFormatter
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */
public class ValidationUtil {
    

  /**
   * Prompts the user to input the name of an ingredient and validates the input.
   * The method ensures that the user does not enter a blank or empty name.
   * 
   *
   * @param userInput a Scanner object to read user input from the console.
   * @return a valid ingredient name entered by the user.
  */
  public static String isVaildStringInput(Scanner userInput, String validationTarget) {
    String stringInput = userInput.nextLine();
    stringInput = stringInput.replaceAll("\\s+", " ").trim();
    stringInput = stringInput.substring(0, 1).toUpperCase() 
                                      + stringInput.substring(1).toLowerCase();
    boolean inCorrectString = true; // name is not correct
    while (inCorrectString == true) {
      if ((stringInput.isBlank())) {
        System.out.println("\n"
                          + validationTarget
                          + " cant be blank or empty.");
        System.out.println("Rewrite name:");
        stringInput = userInput.nextLine(); //
      } else {
        inCorrectString = false;
      }
    }
    return stringInput;
  }

  /**
   * Validates the user input for ingredient measurement.
   * The input must be an integer between 0 and 2 inclusive.
   * If the input is invalid, the user will be prompted 
   * to enter a valid number until a valid input is provided.
   *
   * @param userInput the Scanner object to read user input
   * @return the validated ingredient measurement as an integer
   * @throws NumberFormatException if the input is not a valid integer
  */
  public static int isVaildMesurmentInput(Scanner userInput) {
    String messurmentStringInput = null;
    boolean numberIsntIntegar = true;
    int vaildMesurmentInput = 0;
    while (numberIsntIntegar == true) {
      try {
        messurmentStringInput = userInput.nextLine();
        vaildMesurmentInput = Integer.parseInt(messurmentStringInput);
        
        if (vaildMesurmentInput < 0 || 2 < vaildMesurmentInput) { 
          throw new IllegalArgumentException();
        }
        numberIsntIntegar = false;
      } catch (NumberFormatException e) {
        if (messurmentStringInput instanceof String) {
          System.out.println("\nYou cant input a string "
                            + messurmentStringInput
                            + "\nWrite a number again: ");
        }
      } catch (IllegalArgumentException e) {
        System.out.println("\nThe must be one of the listed."
                            + "\nWrite a number again:");
      }
    }
    return vaildMesurmentInput;
  }

  /**
   * Validates the user input for a double value.
   * The input must be a positive double value.
   * If the input is invalid, the user will be prompted 
   * to enter a valid number until a valid input is provided.
   *
   * @param userInput the Scanner object to read user input
   * @return the validated double value
   * @throws NumberFormatException if the input is not a valid double
  */
  public static double isVaildDoubleInput(Scanner userInput, String validationTarget) {
    boolean vaildDouble = true;
    double vaildNumber = Double.parseDouble(userInput.nextLine());
    while (vaildDouble == true) {
      if (vaildNumber <= 0) {
        
        System.out.println("\nThe number you are trying to enter, cant be"
              + "\nnegative, 0, or higher that the stored amount");
        System.out.println("Check the Number again: ");
        vaildNumber = Double.parseDouble(userInput.nextLine());
      } else {
        vaildDouble = false;
      }
    }
    return vaildNumber;
  }
  

  /**
   * Validates the user input for an integer value.
   * The input must be a valid integer.
   * If the input is invalid, the user will be prompted 
   * to enter a valid number until a valid input is provided.
   *
   * @param userInput the Scanner object to read user input
   * @param validationTarget the target being validated
   * @return the validated integer value
   */
  public static int isVaildIntInput(Scanner userInput, String validationTarget) {
    String hopeItsRight = null;
    boolean numberIsntIntegar = true;
    int theValidated = 0;
    while (numberIsntIntegar == true) {
      try {
        hopeItsRight = userInput.nextLine();
        theValidated = Integer.parseInt(hopeItsRight);
        numberIsntIntegar = false;
      } catch (NumberFormatException e) {
        if (hopeItsRight instanceof String) {
          System.out.println("\nInvalid entered integar for: ( "
              + validationTarget 
              + " )"
              + "\nWrite a valid integar show from the menu");
        } else {
          System.out.println("\nInvalid entered integar for: ("
              + validationTarget 
              + ")"
              + "\nWrite a valid integar show from the menu");
        }
      }
    }
    return theValidated;
  }

  /**
   * Validates and returns a date input from the user.
   * The method prompts the user to enter a date and checks if the input is in the correct format.
   * If the input is not in the correct format, 
   * it will repeatedly prompt the user until a valid date is entered.
   *
   * @param userInput the Scanner object to read user input
   * @return a valid date string in the correct format
   */
  public static String isValidDateInput(Scanner userInput, String validationTarget) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String date = userInput.nextLine();
    boolean wrongFormat = true;
    while (wrongFormat == true) {
      try {
        LocalDate.parse(date, formatter);
        wrongFormat = false;
      } catch (Exception e) {
        System.out.println("\nWrong Format for "
            + validationTarget
            + "\nRetype a date:");
        date = userInput.nextLine();
      }
    }    
    return date;
  }




  /**
   * Validates the user input for a single character.
   * The input must be a single character.
   * If the input is invalid, the user will be prompted 
   * to enter a valid character until a valid input is provided.
   *
   * @param userInput the Scanner object to read user input
   * @param validationTarget the target being validated
   * @return the validated character
   */
  public static char isValidCharInput(Scanner userInput, String validationTarget) {
    String textInput;
    boolean isValid = false;
    char charInput = '0';
    while (isValid == false) {
      textInput = userInput.nextLine();
      textInput = textInput.replaceAll("\\s+", "").trim();
      if (textInput.length() == 1) {
        charInput = textInput.charAt(0);
        isValid = true;
      } else {
        System.out.println("\nInvalid input for " 
                          + validationTarget 
                          + ".\nPlease enter a single character:");
      }
    }
    return charInput;
  }

}
