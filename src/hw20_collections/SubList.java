package hw20_collections;

import hw20_collections.extendedclasses.MyArrayList;

import java.util.List;

/**
 * Задача 1: Извлечение подсписка
 * Создайте список строк типа ArrayList или LinkedList, содержащий несколько элементов. Напишите код, который извлекает
 * подсписок из исходного списка и выводит его на экран.
 */
public class SubList {
    public static void main(String[] args) {
        MyArrayList<String> stringList = new MyArrayList();
        String stringOne = "Напишите код который извлекает подсписок из исходного списка и выводит его на экран";
        stringList.addAll(List.of(stringOne.split(" ")));

        System.out.println(stringList.getSubList(2, 5));
    }
}


