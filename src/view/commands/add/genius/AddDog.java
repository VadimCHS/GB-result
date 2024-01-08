package view.commands.add.genius;

import view.ConsoleUI;
import view.commands.Command;

public class AddDog extends Command{
       public AddDog(ConsoleUI consoleUi) {
        super(consoleUi, "Собака");
    }

    @Override
    public void execute() {
        super.consoleUi.addAnimal("DOG");
    }
}
