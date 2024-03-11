package hw24_maps.treemap;

import java.util.*;
import java.util.function.Predicate;


/**
 * Задача 3.  Итерация по диапазону ключей:
 * Дан TreeMap и два ключа. Необходимо найти итератор по всем элементам, ключи которых находятся в заданном диапазоне.
 */
public class GetSubMap {
    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer, Integer> testMap = new TreeMap<>();
        for (int i = 0; i < 20; i++) {
            int nextrnd = rnd.nextInt(1, 100);
            testMap.put(nextrnd, nextrnd);
        }
        System.out.println(testMap);

        TreeSet<Integer> set = new TreeSet<>(testMap.keySet());
        Set<Integer> subsetKeys = set.subSet(15, 40);

        for (Integer key : subsetKeys){
            System.out.println(testMap.get(key));
        }
    }
}
