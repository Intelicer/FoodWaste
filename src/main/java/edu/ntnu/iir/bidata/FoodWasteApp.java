package edu.ntnu.iir.bidata;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;







/**
 * The FoodWasteApp class is the main entry point for the Food Waste Management application.
 * It provides methods to start the application, create ingredients, display ingredients,
 * create recipes, and display recipes. The application interacts with the user through
 * console input and output.
 * 
 * <p>Classes used by FoodWasteApp:</p>
 * <ul>
 *   <li>FoodStorage: Manages the storage of ingredients.</li>
 *   <li>RecipeBook: Manages the collection of recipes.</li>
 *   <li>FoodWasteSystemPrints: Handles printing messages and prompts to the user.</li>
 * </ul>
 * 
 * <p>Fields:</p>
 * <ul>
 *   <li>foodStorage: An instance of FoodStorage for managing ingredients.</li>
 *   <li>recipeBook: An instance of RecipeBook for managing recipes.</li>
 *   <li>foodWasteSystemPrints: An instance of FoodWasteSystemPrints for printing messages.</li>
 *   <li>userInput: A Scanner object for reading user input from the console.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>FoodWasteApp(): Constructor that initializes the FoodWasteApp object.</li>
 *   <li>foodWasteAppStart(): Starts the application, displays a welcome message, and runs the main loop.</li>
 *   <li>createIngredient(): Facilitates the creation of an ingredient by interacting with the user.</li>
 *   <li>displayIngredients(): Displays all ingredients currently stored in the food storage.</li>
 *   <li>createRecipe(): Prompts the user to create a new recipe by entering details and ingredients.</li>
 *   <li>displayAllRecipes(): Displays all recipes stored in the recipe book.</li>
 * </ul>
 * 
 * 
 * 
 * 
 * @version 22.0.2
 * @author (Mahmoud Said Madhun Madhun)
*/

public class FoodWasteApp{

    //! Used Classes
    private FoodStorage foodStorage = new FoodStorage();
    private RecipeBook recipeBook = new RecipeBook();
    private FoodWasteSystemPrints foodWasteSystemPrints = new FoodWasteSystemPrints();
    private Scanner userInput = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 



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
                    foodWasteStart.checkIngredientExistensInStorage();
                    break;
                case 3:
                    foodWasteStart.displayIngredients();
                    break;
                case 4:
                    foodWasteStart.useIngredientExitstenInStorage();
                    break;
                case 5:
                    foodWasteStart.createRecipe();
                    break;
                case 6:
                    foodWasteStart.displayAllRecipes();
                    break;
                case 7:
                    foodWasteStart.getReadyToMakeRecipes();
                    break;
                case 9:
                    foodWasteStart.generateRecipesAndIngredients();
                    break;
                default: 
                    break;
            }
        }
    }
    
    


    /**
     * This method facilitates the creation of an ingredient by interacting with the user.
     * It repeatedly prompts the user for ingredient details until the user decides to stop.
     * 
     * <p>The method performs the following steps:</p>
     * <ul>
     *   <li>Prompts the user for the ingredient name and validates it.</li>
     *   <li>Prompts the user for the ingredient measurement type and validates it.</li>
     *   <li>Prompts the user for the ingredient amount and validates it.</li>
     *   <li>Creates an Ingredient object with the provided details and adds it to the food storage.</li>
     *   <li>Asks the user if they want to add more ingredients or exit the loop.</li>
     * </ul>
     * 
     * <p>Validation checks ensure that:</p>
     * <ul>
     *   <li>The ingredient name is not empty or blank.</li>
     *   <li>The ingredient measurement type is within the valid range (0-2).</li>
     *   <li>The ingredient amount is greater than 0.</li>
     * </ul>
     * 
     * <p>If the user decides to stop adding ingredients, the method exits the loop and terminates.</p>
     */
    public void createIngredient(){
        
        
        //? Declearing Loop and Insilizing it
        String userIngredientName;
        double userIngredientAmount;
        int userIngredientMeasurement;
        double userIngredientPrice;
        String userIngredientExpireDate;




        //Declearing Main Loop
        boolean addIngredientForever = true; //add ingredients loop
        //? A Loop to keep the program running until the user want to exit from it.
        while(addIngredientForever == true){
            //? Declearing Loop and Insilizing it
            boolean nameIsNotCorrect = true; //name is not correct
            //? User input has to be a valid Ingredient name
            foodWasteSystemPrints.askUserAboutIngredientName();
            userIngredientName = userInput.nextLine();
            //! Name Check Loop
            while (nameIsNotCorrect == true) {
                if ((userIngredientName.isEmpty() || userIngredientName.isBlank())){
                    foodWasteSystemPrints.alertNameInvalid();
                    userIngredientName = userInput.nextLine();
                }else{
                    nameIsNotCorrect = false;
                }
            }
            nameIsNotCorrect = true;



            //?Declearing Loop and Insilizing it
            boolean messurementDontExist = true; //messurement is a wrong value
            //? User input has to be a valid Ingredient Measurement Type
            foodWasteSystemPrints.askUserAboutIngredientMeasurementType();
            userIngredientMeasurement = userInput.nextInt();
            //! Measurement Check Loop
            while (messurementDontExist == true) { 
                if(userIngredientMeasurement < 0 || 2 < userIngredientMeasurement){ //! Types from 0-2 cause of array
                    foodWasteSystemPrints.alertMeasurmentTypeInvalid();
                    userIngredientMeasurement = userInput.nextInt();
                }else{
                    messurementDontExist = false;
                }
            }
            messurementDontExist = true;



            //?Declearing Loop and Insilizing it
            boolean amountInvalid = true;
            //? User input has to be a valid Ingredient Amount
            foodWasteSystemPrints.askUserAbouIngredientAmout();
            userIngredientAmount = userInput.nextDouble();
            //! Amount Check Loop
            while (amountInvalid == true) { 
                if(userIngredientAmount <= 0){
                    foodWasteSystemPrints.alertAmountInvalid();
                    userIngredientAmount = userInput.nextInt();
                }else{
                    amountInvalid = false;
                }
            }
            amountInvalid = true;


            //?Declearing Loop and Insilizing it
            boolean ingredientPriceInvalid = true;
            //? User input has to be a valid Ingredient Amount
            foodWasteSystemPrints.askUserAboutIngredientPrice();
            userIngredientPrice = userInput.nextDouble();
            //! Price Check Loop
            while (ingredientPriceInvalid == true) { 
                if(userIngredientPrice <= 0){
                    foodWasteSystemPrints.alertPriceInvalid();
                    userIngredientPrice = userInput.nextDouble();
                }else{
                    ingredientPriceInvalid = false;
                }
            }
            ingredientPriceInvalid = true;




            //?Declearing Loop and Insilizing it
            boolean ingredientExpireDate = true;
            //? User input has to be a valid date for ingreadient expireDate
            System.out.println("Write a expire date (yyyy-MM-dd):");
            userIngredientExpireDate = userInput.next();
            //! Amount Check Loop
            while (ingredientExpireDate == true) { 
                if(!dateFormat.format(userIngredientExpireDate).equals("yyyy-MM-dd")){ // ! in if statement means if i doest equal
                    System.out.println("Wrong format (yyyy-MM-dd)");
                    userIngredientExpireDate = userInput.nextLine();
                }else{
                    ingredientExpireDate = false;
                }
            }
            ingredientExpireDate = true;
            

   
            Ingredient Ingredient = new Ingredient(userIngredientName,userIngredientAmount, userIngredientMeasurement, userIngredientPrice,userIngredientExpireDate);
            foodStorage.addIngredient(Ingredient);
            

            //? Quit addIngredient Method.
            System.out.println("Press (N) or (n) if you are finished from adding and want to see your foodStorage.\nOr if you want to add more ingredients write anything.");
            char loopExit = userInput.next().charAt(0);
            userInput.nextLine(); //& runs the code so that we can add more ingredients without any skip lines
            if (loopExit == 'N' || loopExit == 'n'){
                addIngredientForever = false; //change value to get out of loop
            } 
        }
        addIngredientForever = true; //restore value so the user can use add ingredients again.

    }






    /**
     * Displays all ingredients stored in the food storage.
     * This method calls the displayAllIngredients() method of the foodStorage object
     * to print out the list of all ingredients currently available.
     */
    public void displayIngredients(){
        foodStorage.displayAllIngredients();
    }




    /**
     * Checks if an ingredient exists in the storage and prints its details.
     * 
     * <p>This method verifies if the specified ingredient exists in the storage.
     * If the ingredient exists, it prints the ingredient's details including name,
     * price, amount, measurement type, and expiration date. If the ingredient does
     * not exist, it prints a message indicating that the ingredient is not found.
     * 
     * @param nameOfIngredientTofind the name of the ingredient to find
     */
    public void checkIngredientExistensInStorage(){
        boolean nameOfIngredientTofindinvalid = true;
        if(foodStorage.checkStorageSize() == 0){
            System.out.println("\nThe storage are empty");
        }else{
            System.out.println("\nWhat are the ingredient u are searching for?");
            String nameOfIngredientTofind = userInput.nextLine();
            while (nameOfIngredientTofindinvalid == true) {
                if ((nameOfIngredientTofind.isEmpty() || nameOfIngredientTofind.isBlank())){
                    foodWasteSystemPrints.alertNameInvalid();
                    nameOfIngredientTofind = userInput.nextLine();
                }else{
                    nameOfIngredientTofindinvalid = false;
                }
            }
            foodStorage.checkIngredientExistensInStorage(nameOfIngredientTofind);
        }

    }




    /**
     * Uses a specified amount of an ingredient if it exists in the storage.
     * 
     * <p>This method checks if the storage is empty and prompts the user for the name of the ingredient
     * and the amount to use. It validates the input and uses the ingredient if it exists and the amount is valid.
     * 
     * @throws IllegalArgumentException if the amount to use is less than or equal to 0
     * @throws IllegalArgumentException if the amount to use is greater than the amount in storage
     */

    public void useIngredientExitstenInStorage(){
        boolean nameOfIngredientTofindInvalid = true;
        boolean AmoutOfIngredientToUseInvalid = true;
        if(foodStorage.checkStorageSize() == 0){
            System.out.println("\nThe storage are empty");
        }else{
            System.out.println("\nWhat are the ingredient u are searching for?");
            String nameOfIngredientTofind = userInput.nextLine();
            while (nameOfIngredientTofindInvalid == true) {
                if ((nameOfIngredientTofind.isEmpty() || nameOfIngredientTofind.isBlank())){
                    foodWasteSystemPrints.alertNameInvalid();
                    nameOfIngredientTofind = userInput.nextLine();
                }else{
                    nameOfIngredientTofindInvalid = false;
                }
            }

            foodStorage.checkIngredientExistensInStorage(nameOfIngredientTofind);


            System.out.println("\nWhat is the amount you want to use?");
            double AmoutOfIngredientToUse = userInput.nextDouble();
            while (AmoutOfIngredientToUseInvalid == true) {
                if (AmoutOfIngredientToUse <= 0 || AmoutOfIngredientToUse > foodStorage.checkIngredientAmountInStorage(nameOfIngredientTofind)){
                    foodWasteSystemPrints.alertAmountInvalid();
                    AmoutOfIngredientToUse = userInput.nextDouble();
                }else{
                    AmoutOfIngredientToUseInvalid = false;
                }
            }
            foodStorage.useIngredientExitstenInStorage(nameOfIngredientTofind,AmoutOfIngredientToUse);

        }
    }






    /**
     * Prompts the user to create a new recipe by entering the recipe name, description, 
     * and a list of ingredients with their respective amounts. The method continues to 
     * prompt for ingredients until the user indicates they are finished. The created 
     * recipe is then added to the recipe book.
     *
     * <p>Steps involved in creating a recipe:</p>
     * <ol>
     *   <li>Prompt the user for the recipe name.</li>
     *   <li>Prompt the user for the recipe description.</li>
     *   <li>Enter a loop to add ingredients and their amounts until the user decides to stop.</li>
     *   <li>Create a Recipe object with the provided details.</li>
     *   <li>Add the created Recipe object to the recipe book.</li>
     * </ol>
     *
     * <p>Note: The method assumes that the user input is handled correctly and does not 
     * include validation for the input values.</p>
    */
    public void createRecipe(){


        System.out.println("\nName of Recipe:");
        String userRecipeName = userInput.nextLine();
        System.out.println("Description of recipe::");
        String recipeDescription = userInput.nextLine();
        ArrayList<String> userIngredientsToMakeTheRecipe = new ArrayList<>();
        ArrayList<Double> userUsedAmountToMakeTheRecipe = new ArrayList<>();
        
        Boolean addIngredientToRecipe = true;
        while (addIngredientToRecipe == true) {
            
            
            System.out.println("\nName of Ingredient used in recipe:");
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

















    public void generateRecipesAndIngredients(){
        HashMap<String, Recipe> generatedRecipes;
    }



    /**
     * Displays all recipes stored in the recipe book.
     * This method delegates the task to the recipeBook's displayAllRecipes method.
    */
    public void displayAllRecipes(){
        recipeBook.displayAllRecipeInBook();
    }





    

    public void checkEnoughIngredientsToMakeRecipe(){
        recipeBook.getRecipeIngredientWithAmount();
    }



    public void getReadyToMakeRecipes(){

    }

    public void createRecipeAuto(){


    }






}
    


