package hw26_streams;


import java.util.Random;
import java.util.TreeSet;

/**
 * 6.	Параллельная обработка:
 * o	Создайте список чисел от 1 до 1000.
 * o	Используя параллельный поток, найдите сумму квадратов всех чисел.
 * o	Сравните время выполнения с обычным потоком.
 */
public class Task6 {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        int res =0;
        for (int i = 1; i < 150001; i++) {
            numbers.add(i);
        }

        long start = System.currentTimeMillis();
        long result = numbers.stream().reduce(0, (x,y) -> x + (y * y));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);

        long start2 = System.currentTimeMillis();
        long result2 = numbers.parallelStream().reduce(0, (x,y) -> x + (y * y));
        System.out.println(System.currentTimeMillis() - start2);
        System.out.println(result2);

        /**Поэкспериментировал:
         * На небольших данных(мало элементов) работает одинаково, плюс-минус...
         * Но на больших данных (много элементов) параллельныйе потоки работают дольше, так как разделение на потоки и
         *  соединение обратно занимает дополнительное время, чем больше данных тем сложнее разделять и собирать обратно.
         *
         *  Получается, что параллельные потоки выгодно использовать только в случае сложных вычислений, а для простых, типа
         *  квадрата двух чисел, лучше использовать обычные потоки
         */


    }
}
