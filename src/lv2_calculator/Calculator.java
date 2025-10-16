package lv2_calculator;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Integer> results = new ArrayList<Integer>();

    public int Calculate(int num1, char mark, int num2){
        int result = 0;
        result = switch(mark){
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
        return result;
    }
}