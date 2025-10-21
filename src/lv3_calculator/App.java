package lv3_calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int num1;
            char mark;
            int num2;

            while(true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                try {
                    num1 = scanner.nextInt();
                    if (num1 >= 0) break;
                    if (num1 < 0) System.out.println("잘못된 숫자입니다. 양의 정수(0 포함)를 입력해주세요.");
                } catch  (InputMismatchException e) {
                    System.out.println("잘못된 숫자입니다. 양의 정수(0 포함)를 입력해주세요.");
                    scanner.next();
                }
            }

            while(true) {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                mark = scanner.next().charAt(0);
                if (mark == '+'|| mark == '-'|| mark == '*'|| mark == 'x'|| mark == 'X') break;
                else if (mark == '/' || mark == '%') {
                    System.out.println("※ 주의: 나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    break;
                } else System.out.println("잘못된 기호입니다. +, -, *, / 4가지 기호 중 하나를 입력해 주세요.");
            }

            while(true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    num2 = scanner.nextInt();
                    if (num2 >= 0) break;
                    else if (num2 < 0) System.out.println("잘못된 숫자입니다. 양의 정수(0 포함)를 입력해주세요.");
                } catch  (InputMismatchException e) {
                    System.out.println("잘못된 숫자입니다. 양의 정수(0 포함)를 입력해주세요.");
                    scanner.next();
                }
            }

            int result = 0;
            try {
                result = calculator.Calculate(num1, mark, num2);
                if ((mark == '/' || mark == '%') && num1 % num2 > 0) System.out.println("정수형 계산기이기에 소수점 아래는 버려집니다.");
            } catch (ArithmeticException e) {
                System.out.println("분모 0으로 나눗셈 연산을 진행할 수 없습니다.");
            }
            System.out.println("계산 결과: " + result);

            calculator.setResult(result);
            System.out.println("현재까지 진행된 계산: " + calculator.getResult());

            scanner.nextLine();

            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료): ");
            String exit = scanner.nextLine();

            if (exit.equalsIgnoreCase("research")) {
                System.out.println("기준값을 입력해주세요: ");
                int condition = scanner.nextInt();
                calculator.conditionalResearch(condition);
                System.out.println("기준값 이상인 계산 결과: " + calculator.conditionalResearch(condition));
            }

            else if (!exit.equals("exit")) {
                System.out.println("새로운 계산을 시작합니다.");
            } else if(exit.equals("exit")) {
                break;
            }
        }
    }
}