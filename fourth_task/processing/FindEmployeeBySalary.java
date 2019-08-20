package com.company.epam.fourth_task.processing;

public class FindEmployeeBySalary {

    public List<AbstractEmployee> find(List<AbstractEmployee> employeeList, long minSalary,long maxSalary){
        List<AbstractEmployee> suitableEmployees= new ArrayList<AbstractEmployee>();
        Iterator<AbstractEmployee> dataIterator = employeeList.listIterator();
        while (dataIterator.hasNext()) {
            AbstractEmployee next = dataIterator.next();
            long salary=next.getSalary();
            if (salary.compareTo(minSalaty)>=0 &&salary.compareTo(maxSalary)<=0){
                suitableEmployees.add(next);
            }
        }
        return suitableEmployees;
    }

}
