package com.example.consumer.functions;

import com.example.consumer.configure.RomanNum;

public class Calculator {
    private final RomanNum[] romanNum = RomanNum.values();
    private final String romanFormat = "[IVXLC]+";
    private final String arabicFormat = "\\d+";

    public String calculate(String expression) {
        String result;
        byte format;
        double num1;
        double num2;
        String[] str = expression.split(" ");
        if (str[0].matches(romanFormat) && str[2].matches(romanFormat)) {
            format = 0;
            num1 = RomanNum.valueOf(str[0]).ordinal();
            num2 = RomanNum.valueOf(str[2]).ordinal();
        } else if (str[0].matches(arabicFormat) && str[2].matches(arabicFormat)) {
            format = 1;
            num1 = Integer.parseInt(str[0]);
            num2 = Integer.parseInt(str[2]);
        } else
            return "Different numbers format -> " + expression;
        if (str[1].equals("/") && num2 == 0) {
            return expression + "<- Don't divide by zero";
        }
        if (format == 0) {
            switch (str[1]) {
                case "+" -> result = String.valueOf(romanNum[(int) (num1 + num2)]);
                case "-" -> result = String.valueOf(romanNum[(int) (num1 - num2)]);
                case "*" -> result = String.valueOf(romanNum[(int) (num1 * num2)]);
                case "/" -> result = String.valueOf(romanNum[(int) (num1 / num2)]);
                default -> {
                    return "Unknown operation ->" + expression;
                }
            }
        } else {
            switch (str[1]) {
                case "+" -> result = String.valueOf(num1 + num2);
                case "-" -> result = String.valueOf(num1 - num2);
                case "*" -> result = String.valueOf(num1 * num2);
                case "/" -> result = String.valueOf(num1 / num2);
                default -> {
                    return "Unknown operation ->" + expression;
                }

            }
        }
        return expression + " = " + result;
    }
}