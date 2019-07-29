package com.company.epam.third_tasks;

import java.util.Arrays;

/*
    КЛАСС ОСУЩЕСТВЛЯЮЩИЙ СОРТИРОВКУ ОДНОМЕРНЫХ МАССИВОВ
    НЕСКОЛЬКИМИ СПОСОБАМИ
 */

public class Sorting {

    private static int[] array;
    private static int arrLength;
    private static boolean isSorted = false;

    private static String TYPE;

    public Sorting(int[] arr, String type) {
        setArray(arr);
        setArrLength();
        setType(type);
    }






    public static int[] sort() {
        isSorted = true;
        switch (TYPE) {
            case "bubble": {
                bubbleSort();
                return array;
            }
            case "insertion": {
                insertionSort();
                return array;
            }
            case "selection": {
                selectionSort();
                return array;
            }
            case "merge": {
                mergeSort(array, arrLength);
                return array;
            }
            case "quick": {
                initQuick();
                return array;
            }
            default: {
                System.out.println("unexpected token of TYPE");
            }
        }
        return null;

    }

    /*
            МЕТОДЫ СОРТИРОВОК
     */

    //метод пузырьковой сортировки массива
    private static void bubbleSort() {

        for (int i = 0; i < arrLength; i++) {

            for (int j = 0; j < arrLength - 1; j++) {

                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }

            }
        }
    }

    //метод реализация сортировки вставками
    private static void insertionSort() {

        for (int left = 0; left < arrLength; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
    }

    //метод реализация сортировки выбором
    private static void selectionSort() {

        for (int i = 0; i < arrLength - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arrLength; j++) {

                if (array[j] < array[min]) {
                    min = j;
                }

            }

            if (min != i) {
                swap(min, i);
            }

        }

    }

    //метод реализация сортировки слиянием
    private static void mergeSort(int[] array, int arrLength) {
        if (arrLength < 2) {
            return;
        }
        int mid = arrLength / 2;
        int[] l = new int[mid];
        int[] r = new int[arrLength - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < arrLength; i++) {

            r[i - mid] = array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, arrLength - mid);

        merge(array, l, r, mid, arrLength - mid);
    }

    //метод реализация слияния
    private static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    //метод для инициализации соритровки qSort
    private static void initQuick() {
        int startIndex = 0;
        int endIndex = arrLength - 1;
        quickSort(startIndex, endIndex);
    }

    //метод реализация алгоритма быстрой сортировки
    private static void quickSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickSort(start, cur);
        quickSort(cur + 1, end);
    }






    /*
            МЕТОДЫ СЕТТЕРЫ/ИНИЦИАЛИЗАТОРЫ
            ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ
     */




    //сеттер для массива
    private static void setArray(int[] arr) {
        array = arr;
    }


    //сеттер для хранения длины массива
    private static void setArrLength() {
        arrLength = array.length;
    }

    //сеттер для переменной, хранящей выбранный тип сортировки
    public static void setType(String type) {
        TYPE = type.toLowerCase();
    }

    public static boolean getCondition(){
        return isSorted;
    }

    //метод перестановки местами двух элементов массива по индексу
    private static void swap(int index1, int index2) {

        //проверка на выход за пределы массива
        if (index1 > arrLength || index2 > arrLength || index1 < 0 || index2 < 0) {

            return;

        } else {
            array[index1] += array[index2];
            array[index2] = array[index1] - array[index2];
            array[index1] -= array[index2];
        }
    }


}
