package org.example.lv3;

public enum OperatorType {
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
