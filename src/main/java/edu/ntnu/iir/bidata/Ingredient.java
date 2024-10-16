package edu.ntnu.iir.bidata;

import java.util.Date;
import java.time.format.DateTimeFormatter;

/**
 * The {@code Ingredient} class represents an ingredient with a name, amount, and measurement type.
 * It provides methods to retrieve ingredient details, add extra amounts, and use specified amounts.
 * 
 * <p>If invalid values are passed to the parameters, an {@link IllegalArgumentException} will be thrown.</p>
 * 
 * <p>Example usage:</p>
 * <pre>{@code
 * Ingredient ingredient = new Ingredient("Sugar", 500, 1);
 * System.out.println(ingredient.getIngredientName()); // Output: Sugar
 * System.out.println(ingredient.getIngredientAmout()); // Output: 500.0
 * System.out.println(ingredient.getIngredientMeagurmentType()); // Output: G
 * ingredient.addExtraIngredientAmount(200);
 * ingredient.useIngredientAmount(100);
 * }</pre>
 * 
 * @author Mahmoud Madhun)
 * @version (JavaSE build 23+37-2369)
 */
public class Ingredient{

    private int ingredientMeasurement;
    private String ingredientName;
    private double ingredientAmount;
    // private String dateExpieres;
    private String[] ingredientMeasurementType = {"Unit","G","L"};
    private String typeOfMeaguer;
    private Date ingreadientExpireDate = new Date();
    private double ingreadientPrice;



    /**
     * 
     * Creates instance of Ingredient with name,amount,type,date of expieres
     * 
     * <p>If invalid values are passed to the parameters, an {@link IllegalArgumentException} will be thrown</p>
     * 
     * @param ingredientName name of it (String)
     * @param ingredientAmount amount of it (will be taken after an if statement that the user will choose if its in: gram,liter or piece) => (int)
     * @param ingredientType type of it (int)
     * @param ingreadientExpireDate Ingreadient expire
     * 
     * @throws IllegalArgumentException if ingredientMeasurement, ingredientName or ingredientAmount are given with invalid values.
     * 
    */
    public Ingredient(String ingredientName, double ingredientAmount, int ingredientMeasurement, double ingreadientPrice){
        //? Guard Statement for ingredientName
        if ((ingredientName.isBlank())){
            throw new IllegalArgumentException("ERR_INGREDIENT_NAME_BE_EMPTY_OR_BLANK");
        }
        // ? Guard Statement for the ingredientMeasurement
        if(ingredientMeasurement >= 1 && ingredientMeasurement > 2){ //! Types from 0-2
            throw new IllegalArgumentException("ERR_THERE_IS_ONLY_3_MEAGUERMENTS");
        }
        //? Guard Statement for the amount
        if (ingredientAmount <= 0){
            throw new IllegalArgumentException("ERR_INGREDIENT_AMOUNT_CANT_BE_0_OR_NEGATIVE");
        }

        this.ingredientName = ingredientName.substring(0,1).toUpperCase() + ingredientName.substring(1, ingredientName.length()).toLowerCase();
        this.ingredientMeasurement = ingredientMeasurement;
        this.ingredientAmount = ingredientAmount;
        // this.dateExpieres = dateExpieres;
        this.ingreadientPrice = ingreadientPrice;
        
    }




    /**
     * Returns Name of the ingredient
     */
    public String getIngredientName(){ 
        return this.ingredientName;
    }


    /**
     * Return Ingredient amount by using ingredient meaguer type:
    */
    public double getIngredientAmout(){ 
        return this.ingredientAmount;
    }



    /**
     * Return Measuremnt type of an Ingredient based on user choose from the selection menu,
     * here is a small ArrayList use called ingredientMeasurement.
     * @return
     */

    public String getIngredientMeagurmentType(){ 
        typeOfMeaguer = ingredientMeasurementType[this.ingredientMeasurement];
        return typeOfMeaguer;
    }
    





    /**
     * Adding Extra Amount of an ingredient 
     * @param addExtraAmountofingredient
     */
    public void addExtraIngredientAmount(double addExtraAmountofingredient){
        if(addExtraAmountofingredient <= 0){
            throw new IllegalArgumentException("ERR_NOT_ALLOWED_TO_ADD_EXTRA_AMOUNT_IN_NEGATIVE_OR_ZERO_VALUE");
        }
        else{
            this.ingredientAmount += addExtraAmountofingredient;
        }
    }




    /**
     * Use an amount of an Ingredient to make a recipe or eat.
     * @param amountOfUsedIngredient
     */
    public void useIngredientAmount(double amountOfUsedIngredient){
        if(amountOfUsedIngredient > 0 && amountOfUsedIngredient <= this.ingredientAmount){
            this.ingredientAmount -= amountOfUsedIngredient;

            if(this.ingredientAmount == 0){
                System.out.println("There is no more: "+ this.ingredientName);
            }else{
                System.out.println("Took " + amountOfUsedIngredient + " " + this.ingredientName + " " +"out of food storage");
                System.out.println("The amount that remains in the storage: " + this.ingredientAmount);
            }
        }else{
            throw new IllegalArgumentException("ERR_INGREDIENT_USED_AMOUNT_CANT_BE_0_OR_NEGATIVE_CHECK_METHOD");
        }
    }


    

}
