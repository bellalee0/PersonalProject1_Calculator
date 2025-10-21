package lv3_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Number> results = new ArrayList<>();
    private List<String> stringResults = new ArrayList<>();

    public <T extends Number, S extends Number> Number arithmeticCalculator(T num1, S num2, OperatorType operator) {
        return operator.apply(num1, num2);
    }

    List<Number> getResult() { return results; }
    void setResult(Number result) { results.add(result); }

    List<String> getStringResults() { return stringResults; }
    void setStringResult(String stringResult) { stringResults.add(stringResult); }

    void removeResult(Number index) { results.remove(index); }

    List<Number> conditionalResearch(Number condition) {
        return results.stream().filter(n -> n.doubleValue() >= condition.doubleValue()).collect(Collectors.toList());
    }
}