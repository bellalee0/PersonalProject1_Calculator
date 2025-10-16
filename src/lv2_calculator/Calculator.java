package lv2_calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> results = new ArrayList<String>();

    public int Calculate(int num1, char mark, int num2){
        int result = 0;
        switch(mark){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*', 'x', 'X' -> result = num1 * num2;
            case '/', '%' ->  result = num1 / num2;
//            num2가 숫자인 경우, num2 < num1인 경우 처리 과정 추가 예정
//            {
//                if (num2 == 0) {
//                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
//                } else if (num2 > num1) {
//                    double d_num1 = num1;
//                    double d_num2 = num2;
//                    result = num1 / num2;
//                } else {
//                    result = num1 / num2;
//                }
//            }
            default -> result = 0;
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