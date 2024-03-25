package hw28_threads;


import hw28_threads.classes.MinMaxOfList;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Задача 1. Параллельный поиск в массиве:
 * •	Создайте массив целых чисел.
 * •	Разделите его на две части.
 * •	Создайте два потока для поиска максимального и минимального элементов в этих частях.
 * •	Верните результаты поиска.
 */
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
            listOfIntegers.add(rnd.nextInt(1, 1_000_000));
        }

        ArrayList<Integer> halfOne = new ArrayList<>(listOfIntegers.subList(0, listOfIntegers.size() / 2));
        ArrayList<Integer> halfTwo = new ArrayList<>(listOfIntegers.subList(listOfIntegers.size() / 2, listOfIntegers.size()));

        FutureTask<Integer[]> ftOne = new FutureTask<>(new MinMaxOfList(halfOne));
        FutureTask<Integer[]> ftTwo = new FutureTask<>(new MinMaxOfList(halfTwo));
        ftOne.run();
        ftTwo.run();

        try {
            System.out.println("Придется поверить на слово, что ");
            System.out.println("Минимальное и максимальное число в перовй половине листа: " + ftOne.get()[0] + " / " + ftOne.get()[1]);
            System.out.println("Минимальное и максимальное число во второй половине листа: " + ftTwo.get()[0] + " / " + ftTwo.get()[1]);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
