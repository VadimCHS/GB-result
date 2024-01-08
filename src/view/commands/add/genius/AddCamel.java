package view.commands.add.genius;

import view.ConsoleUI;
import view.commands.Command;

public class AddCamel extends Command{
        public AddCamel(ConsoleUI consoleUi) {
        super(consoleUi, "Верблюд");
    }

    @Override
    public void execute() {
        super.consoleUi.addAnimal("CAMEL");
    }
}
