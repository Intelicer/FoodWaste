package edu.ntnu.iir.bidata;

import java.util.ArrayList;

public class Fridge {

    private ArrayList<Ingredient> ingredients;

    public Fridge(){
        this.ingredients = new ArrayList<>(); 
    }


    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void printAllIngredients(){
        for(Ingredient ingredient:this.ingredients){
            System.out.println("Name: "+ ingredient.getIngredientName()+", "+ "Amount: "+ ingredient.getIngredientAmout());
        }
    }

    public Ingredient getPositionInFridge(int position){
        return this.ingredients.get(position);
    }
    
}
