package hw21_sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Задача 3: Пересечение множеств
 * Напишите метод, который принимает на вход два множества Set и возвращает новое множество, содержащее только те
 * элементы, которые присутствуют в обоих исходных множествах.
 */
public class MergeSets {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>(List.of(new Integer[]{1, 2, 3, 4, 5, 6}));
        Set<Integer> secondtSet = new HashSet<>(List.of(new Integer[]{4, 5, 6, 7, 8, 9, 0}));

        System.out.println(mergeSets(firstSet, secondtSet));
    }

    private static <E> Set<E> mergeSets(Set<E> setOne, Set<E> setTwo) {
        Set<E> mergedSet = new HashSet<>();
        mergedSet.addAll(setOne);
        mergedSet.addAll(setTwo);
        return mergedSet;
    }
}
