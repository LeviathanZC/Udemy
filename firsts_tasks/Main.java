package com.company.epam.firsts_tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class Main {

    public static void main(String[] args) throws java.io.IOException, InterruptedException {

        frontTask1();

    }

    public static void frontTask1() throws java.io.IOException, InterruptedException {
        Runtime runtime = getRuntime();


        int a; int b; int c;

        System.out.println("input a");
        a = input();
        System.out.println();
        System.out.println("input b");
        b = input();
        System.out.println();
        System.out.println("input c");
        c = input();

        if (isDifferent(a,b,c)) {
            System.out.println("\nAll numbers is the same");
        } else {
            System.out.println("\nAll numbers is different");
        }

        System.out.println("\n program successfully completed!");

    }

    public static int input() throws InputMismatchException {

        Scanner scan = new Scanner(System.in);

        /**
         **  Обработка исключения при вводе числа
         **       с помощью утилиты Scanner
         **/

        try {

            return scan.nextInt();

        } catch (InputMismatchException e) {

            System.out.println("\nInput Mismatch Exception \ninterrupted exception");
            return 0;

        } catch (Exception e) {

            System.out.println("Unexpected error");
            return 0;

        }

    }

    public static boolean isDifferent(int a, int b, int c) {

        if (a == b && b == c) {
            return true;
        } else return false;

    }

}
