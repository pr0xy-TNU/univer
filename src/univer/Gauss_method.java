package univer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by Yarik on 19.09.2016.
 */
public class Gauss_method {

    //rows - количество неизвестных - количество столбцов
    //columns - количество уравнений - количестов строк
    public static void printMatrix(float[][] matrix, int rows, int columns) {
        // Прямой ход
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (columns - j == 1)
                    System.out.print("     ");
                System.out.format("%10.3f ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMas(float[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }

    public static float[][] getRandomMatrix(int rows, int columns) {
        float[][] matrix = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new BigDecimal(Math.random() * 100 + 0).setScale(2, RoundingMode.UP).floatValue();
            }
        }
        return matrix;
    }

    public static int[] getRandomFreeMembers(int columns) {
        int[] mas = new int[columns];
        for (int i = 0; i < columns; i++) {
            mas[i] = (int) (Math.random() * 10 + 0);
        }
        return mas;
    }

    public static float[] getGauss(float[][] mas, int rows, int columns) throws InterruptedException {
        float tmp;
        int k;

        for (int i = 0; i < rows; i++) {
           /* printMatrix(mas, rows, columns);
            System.out.println("Iteration " + i);
            System.out.println();
            Thread.sleep(1000);*/

            tmp = mas[i][i];
            for (int j = rows; j >= i; j--)
                mas[i][j] /= tmp;
            for (int j = i + 1; j < rows; j++) {
                tmp = mas[j][i];
                for (k = rows; k >= i; k--)
                    mas[j][k] -= tmp * mas[i][k];
            }

        }

        float[] arr = new float[columns - 1];
        arr[rows - 1] = mas[rows - 1][rows];
        for (int i = rows - 2; i >= 0; i--) {
            arr[i] = mas[i][rows];
            for (int j = i + 1; j < rows; j++){
                arr[i] -= mas[i][j] * arr[j];
            }
            printMas(arr);
            Thread.sleep(1000);
            System.out.println("-----------------------");
        }
        return arr;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество уравнений");
        int rows = Integer.parseInt(reader.readLine());
        System.out.println("Введите количество переменых");
        int column = Integer.parseInt(reader.readLine()) + 1;

        float[][] extendedMatrix = getRandomMatrix(rows, column);
        printMatrix(extendedMatrix, rows, column);
        System.out.println("------------------------------");
        getGauss(extendedMatrix, rows, column);
        printMatrix(extendedMatrix, rows, column);


    }
}
