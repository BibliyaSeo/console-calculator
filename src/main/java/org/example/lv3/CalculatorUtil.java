package org.example.lv3;

public class CalculatorUtil {

    public static double calculate(Number a, Number b, OperatorType operator) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        return switch (operator) {
            case ADD -> num1 + num2;
            case SUB -> num1 - num2;
            case MUL -> num1 * num2;
            case DIV -> {
                if (num2 == 0.0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        };
    }
}
