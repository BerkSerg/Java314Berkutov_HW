package hw27_files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;


/**
 * Задание 3:
 * 1.	Пользователь вводит с клавиатуры пути к четырем файлам.
 * 2.	Программа открывает каждый из четырех файлов и считывает их содержимое.
 * 3.	Программа записывает содержимое трех файлов в четвертый файл.
 * 4.	Программа подсчитывает количество перенесенных байт.
 * 5.	Программа выводит на экран отчет о количестве перенесенных байт.
 */
public class Task3 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите пути к файлам: ");
        //String filePath1 = scanner.nextLine();
        //String filePath2 = scanner.nextLine();
        //String filePath3 = scanner.nextLine();
        //String filePath4 = scanner.nextLine();
        String filePath1 = "src/hw27_files/data/java_1.txt";
        String filePath2 = "src/hw27_files/data/java_2.txt";
        String filePath3 = "src/hw27_files/data/java_3.txt";
        String filePath4 = "src/hw27_files/data/java_joined.txt";

        List<String> files = new ArrayList<>();
        files.add(filePath1);
        files.add(filePath2);
        files.add(filePath3);


        long totalSize = 0;
        StringBuilder sb = new StringBuilder();
        for (String filePath : files) {
            Path path = Path.of(filePath);
            if (!Files.exists(path)) {
                System.out.println("Файла не существует");
                return;
            }

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                String line = br.readLine().toLowerCase();
                while (line != null) {
                    sb.append(line).append('\n');
                    line = br.readLine();
                }
                br.close();
                saveFile(filePath4, sb.toString());
                totalSize += Files.size(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Колтичество перенесенных байт: " + totalSize);
    }

    private static void saveFile(String pathToFile, String textToSave) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(pathToFile)));
        writer.write(textToSave);
        writer.flush();
        writer.close();
    }
}
