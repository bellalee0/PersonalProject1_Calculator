package lv3_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Integer> results = new ArrayList<>();
    private List<String> stringResults = new ArrayList<>();
    OperatorType plus = OperatorType.PLUS;
    OperatorType minus = OperatorType.MINUS;
    OperatorType times = OperatorType.TIMES;
    OperatorType divide = OperatorType.DIVIDE;

    public int arithmeticCalculator(int num1, char mark, int num2) {
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

    List<Integer> getResult() { return results; }
    void setResult(int result) { results.add(result); }

    List<String> getStringResults() { return stringResults; }
    void setStringResult(String stringResult) { stringResults.add(stringResult); }

    void removeResult(int index) { results.remove(index); }

    List<Integer> conditionalResearch(int condition) {
        List<Integer> conditionalList = results.stream().filter(n -> n >= condition).collect(Collectors.toList());
        return conditionalList;
    }
}