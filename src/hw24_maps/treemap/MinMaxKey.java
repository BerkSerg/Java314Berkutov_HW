package hw24_maps.treemap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Задача 1. Нахождение наибольшего и наименьшего ключа:
 * Дан TreeMap. Необходимо найти наибольший и наименьший ключи в нем.
 */
public class MinMaxKey {
    public static void main(String[] args) {
        Map<String, Integer> testMap = new TreeMap<>();

        testMap.put("monkey", 15);
        testMap.put("snakes", 30);
        testMap.put("bears", 4);
        testMap.put("donkeys", 6);
        testMap.put("crocodiles", 7);
        testMap.put("birds", 100);
        testMap.put("squirrel", 20);

        printMinAndMaxKey(testMap);

        Map<Integer, String> testMapTwo = new TreeMap<>();
        testMapTwo.put(4, "four");
        testMapTwo.put(1, "one");
        testMapTwo.put(10, "ten");
        testMapTwo.put(7, "seven");
        testMapTwo.put(5, "five");
        testMapTwo.put(8, "eight");
        printMinAndMaxKey(testMapTwo);
    }

    private static<K extends Comparable<K>, V> void printMinAndMaxKey(Map<K, V> map){
        if(map.isEmpty()){
            System.out.println("map is empty");
            return;
        }
        SortedMap<K, V> sortedMap = new TreeMap<>(map);
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
    }
}
