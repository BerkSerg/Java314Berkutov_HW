package hw28_threads;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Задача 5*. Четные и нечетные
 * •	Пользователь с клавиатуры вводит путь к файлу, содержащему набор чисел.
 * •	После чего запускаются две потока.
 * •	Первый поток создает новый файл, в который запишет только четные элементы массива.
 * •	Второй поток создает новый файл, в который запишет только нечетные элементы массива.
 * •	Количество четных и нечетных элементов возвращается в метод main.
 */
public class Task5 {
    public static void main(String[] args) {
        String path = "src/hw28_threads/data/numbers.txt";

        try {
            generateFileWithNumbers(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Читаем файл " + path);

        int[] resultArr = separateNumbers(path);
        System.out.printf("Количество четных элементов: %d;\nКоличество нечетных элементов: %d", resultArr[0], resultArr[1]);

    }

    private static int[] separateNumbers(String path) {
        int[] result = new int[2];
        String[] nameAndExt = Path.of(path).getFileName().toString().split("\\.");

        String data;
        try {
            data = Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread t1 = new Thread(() -> {
            List<Integer> even = Arrays.stream(data.split(",")).map(Integer::valueOf).filter(n -> n % 2 == 0).toList();
            result[0] = even.size();
            String evenResult = even.stream().map(String::valueOf).reduce("", (s1, s2) -> s1 + s2 + ",");
            try {
                saveStringToFile(evenResult, "src/hw28_threads/data/" + nameAndExt[0] + "_even." + nameAndExt[1]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();


        Thread t2 = new Thread(() -> {
            List<Integer> odd = Arrays.stream(data.split(",")).map(Integer::valueOf).filter(n -> n % 2 == 1).toList();
            result[1] = odd.size();
            String oddResult = odd.stream().map(String::valueOf).reduce("", (s1, s2) -> s1 + s2 + ",");
            try {
                saveStringToFile(oddResult, "src/hw28_threads/data/" + nameAndExt[0] + "_odd." + nameAndExt[1]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private static void generateFileWithNumbers(String path) throws IOException {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10_000; i++) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append(rnd.nextInt(0, 1000));
        }
        saveStringToFile(sb.toString(), path);
        System.out.println();
    }

    private static void saveStringToFile(String stringData, String path) throws IOException {
        System.out.println("Записываем файл " + path);
        FileWriter fw = new FileWriter(path);
        fw.write(stringData);
        fw.close();
    }
}
