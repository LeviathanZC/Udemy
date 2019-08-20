package com.company.epam.fourth_task.entities;

public class Person {

    private final String firstName;
    private final String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public Person(final String name, final String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = name;
        this.lastName = surname;
        setBirthday(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    private void setBirthday(int day, int month, int year){
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
