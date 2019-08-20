package com.company.epam.fourth_task.entities.employees;

import com.company.epam.fourth_task.entities.Person;
import com.company.epam.fourth_task.entities.enums.Levels;

public abstract class AbstractEmployee extends Person {

    public static final int MINIMAL_WAGE = 165;
    public static int countOfEmployers;


    private int salary;
    int accessLevel;
    private String department;
    private String position;
    private int id;

    private int expirienceYears;
    private Levels level;


    public AbstractEmployee(String name, String surname, int day, int month, int year) {
        super(name, surname, day, month, year);
        countOfEmployers++;
    }

    public void setExpirienceYears(int expirienceYears) {
        this.expirienceYears = expirienceYears;
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

    private void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = (this.department.hashCode() + this.position.hashCode()) * this.level.hashCode();
    }

    public static int getMinimalWage() {
        return MINIMAL_WAGE;
    }

    public static int getCountOfEmployers() {
        return countOfEmployers;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractEmployee other = (AbstractEmployee) obj;
        return (this.salary == other.getSalary()) &&
                this.getFirstName().equals(other.getFirstName()) &&
                this.getLastName().equals(other.getLastName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + salary;
        result = prime * result + this.getFirstName().hashCode();
        result = prime * result + this.getLastName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee:" + this.getFirstName() + " " + this.getLastName() + " with salary" + salary;
    }
}

