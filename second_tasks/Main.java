package com.company.epam.second_tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            friendlyNumbers();

        } catch (Exception e) {
            System.out.println("Exception. ");
        } finally {
            System.out.println("\n\t the program is executed and must be closed");
        }

    }

    /**
     * Необходимо написать программу «Heads or Tails?» («Орёл или решка?»),
     * которая бы «подбрасывала» условно монету, к примеру, 1000 раз и сообщала,
     * сколько раз выпал орёл, а сколько – решка.
     **/
    private static void headsOrTails() {

        //frontend
        System.out.println("input number of iterations");

        //ввод количества итераций
        int iterations = input();

        //переменные со значениями количества выпаданий "орла" или "решки"
        int counterOfHeads = 0;
        int counterOfTails = 0;


        for (int i = 0; i < iterations; i++) {

            switch ((int) Math.round(Math.random())) {

                case 0: {
                    counterOfHeads++;
                    break;
                }
                case 1: {
                    counterOfTails++;
                    break;
                }
                default: {
                    System.out.println("Unexpected token");
                    continue;
                }

            }

        }

        System.out.printf("\n\t\tRESULTS\n");
        System.out.println("\n\t number of Heads: " + counterOfHeads);
        System.out.println("\n\t number of Tails: " + counterOfTails);
    }

    /**
     * найти наибольшую цифру натурального числа;
     **/
    private static void maxNum() {

        boolean access = false;

        int naturalNumber;

        // осуществление ввода числа и проверки его на натуральность
        do {
            System.out.println("input natural number");

            naturalNumber = input();

            // проверка числа на натуральность
            if (naturalNumber >= 0) {

                // т.к. метод input при неверном вводе возвращает 0, это нужно учесть
                if (naturalNumber == 0) {
                    System.out.println("the entered is not natural. Transformation to 1");
                    naturalNumber = 1;
                    access = true;
                } else {
                    access = true;
                }

            } else {
                System.out.println("the entered number is not natural\n \n \t try again...\n");
            }
        } while (!access);


        int maxDigit = 0;

        System.out.println("the maximum digit of the number is " + maxDigit(naturalNumber));


    }

    /**
     * определить является ли заданное натуральное число простым;
     **/
    private static void primeCheck() {

        System.out.println("input number for prime checking");

        int primeNum = input();

        if (isPrime(primeNum)) {
            System.out.println("\n\tnumber " + primeNum + " is PRIME");
        } else {
            System.out.println("\n\tnumber " + primeNum + " is NOT PRIME");
        }

    }

    /**
     * найти все простые делители заданного натурального числа;
     **/
    private static void factorization() {

        System.out.println("input number");

        int number = input();

        if (isNatural(number)) {

            System.out.print("prime divisors of number " + number + " is: ");

            for (int i = 2; i < number; i++) {

                if (number % i == 0) {

                    if (isPrime(i)) {
                        System.out.print(i + " ");
                    }
                }

            }
        } else {
            System.out.println("the entered number is NOT natural");
        }

    }

    /**
     * найти НОД и НОК двух натуральных чисел a и b.
     **/
    private static void greatestCommonDivisorAndLeastCommonMultiply() {

        System.out.println("input 2 numbers");
        System.out.print("input the 1st num: ");
        int firstNum = input();
        System.out.print("\ninput 2nd num: ");
        int secondNum = input();

        System.out.println("\n\tgcd(" + firstNum + "," + secondNum + ") = " + gcd(Math.abs(firstNum), Math.abs(secondNum)));
        System.out.println("\n\tlcm(" + firstNum + "," + secondNum + ") = " + lcm(Math.abs(firstNum), Math.abs(secondNum)));

    }

    /**
     * проверить, является ли заданное натуральное число палиндромом;
     **/
    private static void isPalindrome() {

        System.out.print("input number:");
        int number = input();

        if (!isNatural(number)) {

            number = Math.round(Math.abs(number));

        }

        if (isPalindrome(number)) {
            System.out.println("\n the entered number " + number + " is palindrome");
        } else {
            System.out.println("\n the entered number " + number + " is NOT palindrome");
        }


    }


    /**
     * найти количество различных цифр у заданного натурального числа.
     **/
    private static void numberOfDigits() {

        System.out.print("input number: ");
        int number = input();

        if (!isNatural(number)) {
            number = Math.round(Math.abs(number));
        }

        System.out.println("\n number of digits is : " + numberOfDigits(number));

    }

    /**
     * Натуральное число называют совершенным, если оно равно сумме всех своих
     * делителей, не считая только его самого (например, 28=1+2+3+7+14 –
     * совершенное число). Напишите программу, которая проверяет, является ли
     * введённое натуральное число совершенным. Для проверки работоспособности
     * программы приводится список некоторых совершенных чисел: 6, 28, 496, 8128.
     **/
    private static void perfectNums() {

        System.out.println("input number");
        int number = input();

        if (!isNatural(number)) {

            number = Math.round(Math.abs(number));

        } else if (isPerfect(number)) {

            System.out.println("number " + number + " is perfect!");

        } else System.out.println("number " + number + " is NOT perfect.");


    }

    /**
     * Дру́жественные чи́сла — два различных натуральных числа , для которых
     * сумма всех собственных делителей первого числа равна второму числу и
     * наоборот, сумма всех собственных делителей второго числа равна первому
     * числу. Дружественные числа были открыты последователями Пифагора ,
     * которые, однако, знали только одну пару дружественных чисел – 220 и 284.
     * Найдите все дружественные числа в заданном диапазоне.
     **/

    private static void friendlyNumbers() {
        System.out.println("input interval ");

        System.out.print("\n input [");
        int a = input();
        System.out.print(a + ",");
        int b = input();
        System.out.println("] - the interval is complete!");

        int sum; // сумма делителей первого числа
        int sum1; // сумма делителей s

        // цикл для проверки первых чисел
        for (int i = a; i < b; i++) {

            sum = 0;

            // находим все делители числа а, исключая само число
            for (int j = 1; j < a - 1; j++) {

                if (a % i == 0) { // поиск суммы делителей a
                    sum += i;
                }

            }

            sum1 = 0;

            for (int k = 1; k < sum - 1; k++) {

                if (sum % k == 0) {
                    sum1 += k;
                }

            }

            if ((sum1 == i) && (sum != i)) {
                System.out.println("numbers " + i + " and " + sum + " is friendly");
            }
        }


    }
    //TODO: переписать заново алгоритм решения



    // ОБЛАСТЬ ПРИКЛАДНЫХ МЕТОДОВ

    /*  метод, позволяюющий осуществлять ввод с клавиатуры
            с помощью объекта Scanner.
            TODO: Реализация выбора типа вводимых данных
    */
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

    // рекурсивный метод нахождения максимальной цифры в строковом представлении числа
    // !!! STACKOVERFLOW !!!
    // рабочая замена находится после
    private static int maxDigit(int num, int maxDigit) {

        if (num % 10 > maxDigit) {
            maxDigit = num % 10;
            num /= 10;
            return maxDigit(num, maxDigit);
        } else {
            num /= 10;
            return maxDigit(num, maxDigit);
        }

    }

    // перегруженная рабочая версия предыдущего метода
    private static int maxDigit(int num) {

        int maxInt = num % 10;
        num /= 10;
        while (num > 0) {
            if (num % 10 > maxInt) {
                maxInt = num % 10;
            }
            num /= 10;
        }

        return maxInt;
    }

    // метод проверки числа на простоту простым перебором делителей
    private static boolean isPrime(int number) {

        boolean isPrime = true;

        for (int i = 2; i <= Math.round(Math.sqrt(number)); i++) {

            if (number % i == 0) {
                isPrime = false;
                break;
            }

        }

        return isPrime;

    }

    // метод проверки числа на натуральность, с учетом возможности возврата методо input значения 0
    // USELESS
    private static boolean isNatural(int number) {
        return number > 0;
    }

    // метод нахождения НОД алгоритмом Евклида
    private static int gcd(int a, int b) {

        while (a != b) {

            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }

        }
        return a;
    }

    // метод нахождения НОК через формулу с НОД
    private static int lcm(int a, int b) {

        return a / gcd(a, b) * b;

    }

    // метод проверки числа на палиндром
    private static boolean isPalindrome(int number) {
        int temp1 = number;
        int temp2 = 0;

        while (temp1 > 0) {

            temp2 = temp2 * 10 + (temp1 % 10);
            temp1 /= 10;

        }

        return temp2 == number;


    }

    // метод возвращающий количество различных цифр, входящих в одно число
    private static int numberOfDigits(int number) {

        String num = Integer.toString(number);

        String numbers = new String("");

        for (int i = 0; i < num.length(); i++) {

            switch (num.charAt(i)) {

                case '0': {
                    if (numbers.indexOf('0') == -1) {
                        numbers = numbers.concat("0");
                    }
                    break;
                }
                case '1': {
                    if (numbers.indexOf('1') == -1) {
                        numbers = numbers.concat("1");
                    }
                    break;
                }
                case '2': {
                    if (numbers.indexOf('2') == -1) {
                        numbers = numbers.concat("2");
                    }
                    break;
                }
                case '3': {
                    if (numbers.indexOf('3') == -1) {
                        numbers = numbers.concat("3");
                    }
                    break;
                }
                case '4': {
                    if (numbers.indexOf('4') == -1) {
                        numbers = numbers.concat("4");
                    }
                    break;
                }
                case '5': {
                    if (numbers.indexOf('5') == -1) {
                        numbers = numbers.concat("5");
                    }
                    break;
                }
                case '6': {
                    if (numbers.indexOf('6') == -1) {
                        numbers = numbers.concat("6");
                    }
                    break;
                }
                case '7': {
                    if (numbers.indexOf('7') == -1) {
                        numbers = numbers.concat("7");
                    }
                    break;
                }
                case '8': {
                    if (numbers.indexOf('8') == -1) {
                        numbers = numbers.concat("8");
                    }
                    break;
                }
                case '9': {
                    if (numbers.indexOf('9') == -1) {
                        numbers = numbers.concat("9");
                    }
                    break;
                }
                default: {
                    System.out.println("Unexpected token");
                }

            }

        }

        return numbers.length();

    }

    // метод, проверяющий число на совершенность
    private static boolean isPerfect(int number) {

        int sum = 0;

        for (int i = number - 1; i >= 1; i--) {

            if (number % i == 0) {
                sum += i;
            }

        }

        return sum == number;

    }
}
