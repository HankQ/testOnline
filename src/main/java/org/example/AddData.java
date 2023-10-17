package org.example;


public class AddData {
    private Integer targetA;
    private  Integer targetB;

    public AddData(Integer targetA, Integer targetB) {
        this.targetA = targetA;
        this.targetB = targetB;
    }

    public Integer getTargetA() {
        return targetA;
    }

    public void setTargetA(Integer targetA) {
        this.targetA = targetA;
    }

    public Integer getTargetB() {
        return targetB;
    }

    public void setTargetB(Integer targetB) {
        this.targetB = targetB;
    }
}
