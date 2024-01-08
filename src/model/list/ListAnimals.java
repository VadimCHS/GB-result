package model.list;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

import model.animals.AnimalsInterface;

public class ListAnimals<E extends AnimalsInterface> implements Iterable<E>{
    private List<E> animals;

    public ListAnimals() {
        this.animals = new ArrayList<>();
    }

    public boolean addAnimal(E animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public E getAnimalById(int id) {
        for (E animal : this.animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%s  %-7s       %s             %s",
                        "id", "Имя","Навыки","Дата рождения");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatter);
        stringBuilder.append("\n");
        for (E animal : animals) {
            stringBuilder.append(animal);
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListAnimalsIterator<>(animals);
    }

    public boolean checkId(int id) {
        for (E animal : this.animals) {
            if (animal.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void remove(int id) {
        this.animals.remove(getAnimalById(id));
    }

}
