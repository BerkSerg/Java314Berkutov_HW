package hw28_threads;


/* TODO
Задача 4*. Вычисление матричного произведения:
•	Создайте две матрицы.
•	Разделите каждую матрицу на строки или столбцы.
•	Создайте несколько потоков для вычисления произведения строк/столбцов одной матрицы на строки/столбцы другой матрицы.
•	Объедините результаты вычислений в результирующую матрицу.

 */

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    private final static int MATRIX_SIZE = 10;

    public static void main(String[] args) {
        final int[][] matrixOne = new int[MATRIX_SIZE][MATRIX_SIZE];
        final int[][] matrixTwo = new int[MATRIX_SIZE][MATRIX_SIZE];

        fillMatrix(matrixOne);
        fillMatrix(matrixTwo);

        printMatrix(matrixOne);
        printMatrix(matrixTwo);

        int[][] resultMatrix = multiplyMatrices(matrixOne, matrixTwo);
        printMatrix(resultMatrix);
    }

    private static int[][] multiplyMatrices(int[][] matrixOne, int[][] matrixTwo) {
        final int[][] resultMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        Thread[] threads = new Thread[MATRIX_SIZE];

        for (int i = 0; i < MATRIX_SIZE; i++) {
            int[] wrapperI = {i};
            threads[i] = new Thread(() -> {
                int ii = wrapperI[0];
                for (int j = 0; j < MATRIX_SIZE; j++) {
                    resultMatrix[ii][j] = matrixOne[ii][j] * matrixTwo[ii][j];
                }
            });
            threads[i].start();
        }

        try{
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultMatrix;
    }

    private static void fillMatrix(int[][] matrix) {
        Random rnd = new Random();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix[i][j] = rnd.nextInt(1, 10);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] levelOne : matrix) {
            System.out.println(Arrays.toString(levelOne).replaceAll(",", ""));
        }
        System.out.println();
    }
}
