package com.company.epam.fourth_task.comparators;

import com.company.epam.fourth_task.entities.employees.AbstractEmployee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<AbstractEmployee> {

    public int compare(AbstractEmployee o1, AbstractEmployee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }

}
