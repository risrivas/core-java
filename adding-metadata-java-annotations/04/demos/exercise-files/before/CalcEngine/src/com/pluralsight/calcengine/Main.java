package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" ");
        String keyword = parts[0];
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);

        process(keyword, leftVal, rightVal);
    }

    private static void process(String keyword, double leftVal, double rightVal) {
        MathProcessing processor = retrieveProcessor(keyword);
        double result = processor.doCalculation(leftVal, rightVal);
        System.out.println("result = " + result);
     }

    private static MathProcessing retrieveProcessor(String keyword) {
        MathProcessing[] processors = {new Adder(), new Subtracter(), new Multiplier(), new Divider()};

        for(MathProcessing processor:processors){
            CommandKeyword commandKeyword = processor.getClass().getAnnotation(CommandKeyword.class);
            String name = commandKeyword.name();
            if(keyword.equalsIgnoreCase(name))
                return processor;
        }

        return null;

    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = -1d;
        for(int index = 0; index < numberWords.length; index++) {
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if(value == -1d)
            value = Double.parseDouble(word);

        return value;
    }

}









