package com.company.epam.fourth_task.entities.employees;

import com.company.epam.fourth_task.entities.enums.NetArchitections;
import com.company.epam.fourth_task.entities.enums.OperationSystems;

public class InfoSecEmployee extends AbstractEmployee {

    private OperationSystems operationSystem;
    private NetArchitections netArchitection;

    public OperationSystems getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(OperationSystems operationSystem) {
        this.operationSystem = operationSystem;
    }

    public NetArchitections getNetArchitection() {
        return netArchitection;
    }

    public void setNetArchitection(NetArchitections netArchitection) {
        this.netArchitection = netArchitection;
    }

    public InfoSecEmployee(String name, String surname, int day, int month, int year, OperationSystems operationSystem, NetArchitections netArchitection) {
        super(name, surname, day, month, year);
        this.operationSystem = operationSystem;
        this.netArchitection = netArchitection;
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
        InfoSecEmployee other = (InfoSecEmployee) obj;
        return (super.equals(other) &&
                this.netArchitection.equals(other.getNetArchitection()) && this.operationSystem.equals(other.getOperationSystem()));
    }
}
