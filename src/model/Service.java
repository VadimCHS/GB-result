package model;

import java.time.LocalDate;

import model.animals.Animals;
import model.animals.AnimalsGenius;
import model.animals.Camel;
import model.animals.Cat;
import model.animals.Dog;
import model.animals.Donkey;
import model.animals.Hamster;
import model.animals.Horse;
import model.list.ListAnimals;

public class Service {
    private int id;
    private ListAnimals<Animals> listAnimals;
    private String path;

    public Service(String path) {
        this.id = 1;
        this.listAnimals = new ListAnimals<>();
        this.path = path;
    }

    public void addAnimal (String name, LocalDate dateOfBirth, AnimalsGenius genus) {
        switch (genus) {
            case CAT -> this.listAnimals.addAnimal(new Cat(id++, name, dateOfBirth));
            case DOG -> this.listAnimals.addAnimal(new Dog(id++, name, dateOfBirth));
            case HAMSTER -> this.listAnimals.addAnimal(new Hamster(id++, name, dateOfBirth));
            case HORSE -> this.listAnimals.addAnimal(new Horse(id++, name, dateOfBirth));
            case CAMEL -> this.listAnimals.addAnimal(new Camel(id++, name, dateOfBirth));
            case DONKEY -> this.listAnimals.addAnimal(new Donkey(id++, name, dateOfBirth));
        };
    }

    public String getAnimalsList() {
        return listAnimals.toString();
    }

    public void addSkill(int id, String skill) {
        this.listAnimals.getAnimalById(id).addSkills(skill);
    }

    public boolean checkId(int id) {
        return this.listAnimals.checkId(id);
    }

    public void remove(int id) {
        this.listAnimals.remove(id);
    }
}
