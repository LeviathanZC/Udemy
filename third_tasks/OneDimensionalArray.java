package com.company.epam.third_tasks;

import java.util.Arrays;

/*
 * KARNIYUK Y. V.
 * 29.08.2019
 * This programm has been developed
 * for learning arrays, sorting, and other stuff
 *
 * */

public class OneDimensionalArray {

    //объявление вектора (одномерного массива)
    private static int[] vector;
    private static int vectorLength;
    private static Sorting sorting;

    public OneDimensionalArray() {

        setVector(5, 20);
        setVectorLength();
        randomFillVector(0, 30);

        System.out.println(Arrays.toString(vector));
        outputExtremalValues();
        reverse();
        System.out.println(Arrays.toString(vector));
        sorting = new Sorting(vector, "merge");
        vector = sorting.sort();
        System.out.println(Arrays.toString(vector));
        outputArithmeticAndGeometricMeans();

    }



    /*
        ПОИСК ЭКСТРЕМУМОВ МАССИВА
     */

    //вывод экстремальных значений
    private static void outputExtremalValues() {

        int[] array = checkingExtremalValues();

        if (array[0] == -1 && array[1] == -1) {

            System.out.println("extremal values are nonexistent");

        } else {
            System.out.println("extremal values are : " + array[0] + " and " + array[1]);
        }

    }

    //контроьная проверка экстремальных значений
    private static int[] checkingExtremalValues() {

        int[] returnArr = {maxValOfVector(), minValOfVector()};

        if (returnArr[0] == returnArr[1]) {

            returnArr[0] = -1;
            returnArr[1] = -1;
            return returnArr;

        } else {

            return returnArr;

        }
    }

    //метод поиска максимального числа в неотсортированном массиве
    private static int maxValOfVector() {

        //принимаем максимальное значение массива под индексом 0
        int maximalVal = vector[0];

        for (int i = 0; i < vectorLength; i++) {
            if (maximalVal > vector[i]) {
                maximalVal = vector[i];
            }
        }
        return maximalVal;
    }

    //метод поиска минимального числа в неотсортированном массиве
    private static int minValOfVector() {

        //принимаем за минимальное значение массива под индексом 0
        int minimalVal = vector[0];

        for (int i = 0; i < vectorLength; i++) {

            if (minimalVal < vector[i]) {
                minimalVal = vector[i];
            }

        }

        return minimalVal;

    }

    /*
        ВЫЧИСЛЕНИЕ СРЕДНИХ АРИФМЕТИЧЕСКОГО И ГЕОМЕТРИЧЕСКОГО
     */

    //метод для вывода средних арифметического и гемоетрического
    private static void outputArithmeticAndGeometricMeans() {

        System.out.println("arithmetic mean of vector is : " + arithmeticMean());
        System.out.println("geometric mean of vector is : " + geometricMean());

    }

    //метод, возвращающий среднее арифметическое элементов массива
    private static double arithmeticMean() {
        int sum = 0;
        for (int i : vector) {
            sum += vector[i];
        }
        return sum / vectorLength;
    }

    //метод, возвращающий среднее геометрическое элементов массива
    private static double geometricMean() {

        int product = 1;
        for (int i : vector) {
            product *= vector[i];
        }

        return Math.pow(product, -vectorLength);

    }

    private static void calcOrder() {

        if (sorting.getCondition()) {



        } else {
            System.out.println("elements of vector are not sorted");
        }

    }

    //метод, реверсирующий вектор
    private static void reverse() {
        int vHalfLength = vectorLength / 2;
        for (int i = 0; i < vHalfLength; i++) {

            swap(i, vectorLength - i - 1);

        }
    }

    private static void swap(int index1, int index2) {

        //проверка на выход за пределы массива
        if (index1 > vectorLength || index2 > vectorLength || index1 < 0 || index2 < 0) {

            return;

        } else {
            vector[index1] += vector[index2];
            vector[index2] = vector[index1] - vector[index2];
            vector[index1] -= vector[index2];
        }
    }


    /*
        МЕТОДЫ СЕТТЕРЫ/ИНИЦИАЛИЗАТОРЫ
        ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ
     */

    //сеттер, генерирующий пустой целочисленный массив с переменной длиной, заданных в диапазоне [a,b)
    private static void setVector(int a, int b) {
        vector = new int[randomOfRange(a, b)];
    }

    //метод сеттер для длины вектора
    private static void setVectorLength() {
        vectorLength = vector.length;
    }

    //метод, возвращающий случайное число в заданном диапазоне [a,b)
    private static int randomOfRange(int a, int b) {
        return (int) Math.round(Math.random() * (b - a) + a);
    }

    //метод, заполняющий вектор рандомно в заданном диапазоне
    private static void randomFillVector(int a, int b) {
        for (int i = 0; i < vectorLength; i++) {

            vector[i] = randomOfRange(a, b);

        }
    }

    private static boolean isAscending() {

        int i = 0;
        boolean isAscending = false;

        do {
            i++;
        } while (vector[i] < vector[i + 1] && i < vectorLength);

        return (i == vectorLength) ? true : false;

    }

}
