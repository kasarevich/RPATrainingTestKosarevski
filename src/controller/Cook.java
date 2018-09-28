package controller;

import model.Menu;
import model.Vegetable;
import view.UI;

import java.util.Map;

public class Cook {
    private static Cook instance;
    private UI ui;
    private Map<Integer, Vegetable> salad;


    private Cook(){

    }
    public static synchronized Cook getInstance(){
        if (instance == null){
            instance = new Cook();
        }
        return instance;
    }
    public void setUI(UI ui){
        this.ui = ui;
        ui.showMainMenu();
    }
    public void prepareSalad(Menu kindOfSalad){
        if(kindOfSalad!=null){
            //Fixme request to the model
        }else {
            ui.showMessageToUser("Sorry, there is no such salad!");
        }
    }

}
