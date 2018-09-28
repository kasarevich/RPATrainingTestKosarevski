package controller;

import view.UI;

public class Cook {
    private static Cook instance;
    private UI ui;


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
    }

}
