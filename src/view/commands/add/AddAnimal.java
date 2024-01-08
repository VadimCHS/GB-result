package view.commands.add;

import view.ConsoleUI;
import view.commands.Command;
import view.menu.SubMenuAnimal;

public class AddAnimal extends Command{

    public AddAnimal(ConsoleUI consoleUi) {
        super(consoleUi, "Добавить животного.");
    }

    @Override
    public void execute() {
        super.consoleUi.menu(new SubMenuAnimal(consoleUi));
    }
    
}
