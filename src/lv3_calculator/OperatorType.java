package lv3_calculator;

import java.util.Arrays;

public enum OperatorType {
    // 상수 메서드
    PLUS('+', (x, y) -> x + y),
    MINUS('-', (x, y) -> x - y),
    TIMES('*', (x, y) -> x * y),
    DIVIDE('/', (x, y) -> x / y);

    Calculate cal; // Calculate 인터페이스 가져오기
    private char mark;

    OperatorType(char mark, Calculate cal) {
        this.mark = mark;
        this.cal = cal;
    }

    int apply(int num1, int num2) {
        return cal.calculate(num1, num2);
    }

    public static OperatorType findMark(char operator) {
        return Arrays.stream(OperatorType.values())
                .filter(val -> val.mark == operator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}