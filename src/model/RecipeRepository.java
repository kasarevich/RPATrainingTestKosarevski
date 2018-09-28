package model;

import java.util.HashMap;
import java.util.Map;

public class RecipeRepository {
    public static Map<Integer, Vegetable>getRecipeOf(Menu menu){
        Map<Integer, Vegetable> recipe = new HashMap<>();
        switch (menu){
            case CAESAR: {
                recipe.put(200, new Vegetable("Cherry-tomato", 20, "fruit"));
                recipe.put(400, new Vegetable("Salad", 14, "greens"));
                recipe.put(20, new Vegetable("Garlic", 143, "greens"));
                recipe.put(50, new Vegetable("Lemon", 16, "fruit"));
                break;
            }
            case GREEK:{
                recipe.put(200, new Vegetable("Cherry-tomato", 20, "fruit"));
                recipe.put(100, new Vegetable("Salad", 14, "greens"));
                recipe.put(60, new Vegetable("Onion", 47, "greens"));
                recipe.put(40, new Vegetable("Lemon", 16, "fruit"));
                recipe.put(150, new Vegetable("Cucumber", 15, "fruit"));
                recipe.put(50, new Vegetable("Olives", 166, "fruit"));
                recipe.put(70, new Vegetable("Pepper", 27, "greens"));
                break;
            }
            case FRESH:{
                recipe.put(400, new Vegetable("Cabbage", 27, "greens"));
                recipe.put(120, new Vegetable("Pepper", 27, "greens"));
                recipe.put(100, new Vegetable("Carrot", 33, "greens"));
                break;
            }
            case FRUIT:{
                recipe.put(200, new Vegetable("Apple", 47, "fruit"));
                recipe.put(180, new Vegetable("Pear", 42, "fruit"));
                recipe.put(150, new Vegetable("Kiwi", 44, "fruit"));
                recipe.put(100, new Vegetable("Orange", 36, "fruit"));
                recipe.put(70, new Vegetable("Grape", 165, "fruit"));
                break;
            }
            default:{
                break;
            }
        }
        return recipe;
    }
}
