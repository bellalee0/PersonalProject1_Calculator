package lv3_calculator;

public enum OperatorType {
    // 상수 메서드
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    Calculate cal; // Calculate 인터페이스 가져오기
    private String mark;

    OperatorType(String mark, Calculate cal) {
        this.mark = mark;
        this.cal = cal;
    }

    public int execute(int x, int y) {
        return cal.calculate(x, y);
    }
}