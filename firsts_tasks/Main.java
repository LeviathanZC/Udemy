package com.company.epam.firsts_tasks;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        frontTask3();

    }


    /**
     **  Разработайте программу, которая проверяет,
     **      что числа a, b и c различны (одинаковы).
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

        System.out.println("\n program successfully completed!");

    }


    /**
     **      Масса динозавра задаётся в килограммах. Разработайте программу,
     **          которая вычисляет, сколько это миллиграмм, грамм и тонн.
     **/
    private static void transferDinoMass() {

        System.out.print("input mass of dinosaur");
        int massDinosaur = input();
        System.out.println("\nmass of dinosaur is " + massDinosaur + " kg");
        System.out.println("\n\nmass of dinosaur (mg) is " + transferToMg(massDinosaur) + " mg");
        System.out.println("\n\nmass of dinosaur (g) is " + transferToGr(massDinosaur) + " g");
        System.out.println("\n\nmass of dinosaur (t) is " + transferToTons(massDinosaur) + " t");

        System.out.println("\n program successfully completed!");
    }



    /**
     **      На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).
     **      Разработайте программу нахождения площади кольца, внешний радиус которого
     **                   равен R1, а внутренний радиус равен R2.
     **/
    private static void frontTask3() {

        System.out.println("input radius R1");
        int r1 = input();
        System.out.println("input radius R2");
        int r2 = input();
        System.out.println("the ring area equals " + areaOfRing(areaOfCircle(r1), areaOfCircle(r2)));

        System.out.println("\n program successfully completed!");
    }


    private static int input() throws InputMismatchException {

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

    private static boolean isDifferent(int a, int b, int c) {

        if (a == b && b == c) {
            return true;
        } else return false;

    }

    private static float transferToTons(int num) {

        return num * 0.001F;

    }

    private static int transferToGr(int num) {

        return num * 1000;

    }

    private static long transferToMg(int num) {

        return ((long) num) * 1_000_000;

    }

    private static double areaOfCircle(int R) {

        return Math.PI * (R * R);

    }

    private static double areaOfRing(double area1, double area2) {
        if (area1 > area2) {
            return area1 - area2;
        } else {
            System.out.println("inversion of areas...");
            return area2 - area1;
        }
    }


}
