/*
 ^ FoodStorage
 ^ Contains ingredients that will be used to make food recipes.
 ^ 
 ^ @author: (Mahmoud Madhun)
 ^ @javaBuild: (JavaSE build 23+37-2369)
*/


package edu.ntnu.iir.bidata;

import java.util.ArrayList;




public class FoodStorage{


    private ArrayList<Ingredient> ingredients; //ingredients refers to the list

    public FoodStorage(){
        this.ingredients = new ArrayList<>(); 
    }



    
    /**
     * Adds an ingredient to the storage.
     * 
     * @param ingredient the ingredient to be added to the storage
     */
    public void addIngredient(Ingredient ingredient){
            this.ingredients.add(ingredient);
    }










/**
 * Displays all ingredients in the food storage.
 * The ingredients are displayed in a tabular format with columns for the ingredient name and amount.
 * Each row represents an ingredient with its name and amount formatted for readability.
 * The table is enclosed within horizontal lines for better visual separation.
*/
    public void displayAllIngredients(){
        // //! | %-10s | %-8s | %4s |%n sizes
        System.out.println("\n");
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-16s  %-13s  %-15s |%n", " ","Ingredients"," ");
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-13s | %-13s | %-16s |%n", "Name", "Amount","XXXXXXXXX");
        System.out.println("----------------------------------------------------");



        ingredients.forEach((Ingredient ingredient)-> 
        {//lamda
            System.out.printf("| %-13s | %-13s | %-16s |%n", ingredient.getIngredientName(), ingredient.getIngredientAmout()+" "+ingredient.getIngredientMeagurmentType(),"NotDoneYet");
            System.out.println("----------------------------------------------------");
        });
        

    }





    public Ingredient getPositionInfoodStorage(int position){
        return this.ingredients.get(position);
    }
    
}
