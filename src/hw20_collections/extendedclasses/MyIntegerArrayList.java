package hw20_collections.extendedclasses;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyIntegerArrayList<E extends Integer> extends ArrayList {

    public void printMinAndMax() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        Integer element;
        for (int i = 0; i < size(); i++) {
            element = (Integer) get(i);
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        System.out.printf("Min element is '%d' and max element is '%d'", min, max);


    }


}
