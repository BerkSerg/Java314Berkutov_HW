package hw29_syncthreads.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SyncSortLinkedList {
    private final LinkedList<Integer> listOfIntegers = new LinkedList<>();


    public void fillList() {
        Random rnd = new Random();
        for (int i = 0; i < 10_000; i++) {
            listOfIntegers.add(rnd.nextInt(1, 100_000));
        }
    }

    public int getSize(){
        return listOfIntegers.size();
    }

    public synchronized void sortPart(int from, int to) {
        System.out.println("sort part from " + from + " to " + to );
        List<Integer> newList = listOfIntegers.subList(from, to);
        newList.sort(Integer::compareTo);
        System.out.println(newList);
    }
}
