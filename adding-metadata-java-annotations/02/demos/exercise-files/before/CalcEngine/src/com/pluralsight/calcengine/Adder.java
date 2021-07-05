package com.pluralsight.calcengine;

public class Adder implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal + rightVal;
    }
}
