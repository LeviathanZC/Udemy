package com.company.epam.fourth_task.entities.employees;

import com.company.epam.fourth_task.entities.enums.WebDevLanguages;

public class WebDevEmployee extends AbstractEmployee {

    private WebDevLanguages webDevLanguage;

    public WebDevEmployee(String name, String surname, int day, int month, int year, WebDevLanguages webDevLanguage) {
        super(name, surname, day, month, year);
        this.webDevLanguage = webDevLanguage;
    }

    public WebDevLanguages getWebDevLanguage() {
        return webDevLanguage;
    }

    public void setWebDevLanguage(WebDevLanguages webDevLanguage) {
        this.webDevLanguage = webDevLanguage;
    }

    @Override
    public String toString() {
        return super.toString() + " using " + this.webDevLanguage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + webDevLanguage.hashCode();
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
        WebDevEmployee other = (WebDevEmployee) obj;
        return (super.equals(other) &&
                this.webDevLanguage.equals(other.getWebDevLanguage()));
    }


}
