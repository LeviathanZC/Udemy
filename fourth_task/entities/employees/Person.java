package com.company.epam.fourth_task.entities.employees;

public class Person {

    private String name;
    private String surname;
    private boolean isMilitarian;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public Person(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this(name, surname, dayOfBirth, monthOfBirth, yearOfBirth, false);
    }

    public Person(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth, boolean isMilitarian) {
        this.name = name;
        this.surname = surname;
        this.isMilitarian = isMilitarian;
        setBirthday(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    private void setBirthday(int day, int month, int year){
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
    }


}
