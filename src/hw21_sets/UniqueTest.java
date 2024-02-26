package hw21_sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Задача 1: Проверка на уникальность
 * Напишите метод, который принимает на вход строку и проверяет, содержит ли она все уникальные символы. Метод должен
 * вернуть true, если все символы в строке уникальны, и false в противном случае.
 */
public class UniqueTest {
    public static void main(String[] args) {
        System.out.println(isStringContainsUniqueSymbols("sadf3q2eg"));
        System.out.println(isStringContainsUniqueSymbols("s3adf3q2eg"));
    }

    private static boolean isStringContainsUniqueSymbols(String testString) {
        Set<String> stringSet = new HashSet<>(List.of(testString.split("")));
        return (testString.length() == stringSet.size());
    }
}
