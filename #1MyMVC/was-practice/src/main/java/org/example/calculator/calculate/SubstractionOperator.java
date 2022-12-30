package org.example.calculator.calculate;

import org.example.calculator.calculate.NewArithmeicOperator;

public class SubstractionOperator implements NewArithmeicOperator {


    @Override
    public Boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
