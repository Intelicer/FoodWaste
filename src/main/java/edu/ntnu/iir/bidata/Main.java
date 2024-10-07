package edu.ntnu.iir.bidata;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/*
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */
public class Main {

    private Fridge fridge;
    Scanner userInput = new Scanner(System.in);  //& Create a Scanner 


    public Main(){
       this.fridge = new Fridge();
    }

    public void start(){
        
        boolean runForever = true;

        while(runForever == true){

            
            System.out.print("Ingredients Name? ");
            String ingredientName = userInput.nextLine();
            System.out.print("Amount? ");
            int ingredientAmount = userInput.nextInt();
            
            

            Ingredient Ingredient = new Ingredient(ingredientName, ingredientAmount);
            
            
            this.fridge.addIngredient(Ingredient);
            
            System.out.println("N/n to stop adding to the fridge, and i you want to continue type anything:");
            char loopExit = userInput.next().charAt(0);


            if (loopExit == 'N' || loopExit == 'n'){
                runForever = false;
            }
            
            
        }
        this.fridge.printAllIngredients();
    }

    
    public static void main(String arg[]){

        // Main main = new Main();
        // main.start();


        
        

        
    }
}
