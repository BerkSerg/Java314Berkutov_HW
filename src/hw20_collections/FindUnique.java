package hw20_collections;

import hw20_collections.extendedclasses.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Задача 4*: Поиск уникального элемента
 * Предположим, у вас есть список целых чисел. Некоторые из чисел встречаются в списке дважды, а одно число встречается
 * только один раз. Ваша задача - найти это уникальное число.
 * Напишите метод, который принимает на вход список целых чисел и возвращает уникальное число из списка.
 */

public class FindUnique {
    public static void main(String[] args) {
        Random rnd = new Random();

        int uniqueNumber = rnd.nextInt(100, 500);

        LinkedList<Integer> integerList = new LinkedList();
        for (int i = 0; i < 20; i++) {
            integerList.add(rnd.nextInt(1, 5));
        }
        integerList.add(rnd.nextInt(0, integerList.size()), uniqueNumber);

        System.out.println(integerList);

        Integer unique = findUnique(integerList);
        System.out.println((unique == null) ? "Unique element didn`t find or found more than one" : "Unique element is: " + unique);
    }


    private static Integer findUnique(List list) {
        List<Integer> notUniqueList = new ArrayList<>();
        Integer unique = null;
        Integer element;
        for (int i = 0; i < list.size(); i++) {
            boolean isUnique = true;
            element = (Integer) list.get(i);
            if (notUniqueList.contains(element)) {
                continue;
            }
            for (int j = i + 1; j < list.size(); j++) {
                if (element.equals(list.get(j))) {
                    isUnique = false;
                    notUniqueList.add(element);
                    break;
                }
            }
            if (isUnique) {
                if (unique != null) {
                    return null;
                }
                unique = element;
            }
        }
        return unique;
    }
}
