package com.company.epam.third_tasks;

import sun.dc.pr.PRError;

import java.util.Arrays;
import java.util.Random;

public class TwoDimensionalArray {

    private static double[][] ARRAY;
    private static int NLength;
    private static int MLength;


    public TwoDimensionalArray(int[] rangeMatrix) {

        setARRAY(rangeMatrix);
        setNxM();
        randomFill();


    }

    public static void mainTasks() {

        System.out.println("matrix contains: ");
        outputMatrix();
        System.out.println();

        outputExtremums();
        System.out.println();

        outputArithmeticAndGeometricMeans();
        System.out.println();

        isSymmetric();
        System.out.println();

        localMinAndMax();
        System.out.println();

        transpose();
        outputMatrix();
        System.out.println();

    }

    /*
        FIND EXTREMUMS OF THE ARRAY
     */

    private static void outputExtremums() {
        System.out.println("extremums of the Array is " + minValue() + " and " + maxValue());
    }

    // метод для поиска минимального значения в двумерном массиве
    private static double minValue() {
        double min = ARRAY[0][0];
        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {

                if (min < ARRAY[i][j]) {
                    min = ARRAY[i][j];
                }

            }
        }

        return min;
    }

    // метод для поиска максимального значения в двумерном массиве
    private static double maxValue() {
        double max = ARRAY[0][0];
        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {

                if (max > ARRAY[i][j]) {
                    max = ARRAY[i][j];
                }

            }
        }

        return max;
    }

    /*
        ARITHMETIC AND GEOMETRIC MEANS
     */

    //метод для вывода средних арифметического и гемоетрического
    private static void outputArithmeticAndGeometricMeans() {

        System.out.println("arithmetic mean of vector is : " + arithmeticMean());
        System.out.println("geometric mean of vector is : " + geometricMean());

    }

    //метод, возвращающий среднее арифметическое элементов массива
    private static double arithmeticMean() {
        double sum = 0;
        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {
                sum += ARRAY[i][j];
            }
        }
        return sum / (NLength * MLength);
    }

    //метод, возвращающий среднее геометрическое элементов массива
    private static double geometricMean() {

        double product = 1;
        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {
                product *= ARRAY[i][j];
            }
        }

        return Math.pow(product, -(NLength * MLength));

    }

    /*
        IS SYMMETRIC
     */

    private static void isSymmetric(){

        if(isSymmetricMainDiagonal()) {
            System.out.println("the matrix is symmetric on the main diagonal");
        } else if (isSymmetricSideDiagonal()) {
            System.out.println("the matrix is symmetric on the side diagonal");
        } else {
            System.out.println("the matrix is not symmetric");
        }

    }

    private static boolean isSymmetricMainDiagonal() {

        if (isSquare()) {

            for (int i = 0; i < NLength; i++) {
                for (int j = 0; j < MLength; j++) {

                    if (i != j) {

                        if (ARRAY[i][j] != ARRAY[j][i]) {

                            return false;

                        }

                    }

                }
            }

            return true;


        } else {
            return false;
        }

    }

    private static boolean isSymmetricSideDiagonal() {

        if (isSquare()) {

            for (int i = 1; i < NLength; i++) {
                for (int j = 1; j < MLength; j++) {

                    if (NLength - i != MLength - j) {

                        if (ARRAY[NLength - i][MLength - j] != ARRAY[MLength - j][NLength - i]) {

                            return false;

                        }

                    }

                }
            }

            return true;


        } else {
            return false;
        }

    }


    /*
        LOCAL MINIMUM AND MAXIMUM
     */

    private static void localMinAndMax(){

        System.out.println("local minimum of the array is : " + retrieveValue(localMin()));
        System.out.println("local maximum of the array is : " + retrieveValue(localMax()));

    }

    private static double retrieveValue(int[] coords) {
        if(coords[0]==-1) {
            System.out.println("no local extremums");
            return 0;
        } else {

            return ARRAY[coords[0]][coords[1]];

        }
    }

    //поиск локального минимума в двумерном массиве
    private static int[] localMin() {

        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {

                double current = ARRAY[i][j];

                if (i + 1 < NLength && current >= ARRAY[i + 1][j] ||
                        i - 1 >= 0 && current >= ARRAY[i - 1][j] ||
                        j + 1 < MLength && current >= ARRAY[i][j + 1] ||
                        j - 1 >= 0 && current >= ARRAY[i][j - 1]) {
                    continue;
                } else {
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{-1, -1};
    }

    //поиск локального максимума в двумерном массива
    private static int[] localMax() {

        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {

                double current = ARRAY[i][j];

                if (i + 1 < NLength && current <= ARRAY[i + 1][j] ||
                        i - 1 >= 0 && current <= ARRAY[i - 1][j] ||
                        j + 1 < MLength && current <= ARRAY[i][j + 1] ||
                        j - 1 >= 0 && current <= ARRAY[i][j - 1]) {
                    continue;
                } else {
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{-1, -1};
    }


    /*
        TRANSPOSE
     */

    private static void transpose() {

        if (isSquare()) {

            for (int i = 0; i < NLength; i++) {
                for (int j = 0; j < MLength; j++) {
                    if (i != j) {
                        swap(i, j);
                    }
                }
            }

        } else {
            System.out.println("matrix is not square");
            System.out.println("transposition without new array is not allowed");
        }

    }



    /*
        SETTERS AND HELPING METHODS FOR 2DIM ARRAY
     */

    //проверка матрицы на "квардатность"
    private static boolean isSquare() {
        return NLength == MLength;
    }

    //сеттер двумерного массива
    private static void setARRAY(int[] rangeMxN) {
        ARRAY = new double[rangeMxN[0]][rangeMxN[1]];
    }

    //сеттер постоянных размерностей
    private static void setNxM() {
        NLength = ARRAY.length;
        MLength = ARRAY[0].length;
    }

    //рандомное заполнение массива
    private static void randomFill() {

        Random rnd = new Random();

        for (int i = 0; i < NLength; i++) {
            for (int j = 0; j < MLength; j++) {

                ARRAY[i][j] = rnd.nextDouble();

            }

        }



    }

    //метод перемены местами двух переменных, находящихся под индексами index1 и index2
    private static void swap(int index1, int index2) {

        //проверка на выход за пределы массива
        if (index1 > NLength || index2 > MLength || index1 < 0 || index2 < 0) {

            return;

        } else {
            ARRAY[index1][index2] += ARRAY[index2][index1];
            ARRAY[index2][index1] = ARRAY[index1][index2] - ARRAY[index2][index1];
            ARRAY[index1][index2] -= ARRAY[index2][index1];
        }
    }

    private static void outputMatrix(){
        for (int i = 0; i < NLength; i++) {
            System.out.println(Arrays.toString(ARRAY[i]));
        }
    }
}
