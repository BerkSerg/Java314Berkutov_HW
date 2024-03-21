package hw27_files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.util.Scanner;

/**
 * Задание 2:
 * 1.	Пользователь с клавиатуры вводит путь к файлу, искомое слово и слово для замены.
 * 2.	Программа открывает файл и ищет искомое слово в его содержимом.
 * 3.	Если слово найдено, программа заменяет его на указанное слово.
 * 4.	Программа подсчитывает количество произведенных замен.
 * 5.	Программа выводит на экран отчет о количестве замен.
 */
public class Task2 {
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

        System.out.println("Укажите слово для поиска: ");
        //String wordForSearch = scanner.nextLine();
        String wordForSearch = "Java";

        System.out.println("Укажите слово для замены: ");
        //String wordToReplace = scanner.nextLine();
        String wordToReplace = "Джава";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            StringBuilder sb = new StringBuilder();
            int replacesCount = 0;
            String line = br.readLine();
            while (line != null) {
                while (line.contains(wordForSearch)) {
                    line = line.replaceFirst(wordForSearch, wordToReplace);
                    replacesCount++;
                }
                sb.append(line).append('\n');
                line = br.readLine();
            }
            br.close();

            System.out.println("Количество замен: " + replacesCount);
            saveFile("src/hw27_files/data/java_replaced.txt", sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveFile(String pathToFile, String textToSave) throws IOException{
        OutputStreamWriter writer = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(pathToFile)));
        writer.write(textToSave);
        writer.flush();
        writer.close();
    }
}
