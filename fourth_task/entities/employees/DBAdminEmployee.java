package com.company.epam.fourth_task.entities.employees;

import com.company.epam.fourth_task.entities.enums.DataBases;

public class DBAdminEmployee extends AbstractEmployee {

    private DataBases db;

    public DBAdminEmployee(String name, String surname, int day, int month, int year, DataBases db) {
        super(name, surname, day, month, year);
        this.db = db;
    }

    public DataBases getDb() {
        return db;
    }

    public void setDb(DataBases db) {
        this.db = db;
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
        DBAdminEmployee other = (DBAdminEmployee) obj;
        return (super.equals(other) &&
                this.db.equals(other.getDb()));
    }

    @Override
    public String toString() {
        return super.toString() + " using " + this.db;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + db.hashCode();
        return result;
    }

}
