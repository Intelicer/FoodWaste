package edu.ntnu.iir.bidata;

import java.util.Map;

public class Recipe {
    private String name;
    private Map<String, String> ingredients;

    public Recipe(String name, Map<String, String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getIngredients() {
        return ingredients;
    }
}