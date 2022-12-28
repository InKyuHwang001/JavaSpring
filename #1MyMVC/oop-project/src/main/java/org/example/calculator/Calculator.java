package org.example.calculator;

import org.example.calculator.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeicOperator> arithmeticOperators = List.of(new AdditionOperator(), new DivisionOperator(), new MultiplicationOperator(), new SubstractionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("올바른 사칙연산이 아니오"));
    }
}
