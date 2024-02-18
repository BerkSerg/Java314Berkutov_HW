package hw19_exceptions;

import hw19_exceptions.exceptions.NegativeNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Задача 4*. Подсчет факториала
 * Напишите программу, которая запрашивает у пользователя целое число и вычисляет его факториал. Факториал числа
 * nn (обозначается n!n!) - это произведение всех целых чисел от 1 до nn. Например, 5!=5×4×3×2×1=120
 * Однако, для решения этой задачи предусмотрите возможность ввода отрицательных чисел. В случае, если пользователь
 * ввел отрицательное число, выбросьте специальное исключение NegativeNumberException, а затем обработайте его,
 * выводя сообщение об ошибке. Вот отдельный класс ошибки, который также необходимо создать.
 */

public class CalculateFactorial {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Введите целое число: ");
            int number = scanner.nextInt();
            if(number < 0){
                throw new NegativeNumberException("Невозможно вычислить факториал отрицательного числа");
            }
            System.out.printf("%d! = %d\n", number, getFactorial(number));
        } catch (InputMismatchException e) {
            System.out.println("Введенные данные не являются числом или число очень большое");
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch (StackOverflowError e){
            System.out.println("Для введенного числа невозможно вычислить факториал. Число слишком большое");
        }
        scanner.close();
    }

    private static int getFactorial(int number){
        return (number <= 1) ? 1 :  number * getFactorial(number - 1);
    }
}
