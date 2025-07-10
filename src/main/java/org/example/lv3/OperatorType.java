package org.example.lv3;

public enum OperatorType {
    ADD('+') {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    SUB('-') {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MUL('*') {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIV('/') {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public abstract int calculate(int a, int b);

    public static OperatorType fromChar(char input) {
        for (OperatorType op : values()) {
            if (op.getOperator() == input) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + input);
    }
}
