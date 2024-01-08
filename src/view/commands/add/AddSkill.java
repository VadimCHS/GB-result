package view.commands.add;

import view.ConsoleUI;
import view.commands.Command;

public class AddSkill extends Command{

    public AddSkill(ConsoleUI consoleUi) {
        super(consoleUi, "Добавить навык.");
    }

    @Override
    public void execute() {
        super.consoleUi.addSkill();
    }
    
}
