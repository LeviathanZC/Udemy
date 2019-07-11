package com.company.epam.firsts_tasks;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {



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


    /**
     * В молодом возрасте дракон каждый год отращивает по три головы, но после того,
     * как ему исполнится 200 лет – только по две, а после 300 лет – лишь по одной.
     * Предполагается, что дракон появляется на свет сразу с тремя головами.
     * Разработайте программу, которая высчитывала бы, сколько голов и глаз у дракона, которому N лет?
     **/
    private static void howManyHeadsAndEyes() {

        System.out.println("input age of Dragon");
        int age = input();

        if (age > 200) {

            if (age > 300) {

                int heads = (age - 300) + 100 * 2 + 200 * 3;
                System.out.println("Dragon have " + heads + " heads and " + (heads * 2) + " eyes");

            } else {

                int heads = (age - 200) * 2 + 200 * 3;
                System.out.println("Dragon have " + heads + " heads and " + (heads * 2) + " eyes");

            }

        } else {

            int heads = age * 3;
            System.out.println("Dragon have " + heads + " heads and " + (heads * 2) + " eyes");

        }

    }

    /**
     * Напишите программу, которая бы определяла, является ли введённая буква (символ) гласной
     * (постарайтесь сделать минимум четырьмя способами, разрешается и больше).
     **/
    private static void isVowel() throws java.io.IOException {

        boolean access = false;
        int type;

        System.out.println("input type of checking letter ( 1..4)");
        do {

            access = (((type = input()) >= 0) && ((type = input()) <= 4));
            if (access) {
                System.out.println("Failed... try again");
            }

        } while (!access);

        System.out.print("input the letter: ");
        char ch = (char) System.in.read();

        switch (type) {
            case 1: {
                if (isVowelFirstMethod(ch)) {
                    System.out.println("This is vowel");
                } else {
                    System.out.println("This is consonant letter or is not letter at all");
                }
                break;
            }
            case 2: {
                if (isVowelSecondMethod(ch)) {
                    System.out.println("This is vowel");
                } else {
                    System.out.println("This is consonant letter or is not letter at all");
                }
                break;
            }
            case 3: {
                if (isVowelThirdMethod(ch)) {
                    System.out.println("This is vowel");
                } else {
                    System.out.println("This is consonant letter or is not letter at all");
                }
                break;
            }
            case 4: {
                if (isVowelFourthMethod(ch)) {
                    System.out.println("This is vowel");
                } else {
                    System.out.println("This is consonant letter or is not letter at all");
                }
                break;
            }
            default: {
                System.out.println("Unexpected token");
            }
        }


    }

    /**
     * Заданы три целых числа, которые задают некоторую дату по Грегорианскому календарю
     * (https://ru.wikipedia.org/wiki/Григорианский_календарь).
     * Определить дату следующего дня. Запрещается использовать типы стандартной библиотеки
     * языка для работы с датой и временем.
     * Также необходимо учесть то, что по григорианскому календарю (используется в настоящий момент)
     * високосный год определяется следующим образом:
     *  годы, кратные 4 – високосные (например, 2008, 2012, 2016);
     *  годы, кратные 4 и 100 – невисокосные (например, 1700, 1800, 1900);
     *  годы, кратные 4, 100 и 400 – високосные (например, 1600, 2000, 2400).
     **/
    private static void whatIsTheNextDay() {

        boolean access = false;
        int day = 1;
        int month = 1;
        int year = 1970;
        boolean leap = false;


        System.out.println("input today's date");
        do {

            System.out.print("\tday : ");
            day = input();
            System.out.println();

            // проверка на существование введенного дня
            if (day > 31 || day < 1) {

                System.out.println("incorrect data. Day cannot be bigger than 31 and less than 1");

            } else {

                access = true;


                do {
                    System.out.print("\tmonth : ");
                    month = input();
                    System.out.println();

                    // проверка на существование месяца
                    if (month > 12 || month < 1) {

                        System.out.println("incorrect data. Month cannot be bigger than 12 and less than 1");
                        access = false;

                    } else {

                        access = true;


                        do {
                            System.out.print("\tyear : ");
                            year = input();
                            System.out.println();

                            if (year < 0 || year < 1970) {

                                System.out.println("there is no internet and Java here. Try again :P");

                            } else {

                                if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
                                    System.out.println("this year is a leap year\n");
                                    leap = true;
                                }

                                if (leap && day > 29) {

                                    System.out.println("incorrect data. February has only 29 days. " +
                                            "Day has been reformatted from " + day + " to 29");

                                } else if (day > 28 && month == 2) {

                                    System.out.println("incorrect data. February has only 28 days. " +
                                            "Day has been reformatted from " + day + " to 28");

                                }
                            }

                        } while (!access);

                    }

                } while (!access);
            }

        } while (!access);

        day++;

        // в феврале 28(9) дней
        if ((leap && (month == 2 && day > 29)) || month == 2 && day > 28) {
            day = 1;
            month++;
        } else if (month == 6 && day > 31) {
            day = 1;
            month++;
        } else if (month == 12 && day > 31) {
            day = 1;
            month = 1;
            year++; //новый год :D
        } else if (month % 2 == 0 && day > 30) {
            day = 1;
            month++;
        } else if (day > 31) {
            day = 1;
            month++;
        }

        System.out.println("Next day date is : " + day + "." + month + "." + year);


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

    // метод, выводящий в консоль длины сторон треугольника
    private static void outputLengthOfTriangle(int x1, int x2, int x3, int y1, int y2, int y3) {

        System.out.println("this triangle has sides of ");
        System.out.println(lengthOfLine(x1, y1, x2, y2) + " cm");
        System.out.println(lengthOfLine(x2, y2, x3, y3) + " cm");
        System.out.println(lengthOfLine(x3, y3, x1, y1) + " cm");

    }

    // метод, определяющий гласную, путем перебора гласных через оператор SWITCH
    private static boolean isVowelFirstMethod(char ch) {

        boolean isVowel;
        char chr = Character.toLowerCase(ch);

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': {
                isVowel = true;
                break;
            }
            case 'y':
            case 'w': {
                System.out.println("Conventionally");
                isVowel = true;
                break;
            }
            default: {

                isVowel = false;
            }


        }
        return isVowel;
    }

    // метод, определяющий гласную, путем перебора символов заданной строки
    private static boolean isVowelSecondMethod(char ch) {
        char chr = Character.toLowerCase(ch);
        String vowels = "aeiouyw";
        boolean isVowel = false;

        for (int i = 0; i < vowels.length(); i++) {

            if (chr == vowels.charAt(i)) {
                isVowel = true;
            }

        }

        return isVowel;
    }

    // метод, определяющий гласную, путем проверки управляющими операторами IF-ELSE
    private static boolean isVowelThirdMethod(char ch) {

        char chr = Character.toLowerCase(ch);
        boolean isVowel = false;

        if (chr == 'a') {
            isVowel = true;
        } else if (chr == 'e') {
            isVowel = true;
        } else if (chr == 'i') {
            isVowel = true;
        } else if (chr == 'o') {
            isVowel = true;
        } else if (chr == 'u') {
            isVowel = true;
        } else if (chr == 'y') {
            isVowel = true;
        } else if (chr == 'y') {
            isVowel = true;
        }

        return isVowel;
    }

    // NOT READY! TODO!
    private static boolean isVowelFourthMethod(char ch) {

        return isVowelSecondMethod(ch);

    }
}
