package controller;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Service;
import model.animals.AnimalsGenius;
import view.View;

public class Controller {
    private final String PATH_TOY = "Toys.out";

    private Service service;
    private View view;

    public Controller(View view) {
        this.service = new Service(this.PATH_TOY);
        this.view = view;
    }

    public void addAnimal(String name, String dateOfBirth, String genus) {
        service.addAnimal(name, convertLocalDate(dateOfBirth), AnimalsGenius.valueOf(genus));
        view.printAnswer("Животное добавлено.");
    }

    private LocalDate convertLocalDate(String locaDate) {
        Pattern pattern = Pattern.compile("(\\d{4})[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(locaDate);
        if (matcher.find()) {
            return LocalDate.parse(locaDate);
        }
        return null;
    }

    public void getAnimalsList() {
        this.view.printAnswer(this.service.getAnimalsList());
    }

    public void addSkill(int id, String skill) {
        this.service.addSkill(id, skill);
    }

    public boolean checkId(int id) {
        return this.service.checkId(id);
    }

    public void remove(int id) {
        this.service.remove(id);
    }
}
