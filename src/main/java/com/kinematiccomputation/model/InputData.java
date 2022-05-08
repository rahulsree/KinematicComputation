package com.kinematiccomputation.model;

public class InputData {
    double[] inputVector;
    int excludedVariable;
    int targetVariable;

    public double[] getInputVector() {
        return inputVector;
    }

    public void setInputVector(double[] inputVector) {
        this.inputVector = inputVector;
    }

    public int getExcludedVariable() {
        return excludedVariable;
    }

    public void setExcludedVariable(int excludedVariable) {
        this.excludedVariable = excludedVariable;
    }

    public int getTargetVariable() {
        return targetVariable;
    }

    public void setTargetVariable(int targetVariable) {
        this.targetVariable = targetVariable;
    }
}
