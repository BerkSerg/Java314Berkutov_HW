package hw24_maps.hashmap;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Задача 3. Подсчет суммы значений всех ключей: Дана HashMap, где ключи - это строки, а значения - целые числа.
 * Необходимо найти сумму всех чисел, значения которых соответствуют ключам, содержащим определенную подстроку.
 */
public class KeysAmount {
    public static void main(String[] args) {
        Map<String, Integer> animalsCountMap = new HashMap<>();
        animalsCountMap.put("monkey", 15);
        animalsCountMap.put("snakes", 30);
        animalsCountMap.put("bears", 4);
        animalsCountMap.put("donkeys", 6);
        animalsCountMap.put("crocodiles", 7);
        animalsCountMap.put("birds", 100);
        animalsCountMap.put("squirrel", 20);

        String subStr = "d";

        int summ = 0;
        for(String key : animalsCountMap.keySet()){
            if(key.contains(subStr)){
                summ += animalsCountMap.get(key);
            }
        }
        System.out.println(summ);
    }
}
