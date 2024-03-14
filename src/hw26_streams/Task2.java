package hw26_streams;


import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2.	Трансформация данных:
 * o	Создайте список строк, представляющих числа в виде строк.
 * o	Преобразуйте этот список в список целых чисел.
 * o	Отфильтруйте только четные числа.
 * o	Преобразуйте их в строковое представление.
 * o	Соберите их в строку, разделенную запятыми.
 */
public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        TreeSet<String> numbersInString = new TreeSet<>();

        for (int i = 0; i < 20; i++) {
            numbersInString.add(String.valueOf(rnd.nextInt(1, 100)));
        }
        System.out.println(numbersInString);
        String result = numbersInString.stream()
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .map(String::valueOf)
                .reduce("", (a, b) -> a.equals("") ? b : a + "," + b);

        System.out.println(result);
    }
}
