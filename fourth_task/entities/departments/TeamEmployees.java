package com.company.epam.fourth_task.entities.departments;

import com.company.epam.fourth_task.entities.employees.AbstractEmployee;

import java.util.List;

public class TeamEmployees {

    private List<AbstractEmployee> employeeList;

    public TeamEmployees(List<AbstractEmployee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<AbstractEmployee> getEmployeeList() {
        return employeeList;
    }

    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(null==obj) {
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        TeamEmployees other = (TeamEmployees) obj;
        return this.employeeList.equals(other.employeeList);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result=1;
        result = prime * result + this.employeeList.hashCode();
        return result;
    }

}
