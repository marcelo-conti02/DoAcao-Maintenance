package com.ages.doacaobackend.business.dto.urgentOrder;

public class UrgentOrderComponentMember {
    private int componentAmount;
    private String componentName;
    private String componentMeasurementUnity;

    public UrgentOrderComponentMember(int componentAmount, String componentName, String componentMeasurementUnity) {
        this.componentMeasurementUnity = componentMeasurementUnity;
        this.componentAmount = componentAmount;
        this.componentName = componentName;
    }

    public int getComponentAmount() {
        return componentAmount;
    }

    public void setComponentAmount(int componentAmount) {
        this.componentAmount = componentAmount;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentMeasurementUnity() {
        return componentMeasurementUnity;
    }

    public void setComponentMeasurementUnity(String componentMeasurementUnity) {
        this.componentMeasurementUnity = componentMeasurementUnity;
    }

    public UrgentOrderComponentMember withComponentAmount(int componentAmount) {
        this.componentAmount = componentAmount;
        return this;
    }

    public UrgentOrderComponentMember withComponentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    public UrgentOrderComponentMember withComponentMeasurementUnity(String componentMeasurementUnity) {
        this.componentMeasurementUnity = componentMeasurementUnity;
        return this;
    }
}
