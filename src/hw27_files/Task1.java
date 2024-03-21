package hw27_files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.Scanner;

/**
 * Задание 1:
 * 1.	Пользователь вводит с клавиатуры путь к файлу.
 * 2.	Программа считывает содержимое файла.
 * 3.	Программа анализирует содержимое файла и подсчитывает количество букв, чисел и знаков препинания.
 * 4.	Программа выводит на экран количество букв, чисел и знаков препинания в файле.
 */
public class Task1 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к файлу: ");

        //String filePath = scanner.nextLine();
        String filePath = "src/hw27_files/data/java.txt";
        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            System.out.println("Файла не существует");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

            int lettersCount = 0;
            int numbersCount = 0;
            int otherCount = 0;

            String line = br.readLine().toLowerCase();

            while (line != null) {
                for (int i = 0; i < line.length() - 1; i++) {
                    String currentLetter = String.valueOf(line.charAt(i));
                    if (currentLetter.matches("\\d")) {
                        numbersCount++;
                    } else if (currentLetter.matches("[a-zа-я]")) {
                        lettersCount++;
                    } else {
                        otherCount++;
                    }
                }
                line = br.readLine();
            }
            br.close();

            System.out.printf("Количество букв: %d\nКоличество цифр: %d\nКоличество знаков препинания: %d", lettersCount, numbersCount, otherCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
