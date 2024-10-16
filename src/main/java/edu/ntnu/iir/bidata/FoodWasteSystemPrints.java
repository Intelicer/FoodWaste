package edu.ntnu.iir.bidata;

/**
 * The FoodWasteSystemPrints class provides methods to print various messages and menus
 * to the console for a food storage management application. It includes methods for
 * displaying welcome messages, selection menus, food storage contents, and prompts for
 * user input. Additionally, it provides alert messages for invalid input.
 * 
 * <p>Methods included in this class:</p>
 * <ul>
 *   <li>{@link #userReciveWelcomeToApplication()} - Prints a welcome message to the user.</li>
 *   <li>{@link #userReciveSelectionMenu()} - Prints the selection menu for the user.</li>
 *   <li>{@link #userReciveExitAddIngredientLoop()} - Prints a message prompting the user to exit the ingredient addition loop.</li>
 *   <li>{@link #userDisplayFoodStorage()} - Prints the current contents of the food storage.</li>
 *   <li>{@link #userDisplayRecipeBook()} - Placeholder method for displaying the recipe book.</li>
 *   <li>{@link #askUserAboutIngredientName()} - Prompts the user to enter the name of an ingredient.</li>
 *   <li>{@link #askUserAboutMeasurementType()} - Prompts the user to select a measurement type for an ingredient.</li>
 *   <li>{@link #askUserAboutAmout()} - Prompts the user to enter the amount of an ingredient.</li>
 *   <li>{@link #alertNameInvalid()} - Alerts the user that the entered name is invalid.</li>
 *   <li>{@link #alertMeasurmentTypeInvalid()} - Alerts the user that the entered measurement type is invalid.</li>
 *   <li>{@link #alertAmountInvalid()} - Alerts the user that the entered amount is invalid.</li>
 * </ul>
 * 
 * <p>Note: The {@link #userDisplayRecipeBook()} method is currently a placeholder and does not have an implementation.</p>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * FoodWasteSystemPrints prints = new FoodWasteSystemPrints();
 * prints.userReciveWelcomeToApplication();
 * prints.userReciveSelectionMenu();
 * }
 * </pre>
 * 
 * @see System#println(String)
 */
public class FoodWasteSystemPrints {


    FoodWasteSystemPrints(){

    }


    /**
     * System response for the program
     */
    public void userReciveWelcomeToApplication(){
        System.out.println("\nWelcome To Our FoodWaste Application");
        System.out.println("Here you will get a selection menu to make it easy for you :)");
    }
    public void  userReciveSelectionMenu(){
        System.out.println("\nSelection Menu:");
        System.out.println("1. Add Ingredients to food storage");
        System.out.println("2. Display ingredients in the food storage");
        System.out.println("3. Create Recipe");
        System.out.println("4. View Recipes");
        System.out.println("*: Type anything to exit.");
    }
    public void  userReciveExitAddIngredientLoop(){
        System.out.println("Press (N) or (n) if you are finished from adding and want to see your foodStorage.\nOr if you want to add more ingredients write anything.");
    }


    public void userDisplayFoodStorage(){
        System.out.println("\n");
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-16s  %-13s  %-15s |%n", " ","Ingredients"," ");
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-13s | %-13s | %-16s |%n", "Name", "Amount","Expires");
        System.out.println("----------------------------------------------------");
    }

    public void userDisplayRecipeBook(){

    }


    


    /**
     * Question to the user
     */
    public void askUserAboutIngredientName(){
        System.out.println("\nIngredients Name?");
    }
    public void askUserAboutMeasurementType(){
        System.out.println("\nWhat does it measure? (the number to the left) ");
        System.out.println("0. Unit/Units ");
        System.out.println("1. Gram ");
        System.out.println("2. Liter ");    
    }
    
    
    
    public void askUserAboutAmout(){
        System.out.println("\nAmount? ");
    }



    

    /**
     * Return messages to the user if there is any invalid info.
     */
    public void alertNameInvalid(){
        System.out.println("\nName cant be empty or blank");
        System.out.println("\nIngredients Name? ");
    }

    public void alertMeasurmentTypeInvalid(){
        System.out.println("\nName cant be empty or blank");
        System.out.println("\nIngredients Name? ");
    }

    public void alertAmountInvalid(){
        System.out.println("\nName cant be empty or blank");
        System.out.println("\nIngredients Name? ");
    }

}





// foodWasteSystemPrints.userReciveWelcomeToApplication(); //Welcome Message to Application
