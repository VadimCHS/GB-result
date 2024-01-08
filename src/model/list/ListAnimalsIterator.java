package model.list;

import java.util.Iterator;
import java.util.List;

public class ListAnimalsIterator<E> implements Iterator<E>{
    private int index;
    private List<E> animalList;

    public ListAnimalsIterator(List<E> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return animalList.size() > index;
    }

    @Override
    public E next() {
        return animalList.get(index++);
    }
    
}
