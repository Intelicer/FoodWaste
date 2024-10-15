package edu.ntnu.iir.bidata;

import java.util.Scanner;





public class FoodWasteApp{

    // Selection loops
    boolean mainRunForever = true; //add ingredients Start
    boolean addIngredientForever = true; //add ingredients loop
    boolean messurementDontExist = true; //messurement is a wrong value
    // validation loops
    boolean nameIsNotCorrect = true; //name is not correct
    boolean amountInvalid = true; //messurement is a wrong value
    //foodStorage
    private FoodStorage foodStorage = new FoodStorage();
    //Create scanner
    Scanner userInput = new Scanner(System.in);  
    
    /**
     * Constructor for FoodWasteApp.
     * Initializes the foodStorage object.
    */
    public FoodWasteApp(){
    }

    /**
     * Starts the FoodWasteApp.
     * Displays a welcome message and a selection menu.
     * Runs the main loop of the application.
    */
    public void foodWasteAppStart(){
        int choosenSelection;
        //! Use of main class 
        FoodWasteApp foodWasteStart = new FoodWasteApp();
        System.out.println("Hello to your foodstorage");
        System.out.println("Here you will get a selection menu to make it easy for you :)");
        while (mainRunForever == true) {

            /*
             * Selection Menu 
            */

            System.out.println("\nSelection Menu:");
            System.out.println("1. Add Ingredients to food storage");
            System.out.println("2. Display ingredients in the food storage");
            System.out.println("3. View Recipes recipes that can be made.");
            System.out.println("*: Type anything to exit.");

            choosenSelection = userInput.nextInt();
            switch (choosenSelection) {
                case 1:
                    foodWasteStart.addIngredient();
                    break;
                case 2:
                    foodWasteStart.displayIngredients();
                    break;
                default: 
                    break;
            }
        }
    }
    
    
    
    


















    /**
     * Creates the selection that lets you add ingredients to the food storage.
     * This method runs a loop to continuously prompt the user to add ingredients
     * until the user decides to exit.
     * 
     * The method ensures that the ingredient name is valid (not empty or blank).
    */

    public void addIngredient(){
        
        
        //! LOOPS boolean variables start with value true
        String ingredientName;
        double ingredientAmount;
        int ingredientMeasurement;
        


        /*
         * A Loop to keep the program running until the user want to exit from it.
        */

        while(addIngredientForever == true){


            //? User input has to be a valid Ingredient name
            System.out.println("\nIngredients Name?");
            ingredientName = userInput.nextLine();
            //! Name Check Loop
            while (nameIsNotCorrect == true) {
                if ((ingredientName.isEmpty() || ingredientName.isBlank())){
                    System.out.println("Name cant be empty or blank");
                    System.out.println("\n");
                    System.out.println("\nIngredients Name? ");
                    ingredientName = userInput.nextLine();
                }else{
                    nameIsNotCorrect = false;
                }
            }
            nameIsNotCorrect = true;


            //? User input has to be a valid Ingredient Measurement Type
            System.out.println("\nWhat does it measure? (the number to the left) ");
            System.out.println("0. Unit/Units ");
            System.out.println("1. Gram ");
            System.out.println("2. Liter ");
            ingredientMeasurement = userInput.nextInt();
            //! Measurement Check Loop
            while (messurementDontExist == true) { 
                if(ingredientMeasurement < 0 || 2 < ingredientMeasurement){ //! Types from 0-2 cause of array
                    System.out.println("\nThere is only 3 measurements (the number to the left) ");
                    System.out.println("0. Pieces ");
                    System.out.println("1. Gram ");
                    System.out.println("2. Liter ");
                    ingredientMeasurement = userInput.nextInt();
                }else{
                    messurementDontExist = false;
                }
            }
            messurementDontExist = true;



            //? User input has to be a valid Ingredient Amount
            System.out.println("\nAmount? ");
            ingredientAmount = userInput.nextDouble();
            //! Amount Check Loop
            while (amountInvalid == true) { 
                if(ingredientAmount <= 0){ //! Types from 0-2 cause of array
                    System.out.println("\nThe cant be 0 or negative (Write a valid number.) ");
                    ingredientAmount = userInput.nextInt();
                }else{
                    amountInvalid = false;
                }
            }
            amountInvalid = true;

   
            Ingredient Ingredient = new Ingredient(ingredientName,ingredientAmount, ingredientMeasurement);
            foodStorage.addIngredient(Ingredient);
            

            //? Quit addIngredient Method.
            System.out.println("Press (N) or (n) if you are finished from adding and want to see your foodStorage.\nOr if you want to add more ingredients write anything.");
            char loopExit = userInput.next().charAt(0);
            userInput.nextLine(); //& runs the code so that we can add more ingredients without any skip lines
            if (loopExit == 'N' || loopExit == 'n'){
                addIngredientForever = false;
            } 
        }
        addIngredientForever = true;

    }
















    /**
     * Displays all the ingredients currently stored in the food storage.
     * This method retrieves the list of ingredients from the foodStorage object
     * and prints each ingredient's details to the console.
    */
    public void displayIngredients(){
                foodStorage.displayAllIngredients();
    }

    
}
