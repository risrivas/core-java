package com.pluralsight.calcengine;

@CommandKeyword(name="divide")
public class Divider implements MathProcessing {
    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal / rightVal;
    }
}
