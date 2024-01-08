
import java.io.IOException;

import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
    }
}
