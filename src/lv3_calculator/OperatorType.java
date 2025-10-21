package lv3_calculator;

public enum OperatorType {
    // 상수 메서드
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    // 속성?
    private Calculate cal; // 람다식을 생성할 필드
    private String mark;

    // 생성자
    OperatorType(String mark, Calculate cal) {
        this.mark = mark;
        this.cal = cal;
    }

    // 계산 메서드
    public int execute(int x, int y) {
        return cal.calculate(x, y);
    }
}