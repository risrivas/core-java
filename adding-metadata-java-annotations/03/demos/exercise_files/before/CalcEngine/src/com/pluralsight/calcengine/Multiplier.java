package com.pluralsight.calcengine;

@CommandKeyword(name="multiply")
public class Multiplier implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal * rightVal;
    }
}
