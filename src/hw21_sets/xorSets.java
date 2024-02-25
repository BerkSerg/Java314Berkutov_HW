package hw21_sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Задача 4: Разность множеств
 * Напишите метод, который принимает на вход два множества Set и возвращает новое множество, содержащее только те
 * элементы, которые присутствуют только в одном из исходных множеств.
 */
public class xorSets {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>(List.of(new Integer[]{1, 2, 3, 4, 5, 6}));
        Set<Integer> secondtSet = new HashSet<>(List.of(new Integer[]{4, 5, 6, 7, 8, 9, 0}));

        System.out.println(xorSets(firstSet, secondtSet));
    }

    private static <E> Set<E> xorSets(Set<E> setOne, Set<E> setTwo) {
        Set<E> mergedSet = new HashSet<>();

        for (E element : setOne) {
            if (!setTwo.contains(element)) {
                mergedSet.add(element);
            }
        }
        for (E element : setTwo) {
            if (!setOne.contains(element)) {
                mergedSet.add(element);
            }
        }
        return mergedSet;
    }

}
