package model;

import java.util.HashMap;
import java.util.Map;

public class RecipeRepository {
    public static Map<Vegetable, Integer>getRecipeOf(Menu menu){
        Map<Vegetable, Integer> recipe = new HashMap<>();       //Vegetable, Weight
        switch (menu){
            case CAESAR: {
                recipe.put(new Vegetable("Cherry-tomato", 20, "fruit"), 200);
                recipe.put(new Vegetable("Salad", 14, "greens"), 400);
                recipe.put(new Vegetable("Garlic", 143, "greens"), 20);
                recipe.put(new Vegetable("Lemon", 16, "fruit"), 50);
                break;
            }
            case GREEK:{
                recipe.put(new Vegetable("Cherry-tomato", 20, "fruit"), 200);
                recipe.put(new Vegetable("Salad", 14, "greens"), 100);
                recipe.put(new Vegetable("Onion", 47, "greens"), 60);
                recipe.put(new Vegetable("Lemon", 16, "fruit"), 40);
                recipe.put(new Vegetable("Cucumber", 15, "fruit"), 150);
                recipe.put(new Vegetable("Olives", 166, "fruit"), 50);
                recipe.put(new Vegetable("Pepper", 27, "greens"), 70);
                break;
            }
            case FRESH:{
                recipe.put(new Vegetable("Cabbage", 27, "greens"), 400);
                recipe.put(new Vegetable("Pepper", 27, "greens"), 120);
                recipe.put(new Vegetable("Carrot", 33, "greens"), 100);
                break;
            }
            case FRUIT:{
                recipe.put(new Vegetable("Apple", 47, "fruit"), 200);
                recipe.put(new Vegetable("Pear", 42, "fruit"), 180);
                recipe.put(new Vegetable("Kiwi", 44, "fruit"), 150);
                recipe.put(new Vegetable("Orange", 36, "fruit"), 100);
                recipe.put(new Vegetable("Grape", 165, "fruit"), 70);
                break;
            }
            default:{
                break;
            }
        }
        return recipe;
    }
}
