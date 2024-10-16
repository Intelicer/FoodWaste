package edu.ntnu.iir.bidata;

import java.util.Scanner;
import java.util.ArrayList;





/**
 * The FoodWasteApp class is the main entry point for the Food Waste Management application.
 * It provides functionalities to manage food storage, create and display recipes, and interact
 * with the user through a console-based interface.
 * 
 * <p>Classes used:
 * <ul>
 *   <li>{@link FoodStorage}</li>
 *   <li>{@link RecipeBook}</li>
 *   <li>{@link FoodWasteSystemPrints}</li>
 * </ul>
 * 
 * <p>Fields:
 * <ul>
 *   <li>{@code foodStorage} - Manages the storage of food ingredients.</li>
 *   <li>{@code recipeBook} - Manages the collection of recipes.</li>
 *   <li>{@code foodWasteSystemPrints} - Handles printing messages and prompts to the user.</li>
 *   <li>{@code userInput} - Scanner object for reading user input from the console.</li>
 * </ul>
 * 
 * <p>Methods:
 * <ul>
 *   <li>{@link #FoodWasteApp()} - Constructor for initializing the FoodWasteApp.</li>
 *   <li>{@link #foodWasteAppStart()} - Starts the application, displays a welcome message, and runs the main loop.</li>
 *   <li>{@link #createIngredient()} - Prompts the user to add ingredients to the food storage.</li>
 *   <li>{@link #displayIngredients()} - Displays all ingredients currently stored in the food storage.</li>
 *   <li>{@link #createRecipe()} - Prompts the user to create a new recipe and add it to the recipe book.</li>
 *   <li>{@link #displayAllRecipes()} - Displays all recipes currently stored in the recipe book.</li>
 * </ul>
 * 
 * <p>Usage example:
 * <pre>
 * {@code
 * FoodWasteApp app = new FoodWasteApp();
 * app.foodWasteAppStart();
 * }
 * </pre>
 * 
 * <p>Note: This application interacts with the user through the console and requires user input
 * to navigate through the menu and perform actions.
 * 
 * @see FoodStorage
 * @see RecipeBook
 * @see FoodWasteSystemPrints
 */

public class FoodWasteApp{

    //! Used Classes
    private FoodStorage foodStorage = new FoodStorage();
    private RecipeBook recipeBook = new RecipeBook();
    private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();
    private Scanner userInput = new Scanner(System.in);



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
        //? Declearing Loop and Insilizing it
        boolean mainRunForever = true;
        int choosenSelection;
        //? Use of main class 
        FoodWasteApp foodWasteStart = new FoodWasteApp();
        foodWasteSystemPrints.userReciveWelcomeToApplication(); //Welcome Message to Application
        while (mainRunForever == true) {

            foodWasteSystemPrints.userReciveSelectionMenu(); //Selection Menu
            choosenSelection = userInput.nextInt();
            switch (choosenSelection) {
                case 1:
                    foodWasteStart.createIngredient();
                    break;
                case 2:
                    foodWasteStart.displayIngredients();
                    break;
                case 3:
                    foodWasteStart.createRecipe();
                case 4:
                    foodWasteStart.displayAllRecipes();
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

    public void createIngredient(){
        
        
        //? Declearing Loop and Insilizing it
        boolean addIngredientForever = true; //add ingredients loop
        String ingredientName;
        double ingredientAmount;
        int ingredientMeasurement;
        //? A Loop to keep the program running until the user want to exit from it.
        while(addIngredientForever == true){
            //? Declearing Loop and Insilizing it
            boolean nameIsNotCorrect = true; //name is not correct
            //? User input has to be a valid Ingredient name
            foodWasteSystemPrints.askUserAboutIngredientName();
            ingredientName = userInput.nextLine();
            //! Name Check Loop
            while (nameIsNotCorrect == true) {
                if ((ingredientName.isEmpty() || ingredientName.isBlank())){
                    foodWasteSystemPrints.alertNameInvalid();
                    ingredientName = userInput.nextLine();
                }else{
                    nameIsNotCorrect = false;
                }
            }
            nameIsNotCorrect = true;



            //?Declearing Loop and Insilizing it
            boolean messurementDontExist = true; //messurement is a wrong value
            //? User input has to be a valid Ingredient Measurement Type
            foodWasteSystemPrints.askUserAboutMeasurementType();
            ingredientMeasurement = userInput.nextInt();
            //? Measurement Check Loop
            while (messurementDontExist == true) { 
                if(ingredientMeasurement < 0 || 2 < ingredientMeasurement){ //! Types from 0-2 cause of array
                    foodWasteSystemPrints.alertMeasurmentTypeInvalid();
                    ingredientMeasurement = userInput.nextInt();
                }else{
                    messurementDontExist = false;
                }
            }
            messurementDontExist = true;



            //?Declearing Loop and Insilizing it
            boolean amountInvalid = true;
            //? User input has to be a valid Ingredient Amount
            foodWasteSystemPrints.askUserAboutAmout();
            ingredientAmount = userInput.nextDouble();
            //! Amount Check Loop
            while (amountInvalid == true) { 
                if(ingredientAmount <= 0){ //! Types from 0-2 cause of array
                    foodWasteSystemPrints.alertAmountInvalid();
                    ingredientAmount = userInput.nextInt();
                }else{
                    amountInvalid = false;
                }
            }
            amountInvalid = true;

   
            Ingredient Ingredient = new Ingredient(ingredientName,ingredientAmount, ingredientMeasurement, 0);
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





    public void createRecipe(){


        System.out.println("Name of Recipe:");
        String userRecipeName = userInput.nextLine();
        System.out.println("Description of recipe::");
        String recipeDescription = userInput.nextLine();
        ArrayList<String> userIngredientsToMakeTheRecipe = new ArrayList<>();
        ArrayList<Double> userUsedAmountToMakeTheRecipe = new ArrayList<>();
        
        Boolean addIngredientToRecipe = true;
        while (addIngredientToRecipe == true) {
            
            
            System.out.println("\n");
            System.out.println("Name of Ingredient used in recipe:");
            String userIngredientNamesForRecipe = userInput.nextLine();
            
            userIngredientsToMakeTheRecipe.add(userIngredientNamesForRecipe);
            
            System.out.println("Amount of that ingreadient");
            double userIngredientAmoutForRecipe = userInput.nextDouble();
            
            userUsedAmountToMakeTheRecipe.add(userIngredientAmoutForRecipe);
            
            
            
            
            
            System.out.println("Press (N) or (n) if you are finished.");
            char loopExit = userInput.next().charAt(0);
            userInput.nextLine(); //& runs the code so that we can add more ingredients without any skip lines
            if (loopExit == 'N' || loopExit == 'n'){
                addIngredientToRecipe = false;
            } 
            
        }
        addIngredientToRecipe = true;
        Recipe userRecipe = new Recipe(userRecipeName, recipeDescription, userIngredientsToMakeTheRecipe, userUsedAmountToMakeTheRecipe);
        recipeBook.addRecipe(userRecipe);


    }


    public void displayAllRecipes(){
        recipeBook.displayAllRecipes();
}



















}
    


