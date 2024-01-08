package view.commands.add.genius;

import view.ConsoleUI;
import view.commands.Command;

public class AddDonkey extends Command{
        public AddDonkey(ConsoleUI consoleUi) {
        super(consoleUi, "Осел");
    }

    @Override
    public void execute() {
        super.consoleUi.addAnimal("DONKEY");
    }
}
