package com.company.epam.fourth_task.entities.employees;

public class Employee extends Person {

    public static final int MINIMAL_WAGE = 165;
    public static int countOfEmployers;


    private int salary;
    private int accessLevel;
    private String department;
    private String position;
    private int id;

    private int expirienceYears;
    private Levels level;


    public Employee(String name, String surname, int day, int month, int year, boolean isMilitariant) {
        super(name, surname, day, month, year, isMilitariant);
        countOfEmployers++;
    }

    private void setLevel() {
        if (expirienceYears < 1) {
            level = Levels.PRE_JUNIOR;
        } else if (expirienceYears < 4) {
            level = Levels.JUNIOR;
        } else if (expirienceYears < 7) {
            level = Levels.MIDDLE;
        } else if (expirienceYears < 9) {
            level = Levels.SENIOR;
        } else if (expirienceYears < 11) {
            level = Levels.TEAMLEADER;
        } else {
            level = Levels.UNDEFINED;
        }
    }

    private void setDepartment(String department){
        this.department = department;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
    }
}
