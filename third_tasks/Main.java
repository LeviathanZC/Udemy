package com.company.epam.third_tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //firstTask();
        secondTask();

        System.out.println("the program successfully complete!");
        System.gc();

    }

    public static void firstTask() {

        System.out.println("THE FIRST TASK");
        System.out.println("initializing vector\n");

        OneDimensionalArray oda = new OneDimensionalArray(inputRange("vector"), inputRange("random"));

        oda.mainTasks();


    }

    public static void secondTask() {

        System.out.println("THE SECOND TASK");
        System.out.println("initializing 2-dim array \n");

        TwoDimensionalArray tda = new TwoDimensionalArray(inputDimensions());

        tda.mainTasks();
    }

    // метод ввода данных с проверкой на ввод
    private static int input() throws InputMismatchException {

        Scanner scan = new Scanner(System.in);

        /**
         **  Обработка исключения при вводе числа
         **       с помощью утилиты Scanner
         **
         **
         **/

        try {

            System.gc();

            return scan.nextInt();

        } catch (InputMismatchException e) {

            System.out.println("\nInput Mismatch Exception \ninterrupted exception");
            System.gc();
            return 0;

        } catch (Exception e) {

            System.out.println("Unexpected error");
            System.gc();
            return 0;

        }
    }

    // метод вводы диапазона в массив
    private static int[] inputRange(String str) {
        System.out.println("input range of " + str.toUpperCase() + " length");
        int[] range = new int[2];
        for (int i = 0; i < 2; i++) {
            range[i] = input();
        }

        return prepValsForArray(range);
    }

    // метод для проверки значений
    private static int[] prepValsForArray(int[] arr) {
        if (arr[0] < arr[1]) {
            return arr;
        } else {
            arr[0] += arr[1];
            arr[1] = arr[0] - arr[1];
            arr[0] -= arr[1];
            return arr;
        }
    }

    //метод для ввода размерностей двумерного массива
    private static int[] inputDimensions(){

        System.out.print("input N length : ");
        int N = input();

        System.out.print("input M length : ");
        int M = input();

        return new int[] {N, M};

    }


}
