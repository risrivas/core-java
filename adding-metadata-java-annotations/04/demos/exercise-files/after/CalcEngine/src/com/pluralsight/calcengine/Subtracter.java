package com.pluralsight.calcengine;

@CommandKeyword(value ="subtract")
public class Subtracter implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal - rightVal;
    }
}
