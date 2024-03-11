package hw24_maps.hashmap;

import java.util.HashMap;
import java.util.Map;


/**
 * Задача 1. Поиск подстроки с максимальной длиной без повторяющихся символов:
 * Дана строка. Необходимо найти длину самой длинной подстроки без повторяющихся символов. Для решения этой задачи можно
 * использовать HashMap, чтобы отслеживать индексы встречаемости каждого символа в строке.
 */
public class MaxSubString {
    public static void main(String[] args) {
        String testString = "apaoidjnvqwreuivhbquvpw";
        Map<Character, Integer> testMap = new HashMap<>();

        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < testString.length(); i++) {
            char symbol = testString.charAt(i);
            if (testMap.containsKey(symbol)) {
                start = Math.max(testMap.get(symbol) + 1, i);
            }
            maxLen = Math.max(maxLen, i - start + 1);
            testMap.put(symbol, i);
        }
        System.out.println(maxLen);
    }
}
