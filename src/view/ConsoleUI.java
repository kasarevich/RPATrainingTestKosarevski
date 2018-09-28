package view;

import model.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI implements UI {
    @Override
    public void showMainMenu() {
            System.out.println("\tEnter to cook:" +
                    "\n\t1 - Greec salad" +
                    "\n\t2 - Caesar salad" +
                    "\n\t3 - Fresh salad" +
                    "\n\t4 - Fruit salad" +
                    "\n\t0 - Exit.");
            String i = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                i = reader.readLine();
            } catch (IOException e) {
                showMessageToUser(e.getMessage());
            }
            Menu salad = null;
            switch (i) {
                case "1": {
                    salad = Menu.GREEK;
                    break;
                }
                case "2": {
                    salad = Menu.CAESAR;
                    break;
                }
                case "3": {
                    salad = Menu.FRESH;
                    break;
                }
                case "4": {
                    salad = Menu.FRUIT;
                    break;
                }
                case "0": {
                    System.out.println("Завершение работы...");
                    break;
                }
                default: {
                    System.out.println("Неверный ввод!");
                    showMainMenu();
                    break;
                }
            }
            //Fixme manager.prepare(salad);
            if(salad!=null) {
                showMessageToUser(salad.toString());
                showSaladOptions();
            }
    }

    @Override
    public void showSaladOptions() {
        System.out.println("\tEnter " +
                "\n\t1 to sort vegetables by weight" +
                "\n\t2 to sort vegetables by calories" +
                "\n\t3 to find vegetables" +
                "\n\t0 - exit to main menu.");
        String i = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            i = reader.readLine();
        } catch (IOException e) {
            showMessageToUser(e.getMessage());
        }
        switch (i) {
            case "1": {
                sortByWeight();
                break;
            }
            case "2": {
                sortByCalories();
                break;
            }
            case "3": {
                findVegetables();
                break;
            }
            case "0": {
                System.out.println("Завершение работы...");
                //Fixme продумать выход
                break;
            }
            default: {
                System.out.println("Неверный ввод!");
                showSaladOptions();
                break;
            }
        }
    }

    private void findVegetables() {
        showMessageToUser("find");
    }

    private void sortByCalories() {
        showMessageToUser("by cal");
    }

    private void sortByWeight() {
        showMessageToUser("by weight");
    }

    @Override
    public void showSortedVegetables() {

    }

    @Override
    public void showSearchMenu() {

    }

    @Override
    public void showMessageToUser(String message) {
        System.out.println(message);
    }
}
