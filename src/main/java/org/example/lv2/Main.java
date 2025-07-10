package org.example.lv2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
        Calculator calc = new Calculator();
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

            String result = calc.calculate(num1, num2, operator);
            List<String> resultList = calc.getResultList();

            System.out.println("결과: " + result);
            System.out.println("지금까지의 결과들: " + calc.getResultList());

            System.out.println();
            System.out.print("결과를 수정하시고 싶으시면 update,\n가장 먼저 저장된 값을 삭제하고 싶다면 remove,\n계산기 프로그램을 종료하고 싶으시면 exit,\n계속 계산을 진행하시려면 아무 글자나\n입력해 주세요: ");
            String answer = scanner.next();

            switch (answer) {
                case "update":
                    while (true) {
                        System.out.print("현재 입력할 수 있는 값은 0~" + (resultList.size() - 1) + "까의 정수입니다. 수정할 값의 인덱스를 입력해 주세요: ");
                        int index = 0;
                        if (scanner.hasNextInt()) {
                            index = scanner.nextInt();
                            if (index >= 0 && index < resultList.size()) {
                                // Todo: 인덱스값을 큰거를 입력하고 원하는 값을 입력하면 오류남
                                // 처음 입력한index의 값이 변하지 않고 그대로 들어가는 게 아닌지 확인 필요!
                                // 새로운 값을 적용하게 해야 함

                                // 값 수정
                                int updateResult = getPositiveInt(scanner, "변경을 원하시는");
                                calc.updateResultList(index, updateResult);
                                break;
                            }
                        } else {
                            System.out.print("정수를 입력해 주세요.");
                            scanner.next();
                        }
                    }
                    break;

                case "remove":
                    calc.removeFirstResult();
                    break;

                case "exit":
                    System.out.println("계산기 프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    break;
            }
            System.out.println();
        }
    }

    // 공통으로 사용하는 숫자 입력 부분 분리
    public static int getPositiveInt(Scanner scanner, String label) {
        int number;

        while (true) {
            System.out.print(label + " 숫자를 입력해 주세요: ");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (label.equals("원하시는")) {
                    return number;
                } else {
                    if (number >= 0) {
                        return number;
                    } else {
                        System.out.println("음수는 입력할 수 없습니다.");
                    }
                }
            } else {
                System.out.println("정수를 입력해 주세요.");
                scanner.next();
            }
        }
    }
}
