package hw29_syncthreads;

import hw29_syncthreads.classes.SyncSearchArrayList;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        SyncSearchArrayList syncArrayList = new SyncSearchArrayList();
        Random rnd = new Random();

        syncArrayList.fillList();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int numberToFind = rnd.nextInt(2, 2000);
                if (syncArrayList.findNumber(numberToFind)) {
                    System.out.println(Thread.currentThread().getName() + " номер " + numberToFind + " найден");
                } else {
                    System.out.println(Thread.currentThread().getName() + " номер " + numberToFind + " не найден");
                }
            }).start();
        }

    }
}
