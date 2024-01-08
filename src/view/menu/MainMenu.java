package view.menu;

import java.util.ArrayList;
import java.util.List;

import view.ConsoleUI;
import view.commands.Command;
import view.commands.Finish;
import view.commands.Remove;
import view.commands.add.AddAnimal;
import view.commands.add.AddSkill;
import view.commands.show.ShowAnimalsList;

public class MainMenu implements Menu{
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();
        this.commandList.add(new AddAnimal(consoleUI));
        this.commandList.add(new Remove(consoleUI));
        this.commandList.add(new ShowAnimalsList(consoleUI));
        this.commandList.add(new AddSkill(consoleUI));
        this.commandList.add(new Finish(consoleUI));
    }

    @Override
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int getSize() {
        return commandList.size();
    }

    @Override
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }
}
