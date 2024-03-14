package hw26_streams;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 4.	Сортировка и поиск:
 * o	Создайте список целых чисел.
 * o	Отсортируйте его по убыванию.
 * o	Найдите первые 3 элемента после сортировки.
 */
public class Task4 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            numbers.add(rnd.nextInt(1, 100));
        }
        System.out.println(numbers);

        // тут предлагает заменить на Comparator.reverseOrder(), но пока не по фэншую...
        numbers.stream().sorted((a, b) -> b.compareTo(a)).limit(3).forEach(System.out::println);
    }
}
