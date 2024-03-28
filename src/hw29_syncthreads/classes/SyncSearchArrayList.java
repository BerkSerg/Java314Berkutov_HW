package hw29_syncthreads.classes;

import java.util.ArrayList;
import java.util.Random;

public class SyncSearchArrayList {
    private final ArrayList<Integer> listOfIntegers = new ArrayList<>();


    public void fillList(){
        Random rnd = new Random();

        for (int i = 0; i < 10_000; i++) {
            listOfIntegers.add(rnd.nextInt(1, 1000));
        }
    }
    public synchronized boolean findNumber(int number){
        return listOfIntegers.contains(number);
    }

}
