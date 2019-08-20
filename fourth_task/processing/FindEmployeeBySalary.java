package com.company.epam.fourth_task.processing;

import com.company.epam.fourth_task.entities.employees.AbstractEmployee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindEmployeeBySalary {

    public List<AbstractEmployee> find(List<AbstractEmployee> employeeList, long minSalary, long maxSalary) {
        List<AbstractEmployee> suitableEmployees = new ArrayList<AbstractEmployee>();
        Iterator<AbstractEmployee> dataIterator = employeeList.listIterator();
        while (dataIterator.hasNext()) {
            AbstractEmployee next = dataIterator.next();
            long salary = next.getSalary();
            if (salary.compareTo(minSalary) >= 0 && salary.compareTo(maxSalary) <= 0) {
                suitableEmployees.add(next);
            }
        }
        return suitableEmployees;
    }

}
