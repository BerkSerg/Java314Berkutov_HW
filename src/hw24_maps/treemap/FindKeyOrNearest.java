package hw24_maps.treemap;

import java.util.*;


/**
 * Задача 2.  Нахождение ближайшего ключа:
 * Дан TreeMap и ключ. Необходимо найти ключ, ближайший к заданному ключу. Это может быть как ключ, равный заданному,
 * так и ключ, находящийся ближе всего к заданному снизу или сверху.
 */
public class FindKeyOrNearest {
    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer, String> testMap = new TreeMap<>();
        for (int i = 0; i < 20; i++) {
            testMap.put(rnd.nextInt(1, 100), "");
        }

        System.out.println(testMap);

        int keyToFind = rnd.nextInt(2, 99);
        System.out.println("Ищем: " + keyToFind);

        if (testMap.containsKey(keyToFind)) {
            System.out.println("Ключ найден");
        } else {
            TreeSet<Integer> treeSet = new TreeSet<>(testMap.keySet());

            Integer low = treeSet.floor(keyToFind);
            if(low == null){
                System.out.println("Ближайший ключ: " + treeSet.first());
                return;
            }

            Integer high = treeSet.ceiling(keyToFind);
            if(high == null){
                System.out.println("Ближайший ключ: " + treeSet.last());
                return;
            }

            if ((keyToFind - low) > (high - keyToFind)) {
                System.out.println("Найден ближайший ключ: " + high);
            }else{
                System.out.println("Найден ближайший ключ: " + low);
            }

        }


    }
}
