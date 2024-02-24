package hw20_collections;

import hw20_collections.extendedclasses.MyIntegerArrayList;
import java.util.Random;

/**
 * Задача 2: Поиск минимума и максимума
 * Создайте список чисел типа ArrayList или LinkedList, заполните его несколькими числами. Напишите код, который
 * находит минимальный и максимальный элементы в списке и выводит их на экран.
 */

public class MinAndMax {
    public static void main(String[] args) {
        Random rnd = new Random();
        MyIntegerArrayList<Integer> linkedList = new MyIntegerArrayList<>();
        for (int i = 0; i < 100; i++) {
            linkedList.add(rnd.nextInt(1, 1000));
        }
        linkedList.printMinAndMax();
    }
}
