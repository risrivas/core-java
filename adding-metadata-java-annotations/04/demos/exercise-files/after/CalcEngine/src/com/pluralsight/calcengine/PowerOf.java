package com.pluralsight.calcengine;

@CommandKeyword("power")
public class PowerOf {

    public double calculate(double leftVal, double rightVal) {
        return Math.pow(leftVal, rightVal);
    }
}
