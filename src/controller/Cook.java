package controller;

import model.Menu;
import model.RecipeRepository;
import model.Vegetable;
import view.UI;

import java.util.*;

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
        try {
            salad = RecipeRepository.getRecipeOf(kindOfSalad);
            if(salad.isEmpty())throw new NullPointerException();
        }catch (NullPointerException ex){
            ui.showMessageToUser("data error");
        }
            ui.showMessageToUser(kindOfSalad.toString() + " SALAD COOKED");
            showSaladDetails(salad);
            ui.showSaladOptions();
    }

    private void showSaladDetails(Map<Vegetable, Integer> currentSalad) {
        StringBuilder sb = new StringBuilder();
        int sumCal = 0;
        int sumWeigth = 0;
        for(Map.Entry entry : currentSalad.entrySet()){
                Vegetable veg = (Vegetable) entry.getKey();
                int calories = calculateCalories(entry);
                int weight = (int)entry.getValue();
                sb.append(veg.getName() + "\t\t" +
                        veg.getType() + "\t\t" +
                        veg.getCaloriesIn100g() + "\t\t\t\t" +
                        String.valueOf(calories)+ "\t\t\t\t\t" +
                        String.valueOf(weight) + "\n");
                sumCal += calories;
                sumWeigth += weight;
        }
        sb.append("\n\t\t Weight of vegetables is " + String.valueOf(sumWeigth) + " g.");
        sb.append("\n\t\t Calories of vegetables is " + String.valueOf(sumCal) + " ccal.\n");
        ui.showMessageToUser("Name\t\tType\t\tCal in 100g\t\tCal in vegetable\tWeight");
        ui.showMessageToUser(sb.toString());
    }

    public void sortVegetables(boolean byWeight){
        List<Map.Entry<Vegetable, Integer>> list = new LinkedList<>();
        list.addAll(salad.entrySet());
        if(byWeight) {
            list.sort(Comparator.comparing(Map.Entry::getValue));
        }else {
            list.sort(Comparator.comparing(this::calculateCalories));
        }
        Map<Vegetable,Integer> linkedSalad = new LinkedHashMap<>();
        for(Map.Entry<Vegetable, Integer> entry : list){
            linkedSalad.put(entry.getKey(), entry.getValue());
        }
        salad = linkedSalad;
        showSaladDetails(salad);
        ui.showSaladOptions();
    }

    public void searchVegetable(int min, int max) {
        Map<Vegetable, Integer> found = new LinkedHashMap<>();
        for(Map.Entry<Vegetable, Integer> entry: salad.entrySet()){
            if(entry.getValue() >= min && entry.getValue() <= max){
                found.put(entry.getKey(), entry.getValue());
            }
        }
        if(found.isEmpty()){
            ui.showMessageToUser("No such veg");
        }else {
            showSaladDetails(found);
        }
        ui.showSaladOptions();
    }

    private Integer calculateCalories(Map.Entry<Vegetable, Integer> entry){
        float cal;
        cal = ((float) entry.getKey().getCaloriesIn100g() * entry.getValue() / 100);
        return Math.round(cal);
    }


}


