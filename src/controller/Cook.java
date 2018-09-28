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

    }

    private int calculateCalories(int weight, int calIn100){
        int cal;

        return cal;
    }
}


