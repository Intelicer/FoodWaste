/*
 * FoodStorage
 * Contains ingredients that will be used to make food recipes.
 * 
 * @author (Mahmoud Madhun)
 * @author (JavaSE build 23+37-2369)
 */

package edu.ntnu.iir.bidata;

public class Ingredient{


    private String ingredientName;
    private int ingredientAmount;


    public Ingredient(String ingredientName, int ingredientAmount){
        
        this.ingredientName = ingredientName;
        this.ingredientAmount = ingredientAmount;

    }


    //& Return Ingredient Name
    public String getIngredientName(){ 
        return this.ingredientName;
    }


    //& Return Ingredient amount
    public int getIngredientAmout(){ 
        return this.ingredientAmount;
    }
    

    //& Return ingredients amount after 
    public void useIngredientAmount(int amountOfUsedIngredient){
        if(amountOfUsedIngredient > 0 && amountOfUsedIngredient <= this.ingredientAmount){
            this.ingredientAmount -= amountOfUsedIngredient;
            System.out.println("Took " + amountOfUsedIngredient + " " + this.ingredientName + " " +"out of food storage");
            System.out.println("The amount that remains in the storage: " + this.ingredientAmount);
        }else{
            System.out.println("ERR_CANT_USE_NEGATIVE_AMOUNT");
        }
    }


    

    
}
