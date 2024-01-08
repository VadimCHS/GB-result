package model.animals;

import java.time.LocalDate;

public class HomeAnimals extends Animals{

    enum Type {
        CAT, DOG, HAMSTER
    }

    HomeAnimals(int id, String name, LocalDate dateOfBirth) {
        super(id, name,  dateOfBirth);
    }
}
