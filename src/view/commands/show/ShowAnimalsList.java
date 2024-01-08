package view.commands.show;
import view.ConsoleUI;
import view.commands.Command;

public class ShowAnimalsList extends Command{

    public ShowAnimalsList(ConsoleUI consoleUi) {
        super(consoleUi, "Показать список животных.");
    }
    
    @Override
    public void execute() {
        super.consoleUi.getAnimalsList();
    }
}
