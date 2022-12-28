package org.example.calculator.calculate;

public interface NewArithmeicOperator {
    Boolean supports(String operator);
    int calculate(PositiveNumber operand1,PositiveNumber operand2);

}
