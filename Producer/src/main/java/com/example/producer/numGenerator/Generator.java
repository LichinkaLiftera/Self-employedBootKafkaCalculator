package com.example.producer.numGenerator;

import com.example.producer.configure.RomanNum;

import java.util.Random;

public class Generator {

    private final RomanNum[] romanNums = RomanNum.values();
    private final String[] operation = {"+", "-", "/", "*"};
    private Random random = new Random();

    public String generateExpression() {
        if (random.nextInt(2) == 0) {
            return random.nextInt(101) + " "
                    + operation[random.nextInt(operation.length - 1)] + " "
                    + random.nextInt(101);
        } else {
            int rum2 = random.nextInt(1, 10);
            return romanNums[random.nextInt(rum2 + 1, 11)] +
                    " " + operation[random.nextInt(operation.length - 1)] + " "
                    + romanNums[rum2];
        }
    }
}
