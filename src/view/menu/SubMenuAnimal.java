package view.menu;

import java.util.ArrayList;
import java.util.List;

import view.ConsoleUI;
import view.commands.Back;
import view.commands.Command;
import view.commands.add.genius.AddCamel;
import view.commands.add.genius.AddCat;
import view.commands.add.genius.AddDog;
import view.commands.add.genius.AddDonkey;
import view.commands.add.genius.AddHamster;
import view.commands.add.genius.AddHorse;

public class SubMenuAnimal implements Menu{
    private List<Command> commandList;

    public SubMenuAnimal(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();
        this.commandList.add(new AddCat(consoleUI));
        this.commandList.add(new AddDog(consoleUI));
        this.commandList.add(new AddHamster(consoleUI));
        this.commandList.add(new AddHorse(consoleUI));
        this.commandList.add(new AddCamel(consoleUI));
        this.commandList.add(new AddDonkey(consoleUI));
        this.commandList.add(new Back(consoleUI));
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
