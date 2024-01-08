package view.commands.add.genius;

import view.ConsoleUI;
import view.commands.Command;

public class AddHamster extends Command{
       public AddHamster(ConsoleUI consoleUi) {
        super(consoleUi, "Хомяк");
    }

    @Override
    public void execute() {
        super.consoleUi.addAnimal("HAMSTER");
    }
}
