package com.company.epam.fourth_task.entities.employees;

public class Employee extends Person {

    public static final int MINIMAL_WAGE = 165;
    public static int countOfEmployers;


    private int salary;
    private int accessLevel;
    private String position;

    public Employee(String name, String surname, int day, int month, int year, boolean isMilitariant){
        super(name, surname, day, month, year, isMilitariant);
        countOfEmployers++;
    }





}
