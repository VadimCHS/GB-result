package view.commands.add.genius;

import view.ConsoleUI;
import view.commands.Command;

public class AddHorse extends Command{
       public AddHorse(ConsoleUI consoleUi) {
        super(consoleUi, "Лошадь");
    }

    @Override
    public void execute() {
        super.consoleUi.addAnimal("HORSE");
    }
}
