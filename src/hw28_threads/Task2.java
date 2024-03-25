package hw28_threads;


import hw28_threads.classes.SummOfArray;

import java.util.ArrayList;
import java.util.Random;


/**
 * Задача 2. Сумма элементов в массиве:
 * •	Создайте массив целых чисел.
 * •	Разделите его на несколько частей.
 * •	Создайте несколько потоков для вычисления суммы элементов в каждой части массива.
 * •	Суммируйте результаты вычислений каждого потока и верните общую сумму.
 */
public class Task2 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] intArray = new int[30_000];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rnd.nextInt(1, 1000);
            //intArray[i] = 1;
        }

        ArrayList<SummOfArray> threads = new ArrayList<>();

        threads.add(new SummOfArray(intArray, 0, 10_000));
        threads.add(new SummOfArray(intArray, 10_001, 20_000));
        threads.add(new SummOfArray(intArray, 20_001, 29_999));

        threads.forEach(Thread::start);

        int result = 0;
        try {
            for (SummOfArray thread : threads) {
                thread.join();
                result += thread.getSumm();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Сумма элементов массива: " + result);
    }
}
