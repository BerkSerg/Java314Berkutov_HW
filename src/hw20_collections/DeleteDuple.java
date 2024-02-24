package hw20_collections;

import hw20_collections.extendedclasses.MyLinkedList;
import java.util.Random;

/**
 * Задача 3: Удаление дубликатов
 * Создайте список строк типа ArrayList или LinkedList, который содержит несколько дубликатов. Напишите код, который
 * удаляет все дубликаты из списка, оставляя только уникальные элементы. Выведите список после удаления дубликатов.
 */
public class DeleteDuple {
    public static void main(String[] args) {
        Random rnd = new Random();
        MyLinkedList<Integer> integerList = new MyLinkedList();
        for (int i = 0; i < 20; i++) {
            integerList.add(rnd.nextInt(1, 10));
        }
        System.out.println(integerList);

        integerList.deleteDuplicates();

        System.out.println(integerList);
    }
}
