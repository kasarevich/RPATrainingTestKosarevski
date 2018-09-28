import controller.Cook;
import view.ConsoleUI;
import view.UI;

public class App {
    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        Cook.getInstance().setUI(ui);
    }
}
