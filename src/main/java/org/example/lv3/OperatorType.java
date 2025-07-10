package org.example.lv3;

public enum OperatorType {
    ADD('+') {
        @Override
        public double calculate(Number a, Number b) {
            return a.doubleValue() + b.doubleValue();
        }
    },
    SUB('-') {
        @Override
        public double calculate(Number a, Number b) {
            return a.doubleValue() - b.doubleValue();
        }
    },
    MUL('*') {
        @Override
        public double calculate(Number a, Number b) {
            return a.doubleValue() * b.doubleValue();
        }
    },
    DIV('/') {
        @Override
        public double calculate(Number a, Number b) {
            return a.doubleValue() / b.doubleValue();
        }
    };

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public abstract double calculate(Number a, Number b);

    public static OperatorType fromChar(char input) {
        for (OperatorType op : values()) {
            if (op.getOperator() == input) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + input);
    }
}
