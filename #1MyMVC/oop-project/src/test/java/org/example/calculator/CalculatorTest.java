package org.example.calculator;

import net.bytebuddy.asm.Advice;
import org.example.calculator.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {
//
//    //1+2--->Calculator
//    @DisplayName("덧셈연산 정상적실행")
//    @Test
//    void additionTest() {
//        int result = Calculator.calculate(1,"+",2);
//
//        assertThat(result).isEqualTo(3);
//    }

    @DisplayName("사칙연산 정상적실행")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calulatorTest(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1),operator,new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }
    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",1,0),
                arguments(1,"*",2,2),
                arguments(2,"/",2,1)
        );
    }

    @DisplayName("나눗셈에서 0으로 나누면 결과")
    @Test
    void calculateExceptionTest() {

        assertThatCode(()->Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수는 쓰지마");
    }
}
