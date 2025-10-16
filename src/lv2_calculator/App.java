package lv2_calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char mark = scanner.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            int result = calculator.Calculate(num1, mark, num2);
            String printing_result = num1 + " " + mark + " " + num2 + " = " + result;
            System.out.println("계산 결과: " + printing_result);

            calculator.setResult(printing_result);

            if (calculator.getResult().size() > 3) {
                calculator.removeResult();
                System.out.println("현재까지 진행된 계산: " + calculator.getResult());
            } else {
                System.out.println("현재까지 진행된 계산: " + calculator.getResult());
            }

            scanner.nextLine();
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료): ");
            String exit = scanner.nextLine();

            if (!exit.equals("exit")) {
                System.out.println("새로운 계산을 시작합니다.");
            } else {
                break;
            }
        }
    }
}