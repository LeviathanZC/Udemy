package com.company.epam.firsts_tasks;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        isTriangle();

        System.out.println("\n program successfully completed!");

    }


    /**
     * Разработайте программу, которая проверяет,
     * что числа a, b и c различны (одинаковы).
     **/
    private static void checkingNums() {

        int a;
        int b;
        int c;

        System.out.println("input a");
        a = input();
        System.out.println();
        System.out.println("input b");
        b = input();
        System.out.println();
        System.out.println("input c");
        c = input();

        if (isDifferent(a, b, c)) {
            System.out.println("\nAll numbers is the same");
        } else {
            System.out.println("\nAll numbers is different");
        }


    }


    /**
     * Масса динозавра задаётся в килограммах. Разработайте программу,
     * которая вычисляет, сколько это миллиграмм, грамм и тонн.
     **/
    private static void transferDinoMass() {

        System.out.print("input mass of dinosaur");
        int massDinosaur = input();
        System.out.println("\nmass of dinosaur is " + massDinosaur + " kg");
        System.out.println("\n\nmass of dinosaur (mg) is " + transferToMg(massDinosaur) + " mg");
        System.out.println("\n\nmass of dinosaur (g) is " + transferToGr(massDinosaur) + " g");
        System.out.println("\n\nmass of dinosaur (t) is " + transferToTons(massDinosaur) + " t");

    }


    /**
     * На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).
     * Разработайте программу нахождения площади кольца, внешний радиус которого
     * равен R1, а внутренний радиус равен R2.
     **/
    private static void calcRingArea() {

        System.out.println("input radius R1");
        int r1 = input();
        System.out.println("input radius R2");
        int r2 = input();
        System.out.println("the ring area equals " + areaOfRing(areaOfCircle(r1), areaOfCircle(r2)));

    }


    /**
     * Разработайте программу, которая проверяет, что цифры четырёхзначного числа N
     * образуют возрастающую (убывающую) последовательность (к примеру, число 1357
     * удовлетворяет условию, т.к. его цифры соответствуют следующему неравенству:
     * 1 < 3 < 5 < 7, т.е. идут в порядке возрастания).
     **/
    private static void sequenceCheck() {

        System.out.println("input number");
        int i = input();

        String str = Integer.toString(i);

        if (seqChecking(str)) {
            System.out.println("in ascending order");
        } else {
            System.out.println("not in ascending order");
        }

    }


    /**
     * Написать программу, которая находит арифметическое
     * и геометрическое среднее цифр шестизначного числа N.
     **/
    private static void calcArithmeticAndGeometryMeans() {

        System.out.println("input number of values");

        int vals = input();

        int[] array = new int[vals];

        for (int i = 1; i <= vals; i++) {

            System.out.print("input " + (i) + " number: ");

            array[i - 1] = input();

            System.out.println();
        }

        System.out.println("The arithmeatic mean of nums " + Arrays.toString(array) + " is " + arithmeticMean(array));

        System.out.println("The geometric mean of nums " + Arrays.toString(array) + " is " + geometricMean(array));


    }

    /**
     * Написать программу, которая переворачивает (реверсирует)
     * семизначное число N (к примеру, число 1234567
     * реверсируется в число 7654321).
     **/
    private static void revers7digitNum() {

        boolean permission = false;
        int number;

        do {
            System.out.println("input 7-digit number");
            number = input();

            if (countOfNums(number) != 7) {

                System.out.println("the entered number is not 7-digital");
                System.out.println("\nplease, try again\n");

            } else {
                permission = true;
            }

        } while (!permission);

        System.out.println("reverse num is " + Integer.parseInt(reverseString(Integer.toString(number))));

    }

    /**
     * Разработайте небольшую цельную программу, которая меняет местами
     * содержимое двух целочисленных переменных a и b, не используя
     * для этого дополнительных переменных.
     **/
    private static void reverseVars() {

        int a;
        int b;

        System.out.println("input 1st value");
        a = input();
        System.out.println("input 2nd value");
        b = input();

        b += a;
        a = b - a;
        b -= a;

        System.out.println("1st value is " + a);
        System.out.println("2nd value is " + b);

    }


    // SECOND PART

    /**
     * На прямоугольной декартовой системе координат на плоскости заданы три точки
     * с соответствующими координатами в виде пары значений (x,y).
     * Определить, являются ли данные точки вершинами треугольника.
     * И если да, то дополнительно определить, является ли данный треугольник прямоугольным.
     **/
    private static void isTriangle() {

        int x1, x2, x3;
        int y1, y2, y3;

        System.out.println("input coords of triangle vertex");

        System.out.print("\n input x1: ");
        x1 = input();
        System.out.print("\n input y1: ");
        y1 = input();
        System.out.print("\n input x2: ");
        x2 = input();
        System.out.print("\n input y2: ");
        y2 = input();
        System.out.print("\n input z3: ");
        x3 = input();
        System.out.println("\n input y3: ");
        y3 = input();

        if (isOnOneLine(x1, x2, x3, y1, y2, y3)) {

            System.out.println("this is not triangle ( this can be degenerate triangle )");

        } else {

            System.out.println("this is a triangle");

            outputLengthOfTriangle(x1, x2, x3, y1, y2, y3);

            if (isRectangular(lengthOfLine(x1, y1, x2, y2), lengthOfLine(x2, y2, x3, y3), lengthOfLine(x3, y3, x1, y1))) {
                System.out.println("This triangle is rectangular");
            } else {
                System.out.println("This triangle is NOT rectangular");
            }

        }

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

    // проверка равности 3-ех чисел между собой
    private static boolean isDifferent(int a, int b, int c) {

        return a == b && b == c;

    }

    // перевод КГ в Т
    private static float transferToTons(int num) {

        return num * 0.001F;

    }

    // перевод КГ в Г
    private static int transferToGr(int num) {

        return num * 1000;

    }

    // перевод КГ в МГ
    private static long transferToMg(int num) {

        return ((long) num) * 1_000_000;

    }

    // метод нахождения площади круга
    private static double areaOfCircle(int R) {

        return Math.PI * (R * R);

    }

    // метод нахождения площади кольца
    private static double areaOfRing(double area1, double area2) {

        if (area1 > area2) {
            return area1 - area2;
        } else {
            System.out.println("inversion of areas...");
            return area2 - area1;
        }
    }

    // метод проверки восходящей последовательности
    private static boolean seqChecking(String string) {

        for (int i = 0; i < string.length() - 2; i++) {

            if (extractNum(string, i) > extractNum(string, i + 1)) {

                return false;

            }

        }

        return true;

    }

    // извлечение данных о числе, входящих в строку
    private static int extractNum(String string, int pos) {

        return string.charAt(pos + 1);

    }

    // метод конвертации числа в массив чисел для произведение дальнейших операций
    private static int[] convertNumToArr(int num) {

        int[] arr = new int[numLength(num)];
        int buff = num;

        for (int i = arr.length - 1; i >= 0; i--) {

            arr[i] = buff % 10;
            buff /= 10;

        }

        return arr;

    }

    // метод определения длины числа
    private static int numLength(int num) {

        return String.valueOf(num).length();

    }

    // возвращает среднее арифметическое содержимого целочисленного массива
    private static float arithmeticMean(int[] nums) {
        int sum = sumOfArrayElements(nums);

        return (((float) sum) / nums.length);

    }

    // метод, возвращающий среднее геометрическое содержимого целочисленного массива
    private static double geometricMean(int[] nums) {

        double power = inverseNum(nums.length);


        return Math.pow(multiplyOfArrayElements(nums), power);

    }

    // метод, перемножающий все элементы массива
    private static int multiplyOfArrayElements(int[] arr) {

        int result = 1;
        for (int i : arr) {

            result *= arr[i - 1];

        }

        return result;

    }

    // метод, суммирующий все элементы массива
    private static int sumOfArrayElements(int[] arr) {
        int result = 0;

        for (int i : arr) {

            result += arr[i - 1];

        }

        return result;
    }

    // метод возвращающий число обратное данному
    private static double inverseNum(int num) {

        return ((double) 1) / num;

    }

    // метод, инвертирущий строку
    private static String reverseString(String str) {

        StringBuffer sb = new StringBuffer(str);

        // попытка вызвать GarbageCollector для дальнейшей очистки памяти от StringBuffer
        System.gc();

        return sb.reverse().toString();

    }

    // метод, возвращающий количество цифр в числе
    private static int countOfNums(int num) {

        return (num == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(num) + 0.5));

    }

    // метод, определяющий, находятся ли точки на одной линии
    private static boolean isOnOneLine(int x1, int x2, int x3, int y1, int y2, int y3) {

        return isDifferent(x1, x2, x3) || isDifferent(y1, y2, y3);

    }

    // метод, возвращающий длину отрезка, заданного координатами х1,2 у1,2
    private static double lengthOfLine(int x1, int y1, int x2, int y2) {

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

    }

    // метод, определяющий прямоугольный треугольник по теореме Пифагора
    private static boolean isRectangular(double x1, double x2, double x3) {

        double hypotenuse = greaterNumOfThreeNums(x1, x2, x3);
        double sqrHypo = hypotenuse * hypotenuse;

        return sqrHypo == (x1 * x1 + x2 * x2) || (sqrHypo) == (x2 * x2 + x3 * x3) || sqrHypo == (x3 * x3 + x1 * x1);

    }

    // метод, вычисляющий наибольшее число из трех
    private static double greaterNumOfThreeNums(double x1, double x2, double x3) {

        double temp = Math.max(x1, x2);

        return Math.max(temp, x3);

    }

    private static void outputLengthOfTriangle(int x1, int x2, int x3, int y1, int y2, int y3) {

        System.out.println("this triangle has sides of ");
        System.out.println(lengthOfLine(x1, y1, x2, y2) + " cm");
        System.out.println(lengthOfLine(x2, y2, x3, y3) + " cm");
        System.out.println(lengthOfLine(x3, y3, x1, y1) + " cm");

    }

}
