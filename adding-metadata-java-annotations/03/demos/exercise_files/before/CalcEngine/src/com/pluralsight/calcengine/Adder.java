package com.pluralsight.calcengine;

@CommandKeyword(name="add")
public class Adder implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal + rightVal;
    }
}
