package lv2_calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> results = new ArrayList<String>();

    public int Calculate(int num1, char mark, int num2){
        int result;
        result = switch(mark){
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*', 'x', 'X' -> num1 * num2;
            case '/', '%' ->  num1 / num2;
            default -> 0;
        };
        return result;
    }

    ArrayList<String> getResult() {
        return results;
    }

    void setResult(String result) {
        results.add(result);
    }

    void removeResult() {
        results.remove(0);
    }
}