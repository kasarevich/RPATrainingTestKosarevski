package controller;

import model.Menu;
import model.RecipeRepository;
import model.Vegetable;
import view.UI;

import java.util.Map;

public class Cook {
    private static Cook instance;
    private UI ui;
    private Map<Vegetable, Integer> salad;


    private Cook() {
    }

    public static synchronized Cook getInstance() {
        if (instance == null) {
            instance = new Cook();
        }
        return instance;
    }

    public void setUI(UI ui) {
        this.ui = ui;
        ui.showMainMenu();
    }

    public void prepareSalad(Menu kindOfSalad) {
        if (kindOfSalad != null) {
            salad = RecipeRepository.getRecipeOf(kindOfSalad);
            ui.showMessageToUser(kindOfSalad.toString() + " SALAD COOKED");
            showSaladDetails();
        } else {
            ui.showMessageToUser("Sorry, there is no such salad!");
        }
    }

    private void showSaladDetails() {
        StringBuilder sb = new StringBuilder();
        int sumCal = 0;
        int sumWeigth = 0;
        for(Map.Entry entry : salad.entrySet()){
                Vegetable veg = (Vegetable) entry.getKey();
                int calories = calculateCalories(veg, (int)entry.getValue());
                int weighth = (int)entry.getValue();
                sb.append(veg.getName() + "\t" + veg.getType() + "\t" + veg.getCaloriesIn100g() + " in 100 \t"
                        + String.valueOf(calories)+ "\t" + String.valueOf(weighth) + " g\n");
                sumCal += calories;
                sumWeigth += weighth;
        }
        sb.append("\n\t\t Weight of salad is" + String.valueOf(sumWeigth) + " g.");
        sb.append("\n\t\t Calories of salad is" + String.valueOf(sumCal) + " ccal.");

        ui.showMessageToUser(sb.toString());
    }

    private int calculateCalories(Vegetable vegetable, int weight){
        float cal;
        cal = ((float) vegetable.getCaloriesIn100g() * weight / 100);
        return (int)Math.round(cal);
    }
}


