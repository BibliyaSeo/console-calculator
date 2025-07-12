package org.example.lv3;

public enum OperatorType {
    // 처음엔 여기서 계산했는데 CalculatorUtil로 따로 빼서 계산
    ADD('+'),
    SUB('-'),
    MUL('*'),
    DIV('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    // 연산자 매칭하기 (예. + 입력시 ADD return)
    public static OperatorType matchOperator(char operator) {
        for (OperatorType op : values()) {
            if (op.getOperator() == operator) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator);
    }
}
