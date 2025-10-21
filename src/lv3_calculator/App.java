package lv3_calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

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
                    scanner.nextLine();
                }
            }

            while(true) {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                mark = scanner.next().charAt(0);
                if (mark == '+'|| mark == '-'|| mark == '*') break;
                else if (mark == '/') {
                    System.out.println("※ 주의: 나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                    break;
                } else System.out.println("잘못된 기호입니다. +, -, *, / 4가지 기호 중 하나를 입력해 주세요.");
            }
            OperatorType operatorType = OperatorType.findMark(mark);

            while(true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    num2 = scanner.nextInt();
                    if (num2 >= 0) break;
                    else if (num2 < 0) System.out.println("잘못된 숫자입니다. 양의 정수(0 포함)를 입력해주세요.");
                } catch  (InputMismatchException e) {
                    System.out.println("잘못된 숫자입니다. 양의 정수(0 포함)를 입력해주세요.");
                    scanner.nextLine();
                }
            }

            ArithmeticCalculator calculator = new ArithmeticCalculator();
            int result = 0;
            try {
                result = calculator.arithmeticCalculator(num1, num2, operatorType);
                if ((mark == '/' ) && num1 % num2 > 0) System.out.println("정수형 계산기이기에 소수점 아래는 버려집니다.");
            } catch (ArithmeticException e) {
                System.out.println("분모 0으로 나눗셈 연산을 진행할 수 없습니다.");
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
            System.out.println("계산 결과: " + result);

            calculator.setResult(result);
            System.out.println("현재까지 진행된 계산 결과: " + calculator.getResult());

            String stringResult = num1 + " " + mark + " " + num2 + " = " + result;
            calculator.setStringResult(stringResult);

            scanner.nextLine();
            String check;
            while(true) {
                System.out.println("더 계산하시겠습니까?");
                System.out.println("(exit: 종료 / show: 모든 계산 결과 확인 / show -a: 수식과 결과 함께 확인 / research: 기준값 이상의 결과만 확인) / remove: 원하는 결과 삭제 / 그 외: 새로운 계산 시작");
                check = scanner.nextLine();
                if (check.equalsIgnoreCase("show")) {
                    System.out.println("현재까지 진행된 계산 결과: " + calculator.getResult());
                } else if (check.equalsIgnoreCase("show -a")) {
                    System.out.println("현재까지 진행된 계산: " + calculator.getStringResults());
                } else if (check.equalsIgnoreCase("research")) {
                    System.out.println("기준값을 입력해주세요: ");
                    int condition = scanner.nextInt();
                    calculator.conditionalResearch(condition);
                    System.out.println("기준값 이상인 계산 결과: " + calculator.conditionalResearch(condition));
                    scanner.nextLine();
                } else if (check.equalsIgnoreCase("remove")) {
                    System.out.println("삭제하려는 결과값을 입력해주세요(중복된 결과값일 경우, 마지막 값이 삭제됩니다): ");
                    int remove = scanner.nextInt();
                    int removeindex = calculator.getResult().lastIndexOf(remove);
                    try {
                        calculator.removeResult(removeindex);
                        System.out.println("결과: " + calculator.getResult());
                        scanner.nextLine();
                    }  catch (IndexOutOfBoundsException e) {
                        System.out.println("해당 결과값이 존재하지 않습니다.");
                        scanner.nextLine();
                    }
                } else {
                    break;
                }
            }

            String exit = check;
            if (exit.equals("exit")) {
                break;
            } else {
                System.out.println("새로운 계산을 시작합니다.");
            }
        }
    }
}