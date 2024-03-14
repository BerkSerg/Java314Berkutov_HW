package hw26_streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * 5.	Обработка данных из файла:
 * o	Прочитайте содержимое текстового файла в список строк.
 * o	Используя Stream, отфильтруйте только те строки, которые содержат определенное слово.
 * o	Подсчитайте количество строк, соответствующих условию.
 */
public class Task5 {
    public static void main(String[] args) {

        List<String> listOfStrings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src\\hw26_streams\\data\\SimpleTextFile.txt"));
            while (scanner.hasNextLine()){
                listOfStrings.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String strForFilter = "список";
        Predicate<String> filter = s -> s.toLowerCase().contains(strForFilter);

        listOfStrings.stream().filter(filter).forEach(System.out::println);

    }
}
