package hw24_maps.hashmap;

import java.util.*;

/**
 * Задача 2. Группировка анаграмм слов: Дан массив строк. Необходимо сгруппировать все анаграммы слов в массиве.
 * Для этого можно использовать HashMap, где ключами будут отсортированные версии слов, а значениями - списки слов,
 * которые являются анаграммами друг друга.
 */
public class AnagramGroup {
    public static void main(String[] args) {
        String[] wordsArray = {"катер", "барк", "актер", "мор", "дура", "вор", "брак", "терка", "раб", "краб", "руда",
                "бра", "бар", "ров", "удар", "ром"};

        Map<String, ArrayList<String>> anagramsMap = new HashMap<>();

        for (String word : wordsArray) {

            char[] wordToSort = word.toCharArray();
            Arrays.sort(wordToSort);
            String wordSorted = String.copyValueOf(wordToSort);

            if (anagramsMap.containsKey(wordSorted)) {
                anagramsMap.get(wordSorted).add(word);

            } else {
                anagramsMap.put(wordSorted, new ArrayList<>());
                anagramsMap.get(wordSorted).add(word);
            }
        }
        anagramsMap.values().forEach((v) -> System.out.println(v));
    }
}
