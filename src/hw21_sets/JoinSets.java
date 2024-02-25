package hw21_sets;

import java.util.*;


/**
 * Задача 2: Объединение множеств
 * Напишите метод, который принимает на вход два множества Set и возвращает новое множество, содержащее все элементы из
 * обоих исходных множеств.
 */
public class JoinSets {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>(List.of(new Integer[]{1, 2, 3, 4, 5}));
        Set<Integer> secondtSet = new HashSet<>(List.of(new Integer[]{5, 6, 7, 8, 9, 0}));

        System.out.println(joinSets(firstSet, secondtSet));
    }

    private static <E> List<E> joinSets(Set<E> setOne, Set<E> setTwo) {
        List<E> newList = new ArrayList<>();
        newList.addAll(setOne);
        newList.addAll(setTwo);
        return newList;
    }
}
