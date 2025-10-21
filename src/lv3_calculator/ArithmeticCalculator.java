package lv3_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Integer> results = new ArrayList<>();
    private List<String> stringResults = new ArrayList<>();

    public int arithmeticCalculator(int num1, int num2, OperatorType operator) {
        return operator.apply(num1, num2);
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