package edu.ntnu.iir.bidata;

public class FoodWasteSystemPrints {


    FoodWasteSystemPrints(){

    }


    /**
     * System response for the program
     */
    public void userReciveWelcomeToApplication(){
        System.out.println("Hello to your foodstorage");
        System.out.println("Here you will get a selection menu to make it easy for you :)");
    }
    public void  userReciveSelectionMenu(){
        System.out.println("\nSelection Menu:");
        System.out.println("1. Add Ingredients to food storage");
        System.out.println("2. Display ingredients in the food storage");
        System.out.println("3. View Recipes recipes that can be made.");
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
        System.out.println("Name cant be empty or blank");
        System.out.println("\n");
        System.out.println("\nIngredients Name? ");
    }

    public void alertMeasurmentTypeInvalid(){
        System.out.println("Name cant be empty or blank");
        System.out.println("\n");
        System.out.println("\nIngredients Name? ");
    }

    public void alertAmountInvalid(){
        System.out.println("Name cant be empty or blank");
        System.out.println("\n");
        System.out.println("\nIngredients Name? ");
    }

}





// foodWasteSystemPrints.userReciveWelcomeToApplication(); //Welcome Message to Application
