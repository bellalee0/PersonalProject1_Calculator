package lv3_calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private List<String> results = new ArrayList<String>();
    OperatorType plus = OperatorType.PLUS;
    OperatorType minus = OperatorType.MINUS;
    OperatorType times = OperatorType.TIMES;
    OperatorType divide = OperatorType.DIVIDE;

    public int Calculate(int num1, char mark, int num2) {
        int result = 0;
        switch (mark) {
            case '+' -> result = plus.execute(num1, num2);
            case '-' -> result = minus.execute(num1, num2);
            case '*', 'x', 'X' -> result = times.execute(num1, num2);
            case '/', '%' -> result = divide.execute(num1, num2);
            default -> System.out.println("Invalid mark");
        }
        return result;
    }

    List<String> getResult() {
        return results;
    }

    void setResult(String result) {
        results.add(result);
    }

    void removeResult() {
        results.remove(0);
    }
}