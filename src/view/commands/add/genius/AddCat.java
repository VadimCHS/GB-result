package view.commands.add.genius;

import view.ConsoleUI;
import view.commands.Command;

public class AddCat extends Command{
        public AddCat(ConsoleUI consoleUi) {
        super(consoleUi, "Кошка");
    }

    @Override
    public void execute() {
        super.consoleUi.addAnimal("CAT");
    }
}
