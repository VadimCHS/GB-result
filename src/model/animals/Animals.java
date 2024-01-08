package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public abstract class Animals implements AnimalsInterface{
    protected int id;
    protected String name;
    protected List<String> skills;
    protected LocalDate dateOfBirth;

    Animals(int id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.skills = new ArrayList<>();
        this.dateOfBirth = dateOfBirth; 
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    // Добавление навыков
    public void addSkills(String skill) {
        this.skills.add(skill);
    }

    @Override
    public String toString() { 
        StringBuilder string = new StringBuilder();
        for (String skill : skills) {
            string.append(skill);
        }        
        Formatter formatter = new Formatter();
        formatter.format("%-3s %-10s    %-10s         %-15s",
                         id, name, string.toString(), dateOfBirth);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatter);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    
}
