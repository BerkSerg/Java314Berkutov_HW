package hw20_collections.extendedclasses;

import java.util.LinkedList;

public class MyLinkedList<E> extends LinkedList<E> {

    public void deleteDuplicates(){
        for (int i = 0; i < size(); i++){
            E elementOne = get(i);
            for(int j = i + 1; j < size(); j++){
                if(elementOne.equals(get(j))){
                    remove(j--);
                }
            }
        }
    }

}
