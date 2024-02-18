package hw19_exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/**
 * Задача 2. Парсинг даты:
 * Напишите программу, которая запрашивает у пользователя ввод даты в формате "год-месяц-день" (например, "2022-01-31").
 * Затем попробуйте преобразовать эту строку в объект типа LocalDate с помощью метода LocalDate.parse(). Обработайте
 * возможное исключение DateTimeParseException, если введенная строка имеет неверный формат.
 */

public class DateParser {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите дату в формате гггг-ММ-дд: ");
        String userString = scanner.nextLine();
        try {
            LocalDate localDate = LocalDate.parse(userString);
            System.out.println("Объект LocalDate успешно создан: " + localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } catch (DateTimeParseException e) {
            System.out.printf("Строку '%s' нельзя преобразовать в дату", userString);
        }
        scanner.close();
    }
}
