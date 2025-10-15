package lv1_calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1;
        int num2;
        char mark;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = scanner.nextInt();

            if (num1 >= 0) {
                break;
            } else {
                System.out.println("잘못된 숫자입니다. 양의 정수를 입력해주세요.");
            }
        }

        while (true) {
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = scanner.nextInt();

            if (num2 >= 0) {
                break;
            } else {
                System.out.println("잘못된 숫자입니다. 양의 정수를 입력해주세요.");
            }
        }

        while (true) {
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char getmark = scanner.next().charAt(0);

            if (getmark == '+' || getmark == '-' || getmark == '*' || getmark == '/') {
                mark = getmark;
                break;
            } else if (getmark == 'x' || getmark == 'X') {
                mark = '*';
                break;
            } else if (getmark == '%') {
                mark = '/';
                break;
            } else {
                System.out.println("잘못된 기호입니다. 사칙연산 기호(+, -, *, /) 중 하나를 입력해주세요.");
            }
        }

        // if문으로 작성
//        int result = 0;
//        if (mark == '+') {
//            result = num1 + num2;
//            System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
//        } else if (mark == '-') {
//            result = num1 - num2;
//            System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
//        } else if (mark == '*') {
//            result = num1 * num2;
//            System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
//        }  else if (mark == '/') {
//            if (num2 == 0) {
//                System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다");
//            } else if (num2 > num1) {
//                double d_num1 = num1;
//                double d_num2 = num2;
//                double result2 = d_num1 / d_num2;
//                System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result2);
//            } else {
//                result = num1 / num2;
//                System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
//            }
//        }


        // switch문으로 작성
        int result = 0;
        switch (mark) {
            case '+' -> {
                result = num1 + num2;
                System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
            }
            case '-' -> {
                result = num1 - num2;
                System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
            }
            case '*' -> {
                result = num1 * num2;
                System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
            }
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다");
                } else if (num2 > num1) {
                    double d_num1 = num1;
                    double d_num2 = num2;
                    double result2 = d_num1 / d_num2;
                    System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result2);
                } else {
                    result = num1 / num2;
                    System.out.println("계산 결과: " + num1 + " " + mark + " " + num2 + " = " + result);
                }
            }
            default -> result = 0;
        };

    }
}