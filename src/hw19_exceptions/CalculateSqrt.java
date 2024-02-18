package hw19_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Задача 3. Вычисление квадратного корня:
 * Напишите программу, которая запрашивает у пользователя число и вычисляет его квадратный корень с помощью метода
 * Math.sqrt(). Обработайте возможное исключение IllegalArgumentException, если пользователь вводит отрицательное число.
 */

public class CalculateSqrt {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Введите целое число: ");
            long number = scanner.nextLong();
            if(number < 0){
                throw new IllegalArgumentException("Невозможно вычислить корень отрицательного числа");
            }
            System.out.println("Корень введенного числа = " + Math.sqrt(number));
        } catch (InputMismatchException e) {
            System.out.println("Введенные данные не являются числом или число очень большое");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

}
