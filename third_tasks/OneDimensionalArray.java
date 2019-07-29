package com.company.epam.third_tasks;

import java.util.Arrays;
import java.util.Random;

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

    public OneDimensionalArray(int[] rangeVector, int[] rangeRand) {

        setVector( rangeVector[0], rangeVector[1]);
        setVectorLength();
        randomFillVector(rangeRand[0], rangeRand[1]);

    }

    //публичный метод для запуска
    public static void mainTasks(){
        System.out.println("output contains of vector\n" + Arrays.toString(vector) + "\n");

        outputExtremalValues();
        System.out.println();

        outputArithmeticAndGeometricMeans();
        System.out.println();

        calcOrder();
        System.out.println();

        outputLocals(localMin(), localMax());
        System.out.println();

        searchElem(vector[(int)Math.random() * vectorLength], "linear");
        System.out.println();
        searchElem(vector[(int)Math.random() * vectorLength], "binary");
        System.out.println();

        reverse();
        System.out.println(Arrays.toString(vector) + "\n");

        sorting = new Sorting(vector, "bubble");
        vector = sorting.sort();
        System.out.println(Arrays.toString(vector) + "\n");


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
        for (int i = 0; i < vectorLength; i++) {
            sum += vector[i];
        }
        return (double) sum / vectorLength;
    }

    //метод, возвращающий среднее геометрическое элементов массива
    private static double geometricMean() {

        int product = 1;
        for (int i = 0; i < vectorLength; i++) {
            product *= vector[i];
        }

        return Math.pow(product, -vectorLength);

    }

    /*
        ПРОВЕРКА УПОРЯДОЧЕННОСТИ МАССИВА
     */

    //метод для вычисления конкретного упорядоченного вида (по возрастанию/убыванию)
    private static void calcOrder() {

        if (sorting.getCondition()) {

            if (isAscending()) {
                System.out.println("vector sorted in ascending order");
            } else {
                System.out.println("vector sorted in descending order");
            }

        } else {
            System.out.println("elements of vector are not sorted");
        }

    }

    /*
        НАХОЖДЕНИЕ ПОЗИЦИИ ПЕРВОГО ВСТРЕТИВШЕГОСЯ ЛКОАЛЬНОГО МИНИМУМА/МАКСИМУМА
     */

    private static int localMin() {
        /*int i = 0;
        for (; i < vectorLength; i++) {
            if (vector[i] < (i > 0 ? vector[i - 1] : Integer.MAX_VALUE)
                    && vector[i] < (i < vectorLength - 1 ? vector[i + 1] : Integer.MAX_VALUE)) {
                break;
            }
        }

        return vector[i];*/
        int i = 1;
        while (i < vectorLength - 1 && !(vector[i] < vector[i - 1] && vector[i] < vector[i + 1])) {
            i++;
        }
        return vector[i];
    }

    private static int localMax() {
        int i = 1;
        while (i < vectorLength - 1 && !(vector[i] > vector[i - 1] && vector[i] > vector[i + 1])) {
            i++;
        }
        return vector[i];
    }

    private static void outputLocals(int min, int max){
        System.out.println("the first local minimal value is : " + min);
        System.out.println("the first local maximal value is : " + max);
    }

    /*
        АЛГОРИТМЫ ЛИНЕЙНОГО И ДВОИЧНОГО ПОИСКА
     */

    private static void searchElem(int elementToSearch, String type) {

        switch (type.toLowerCase()) {

            case "linear": {
                searchOutput(elementToSearch, linearSearch(elementToSearch));
                break;
            }
            case "binary": {
                searchOutput(elementToSearch, binarySearch(elementToSearch));
                break;
            }
            default: {
                System.out.println("unexpectod token");
            }

        }

    }

    private static void searchOutput(int searchingElem, int index) {
        System.out.println("element " + searchingElem + " is under the index " + index);
    }

    //метод-реализация алгоритма линейного поиска
    private static int linearSearch(int elementToSearch) {

        for (int index = 0; index < vectorLength; index++) {
            if (vector[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    //метод-реализация итеративного (не рекурсивного) алгоритма бинарного поиска
    private static int binarySearch(int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = vectorLength - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (vector[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (vector[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (vector[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    //метод, реверсирующий вектор
    private static void reverse() {
        int vHalfLength = vectorLength / 2;
        for (int i = 0; i < vHalfLength; i++) {

            swap(i, vectorLength - i - 1);

        }
    }

    //метод перемены местами двух переменных, находящихся под индексами index1 и index2
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
        Random rnd = new Random();
        return (rnd.nextInt(b) + a);
    }

    //метод, заполняющий вектор рандомно в заданном диапазоне
    private static void randomFillVector(int a, int b) {
        for (int i = 0; i < vectorLength; i++) {

            vector[i] = randomOfRange(a, b);

        }
    }

    private static boolean isAscending() {

        return vector[0] < vector[1];

    }

}
