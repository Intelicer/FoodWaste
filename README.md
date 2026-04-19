# FoodWaste

FoodWaste is a Java console application for managing household ingredients and reducing food waste.
The application lets users track what they have in storage, maintain a recipe book, and discover what can be cooked from available ingredients.

This project is structured as a Maven project and includes unit tests using JUnit 5.

## Features

- Add ingredients to food storage with amount, measurement, price, and expiration date.
- Search and inspect ingredients in storage.
- Update ingredient amounts (use more or add more) and remove ingredients.
- List all ingredients in a table-style console view.
- Remove expired ingredients and inspect total storage value.
- Add recipes with description, instructions, servings, and required ingredients.
- Search recipes and check whether they are cookable with current storage.
- Suggest recipes that can be made from available ingredients.

## Tech Stack

- Java 21
- Maven
- JUnit Jupiter 5.10.2

## Project Structure

```text
FoodWaste/
	pom.xml
	README.md
	src/
		main/java/edu/ntnu/iir/bidata/
			FoodWasteApp.java
			entity/
				Ingredient.java
				Recipe.java
			logic/
				FoodStorage.java
				RecipeBook.java
			ui/
				UserInterface.java
			untility/
				ValidationUtil.java
		test/java/
			FoodStorageTest.java
			IngredientTest.java
			RecipeBookTest.java
			RecipeTest.java
```

## Requirements

- JDK 21 installed and available on PATH
- Maven 3.9+ installed and available on PATH

Check your versions:

```bash
java -version
mvn -version
```

## Build the Project

From the project root:

```bash
mvn clean compile
```

## Run the Application

The entry point is `edu.ntnu.iir.bidata.FoodWasteApp`.

1. Compile classes:

```bash
mvn clean compile
```

2. Run the app:

```bash
java -cp target/classes edu.ntnu.iir.bidata.FoodWasteApp
```

You can also run `FoodWasteApp.java` directly from your IDE.

## Run Tests

Run all tests:

```bash
mvn test
```

Run a single test class:

```bash
mvn -Dtest=FoodStorageTest test
```

## Core Components

- `FoodWasteApp`: main entry point.
- `UserInterface`: command-line menus and user interaction flow.
- `FoodStorage`: manages ingredient storage operations.
- `RecipeBook`: manages recipe storage operations.
- `Ingredient` and `Recipe`: domain entities.
- `ValidationUtil`: input validation utilities for console input.

## Known Limitations

- The application uses one local in-memory storage for ingredients.
- Data is not persisted between runs.
- The application is text-based (console UI only).
- Some sample/default data may be generated through the UI flow.

## References

- Baeldung: [Java Console ASCII Make Table](https://www.baeldung.com/java-console-ascii-make-table)
- W3Schools: [Java Arrays](https://www.w3schools.com/java/java_arrays.asp)
- GeeksforGeeks: [GeeksforGeeks](https://www.geeksforgeeks.org/)
- Markdown Guide: [Basic Syntax](https://www.markdownguide.org/basic-syntax/)
- Maven: [Maven Documentation](https://maven.apache.org/guides/index.html)
- JUnit: [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
