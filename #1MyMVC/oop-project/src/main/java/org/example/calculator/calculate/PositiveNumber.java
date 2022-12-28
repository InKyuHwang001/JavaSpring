package org.example.calculator.calculate;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)){
            throw new IllegalArgumentException("0또는 음수는 쓰지마");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value<=0;
    }

    public int toInt(){
        return value;
    }
}
