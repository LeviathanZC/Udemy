package com.company.epam.fourth_task.entities.employees;

import com.company.epam.fourth_task.entities.enums.SoftwareLanguages;

public class SoftDevEmployee extends AbstractEmployee {

    private SoftwareLanguages softwareLanguage;

    public SoftDevEmployee(String name, String surname, int day, int month, int year, SoftwareLanguages softwareLanguages) {
        super(name, surname, day, month, year);
        this.softwareLanguage = softwareLanguages;
    }

    public SoftwareLanguages getSoftwareLanguage() {
        return softwareLanguage;
    }

    public void setSoftwareLanguage(SoftwareLanguages softwareLanguage) {
        this.softwareLanguage = softwareLanguage;
    }

    @Override
    public String toString() {
        return super.toString() + " using " + this.softwareLanguage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + softwareLanguage.hashCode();
        return result;
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
        SoftDevEmployee other = (SoftDevEmployee) obj;
        return (super.equals(other) &&
                this.softwareLanguage.equals(other.getSoftwareLanguage()));
    }
}
