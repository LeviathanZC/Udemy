package com.company.epam.firsts_tasks;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        frontTask2();

    }

    public static void frontTask1() {

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

        System.out.println("\n program successfully completed!");

    }

    public static void frontTask2() {

        System.out.print("input mass of dinosaur");
        int massDinosaur = input();
        System.out.println("\nmass of dinosaur is " + massDinosaur + " kg");
        System.out.println("\n\nmass of dinosaur (mg) is " + transferToMg(massDinosaur) + " mg");
        System.out.println("\n\nmass of dinosaur (g) is " + transferToGr(massDinosaur) + " g");
        System.out.println("\n\nmass of dinosaur (t) is " + transferToTons(massDinosaur) + " t");

    }


    public static int input() throws InputMismatchException {

        Scanner scan = new Scanner(System.in);

        /**
         **  Обработка исключения при вводе числа
         **       с помощью утилиты Scanner
         **
         **
         **
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

    public static float transferToTons(int num){

        return num * 0.001F;

    }

    public static int transferToGr(int num){

        return num * 1000;

    }

    public static long transferToMg(int num){

        return ((long)num) * 1_000_000;

    }


}
