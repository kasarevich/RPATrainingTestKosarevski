package view;

import controller.Cook;
import model.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleUI implements UI {

    @Override
    public void showMainMenu() {
            System.out.println("\tEnter to cook:" +
                    "\n\t1 - Greek salad" +
                    "\n\t2 - Caesar salad" +
                    "\n\t3 - Fresh salad" +
                    "\n\t4 - Fruit salad" +
                    "\n\t0 - Exit.");
            String i = null;
            try {
                i = readChoise();
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
                    System.out.println("Good bye!");
                    break;
                }
                default: {
                    System.out.println("Incorrect input data");
                    showMainMenu();
                    break;
                }
            }
            if(salad!=null) {
                Cook.getInstance().prepareSalad(salad);
            }
    }

    @Override
    public void showSaladOptions() {
        System.out.println("\tEnter " +
                "\n\t1 to sort vegetables by weight" +
                "\n\t2 to sort vegetables by calories" +
                "\n\t3 to find vegetables" +
                "\n\t0 back to the main menu.");
        String i = null;
        try {
            i = readChoise();
        } catch (IOException e) {
            showMessageToUser(e.getMessage());
        }
        switch (i) {
            case "1": {
                Cook.getInstance().sortVegetables(true);
                break;
            }
            case "2": {
                Cook.getInstance().sortVegetables(false);
                break;
            }
            case "3": {
                showSearchMenu();
                break;
            }
            case "0": {
                showMainMenu();
                break;
            }
            default: {
                System.out.println("Incorrect input data");
                showSaladOptions();
                break;
            }
        }
    }


    @Override
    public void showSearchMenu() {
        int min = 0;
        int max = 0;
        try {
            System.out.println("Enter min weight");
            String minWeight = readChoise();
            min = Integer.parseInt(minWeight);
            System.out.println("Enter max weight");
            String maxWeight = readChoise();
            max = Integer.parseInt(maxWeight);
        }catch (NullPointerException np){
            //Fixme print only digits
            showMessageToUser("Enter data please");
            showSearchMenu();
        }catch (NumberFormatException numEx){
            //Fixme print only digits
            showMessageToUser("Enter a digits please");
            showSearchMenu();
        }catch (IOException ioEx){
            //Fixme ioEx
            showMessageToUser("Incorrect input data");
            showSearchMenu();
        }
        if(min != 0 || max != 0)
        Cook.getInstance().searchVegetable(min, max);
    }


    private String readChoise()throws IOException{
        String i = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            i = reader.readLine();
        return i;
    }

    @Override
    public void showMessageToUser(String message) {
        System.out.println(message);
    }

}
