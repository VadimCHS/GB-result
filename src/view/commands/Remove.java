package view.commands;

import view.ConsoleUI;

public class Remove extends Command{
    public Remove(ConsoleUI consoleUi) {
        super(consoleUi, "Удалить животное из списка.");
    }

    @Override
    public void execute() {
        super.consoleUi.remove();
    }
}
