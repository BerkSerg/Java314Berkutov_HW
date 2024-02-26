package hw19_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Задача 1. Ввод данных:
 * Напишите программу, которая запрашивает у пользователя ввод данных и пытается обработать этот ввод. Обработайте
 * исключение InputMismatchException, которое возникает, если введенные данные не соответствуют ожидаемому формату.
 */

public class InputException {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Введите целое число: ");
            long number = scanner.nextLong();
            System.out.println("Введенное число: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Введенные данные не являются числом или число очень большое");
        }
        scanner.close();
    }
}
