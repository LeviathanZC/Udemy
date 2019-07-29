package com.company.epam.third_tasks;

import java.util.Arrays;

public class Sorting {

    private static int[] array;
    private static int arrLength;

    private static String TYPE;

    public Sorting(int[] arr, String type) {
        setArray(arr);
        setArrLength();
        setType(type);
        System.out.println(TYPE);
    }

    public static int[] sort() {

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

            }
            case "quick": {

            }
            default: {
                System.out.println("unexpected token of TYPE");
            }
        }
        return null;

    }


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

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
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



    private static void quickSort() {

    }


    //сеттер для массива
    private static void setArray(int[] arr) {
        array = arr;
    }


    //сеттер для хранения длины массива
    private static void setArrLength() {
        arrLength = array.length;
    }

    //сеттер для переменной, хранящей выбранный тип сортировки
    private static void setType(String type) {
        TYPE = type.toLowerCase();
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
