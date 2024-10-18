package edu.ntnu.iir.bidata;


import java.time.format.DateTimeFormatter;
import java.time.LocalDate;




/**
 * The Ingredient class represents an ingredient with its name, amount, measurement type,
 * expiration date, and price. It provides methods to create an ingredient and validate its properties.
 * 
 * <p>This class provides methods to:
 * <ul>
 *   <li>Create an ingredient with specified properties</li>
 *   <li>Validate the ingredient's name, amount, and measurement type</li>
 * </ul>
 * 
 * <p>Example usage:
 * <pre>
 * {@code
 * Ingredient ingredient = new Ingredient("Tomato", 5.0, 1, 2.5, "2023-10-10");
 * }
 * </pre>
 * 
 * <p>Note: The constructor validates the input parameters and throws an {@link IllegalArgumentException}
 * if invalid values are provided.
 * 
 * @see FoodStorage
 * @see FoodWasteSystemPrints
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
 */



public class Ingredient{

    private int ingredientMeasurement;
    private String ingredientName;
    private double ingredientAmount;
    private LocalDate ingredientExpireDate;
    private String[] ingredientMeasurementType = {"Unit","G","L"};
    private String typeOfMeaguer;
    private double ingreadientPrice;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    


    /**
     * 
     * Creates instance of Ingredient with name,amount,type,date of expieres
     * 
     * <p>If invalid values are passed to the parameters, an {@link IllegalArgumentException} will be thrown</p>
     * 
     * @param ingredientName name of it (String)
     * @param ingredientAmount amount of it (will be taken after an if statement that the user will choose if its in: gram,liter or piece) => (int)
     * @param ingredientType type of it (int)
     * @param ingredientExpireDate Ingredient expire date
     * 
     * @throws IllegalArgumentException if ingredientMeasurement, ingredientName or ingredientAmount are given with invalid values.
     * 
    */
    public Ingredient(String ingredientName, double ingredientAmount, int ingredientMeasurement, double ingreadientPrice, String ingredientExpireDate){

        //? Guard Statement for ingredientName
        if ((ingredientName.isBlank())){
            throw new IllegalArgumentException("ERR_INGREDIENT_NAME_BE_EMPTY_OR_BLANK");
        }
        // ? Guard Statement for the Measurement
        if(ingredientMeasurement >= 1 && ingredientMeasurement > 2){ //! Types from 0-2
            throw new IllegalArgumentException("ERR_THERE_IS_ONLY_3_MEAGUERMENTS");
        }
        //? Guard Statement for the Amount
        if (ingredientAmount <= 0){
            throw new IllegalArgumentException("ERR_INGREDIENT_AMOUNT_CANT_BE_0_OR_NEGATIVE");
        }

        //? Guard Statement for the Price
        if (ingreadientPrice < 0){
            throw new IllegalArgumentException("ERR_INGREDIENT_PRICE_CANT_BE_0_OR_NEGATIVE");
        }



        //? Guard Statement for the Expire Date
        try {
            LocalDate.parse(ingredientExpireDate, formatter); //! To check if ingredientExpireDate is parsed as same as the format
        } catch (Exception e) {
            throw new IllegalArgumentException("ERR_INGREDIENT_EXPIRE_DATE_WRONG_FORMAT");
        }


        this.ingredientName = ingredientName.substring(0,1).toUpperCase() + ingredientName.substring(1, ingredientName.length()).toLowerCase();
        this.ingredientMeasurement = ingredientMeasurement;
        this.ingredientAmount = ingredientAmount;
        this.ingreadientPrice = ingreadientPrice;
        this.ingredientExpireDate = LocalDate.parse(ingredientExpireDate, formatter);
        
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
    
    public String getIngredientExpireDate(){ 
        String expired = "Expired";
        String expiredToday = "Expired";
        if(this.ingredientExpireDate.isBefore(LocalDate.now())){
            return expired;
        }else if(this.ingredientExpireDate.isEqual(LocalDate.now())){
            return expiredToday;
        }
        return this.ingredientExpireDate.toString();
    }
    
    
    
    /**
     * Return Measuremnt type of an Ingredient based on user choose from the selection menu,
     * here is a small ArrayList use called ingredientMeasurement.
     * @return
     */
    
    public String getIngredientMeasurmentmentType(){ 
        typeOfMeaguer = ingredientMeasurementType[this.ingredientMeasurement];
        return typeOfMeaguer;
    }
    

    /**
     * Return Ingredient Price.
    */
    public double getIngredientPrice(){ 
        return this.ingreadientPrice;
    }

    /**
     * Return Ingredient Price.
    */
    public String getIngredientPriceWithMoneySymbol(){ 
        String ingreadientPriceInDollars = this.ingreadientPrice + "$";
        return ingreadientPriceInDollars;
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
                System.out.println("\nTook " + amountOfUsedIngredient+ typeOfMeaguer + " " + this.ingredientName + " " +"out of food storage");
                System.out.println("The amount that remains in the storage: " + this.ingredientAmount + typeOfMeaguer);
            }
        }else{
            throw new IllegalArgumentException("ERR_INGREDIENT_USED_AMOUNT_CANT_BE_0_OR_NEGATIVE_CHECK_METHOD");
        }
    }


    

}
