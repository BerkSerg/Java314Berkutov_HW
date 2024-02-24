package hw20_collections.extendedclasses;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList<E> extends ArrayList {

    public List<E> getSubList(int indexFrom, int indexTo) {
        ArrayList<E> sublist = new ArrayList<>();
        for (int i = indexFrom; i < indexTo; i++) {
            sublist.add((E) this.get(i));
        }
        return sublist;
    }

}
