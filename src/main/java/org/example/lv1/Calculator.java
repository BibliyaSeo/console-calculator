package org.example.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1) 양의 정수(0 포함)를 2개 입력 받기
            int num1 = getPositiveInt(scanner, "첫 번째");
            int num2 = getPositiveInt(scanner, "두 번째");

            // 2) 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
            char operator;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요(+,-,*,/): ");
                String input = scanner.next();


                if (input.length() == 1) {  // ++, -* 등 이상한 문자 입력 방지
                    operator = input.charAt(0);
                    if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                        break;
                    }
                }

                System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
            }
            // 3) 입력받은 양의 정수 2개와 사칙연산 이용하여 연산 후 결과 값 출력
            String result;

            switch (operator) {
                case '+':
                    result = String.valueOf(num1 + num2);
                    break;
                case '-':
                    result = String.valueOf(num1 - num2);
                    break;
                case '*':
                    result = String.valueOf(num1 * num2);
                    break;
                case '/':
                    if (num2 == 0) {
                        result = "undefined";
                    } else {
                        result = String.valueOf(num1 / num2);
                    }
                    break;
                default:
                    result = "프로그램 내부 오류! 예상치 못한 오류입니다.";
            }
            System.out.println("결과: " + result);
            System.out.println();
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exit = scanner.next();

            if (exit.equals("exit")) {
                System.out.println("계산기 프로그램을 종료합니다.");
                break;
            }
            System.out.println();
        }
        scanner.close();
    }

    // 공통으로 사용하는 숫자 입력 부분 분리
    public static int getPositiveInt(Scanner scanner, String label) {
        int number;

        while (true) {
            System.out.print(label + " 숫자를 입력해 주세요: ");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("음수는 입력할 수 없습니다.");
                }
            } else {
                System.out.println("정수를 입력해 주세요.");
                scanner.next();
            }
        }
    }
}