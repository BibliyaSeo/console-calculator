package org.example.lv3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
        ArithmeticCalculator<Double> calc = new ArithmeticCalculator<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1) 양의 정수(0 포함)를 2개 입력 받기
            Double num1 = getPositiveDouble(scanner, "첫 번째");
            Double num2 = getPositiveDouble(scanner, "두 번째");

            // 2) 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
            OperatorType operator;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요(+,-,*,/): ");
                String input = scanner.next();

                if (input.length() == 1) {  // ++, -* 등 이상한 문자 입력 방지
                    char op = input.charAt(0);
                    try {
                        operator = OperatorType.matchOperator(op);  // enum 매핑 시도
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("지원하지 않는 연산자입니다. 다시 입력하세요.");
            }

            // 계산
            String result = calc.calculateAdd(num1, num2, operator);

            // 리스트 불러오기
            List<String> resultList = calc.getResultList();

            System.out.println("결과: " + result);
            System.out.println("지금까지의 결과들: " + resultList);

            System.out.println();

            // 한번에 기능 처리...
            System.out.print("결과를 수정하시고 싶으시면 update,\n가장 먼저 저장된 값을 삭제하고 싶다면 remove,\n계산기 프로그램을 종료하고 싶으시면 exit,\n계속 계산을 진행하시려면 아무 글자나 입력해 주세요: ");
            String answer = scanner.next();

            // answer에 따른 분기 처리
            switch (answer) {
                // 수정
                case "update":
                    while (true) {
                        System.out.print("현재 입력할 수 있는 값은 0~" + (resultList.size() - 1) + "까의 정수입니다. 수정할 값의 인덱스를 입력해 주세요: ");
                        int index = 0;
                        if (scanner.hasNextInt()) {
                            index = scanner.nextInt();
                            if (index >= 0 && index < resultList.size()) {
                                // 인덱스값을 길이보다 큰거를 입력하면 오류 // JAVA는 -1로 마지막거 찾아주지 않아서 음수 제외
                                // 값 수정
                                Double updateResult = getPositiveDouble(scanner, "변경을 원하시는");
                                calc.updateResultList(index, updateResult);
                                break;
                            }
                        } else {
                            System.out.print("정수를 입력해 주세요.");
                            scanner.next();
                        }
                    }
                    break;

                // 삭제
                case "remove":
                    calc.removeFirstResult();
                    break;

                // 종료
                case "exit":
                    System.out.println("계산기 프로그램을 종료합니다.");
                    scanner.close();
                    return;

                // 아무거나 입력했을 때
                default:
                    break;
            }
            System.out.println();
        }
    }

    // 공통으로 사용하는 숫자 입력 부분 분리
    public static Double getPositiveDouble(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + " 숫자를 입력해 주세요: ");
            if (scanner.hasNextDouble()) { // 스트링으로 들어왔을 경우 체크
                return scanner.nextDouble();
            } else {
                System.out.println("실수나 정수를 입력해 주세요.");
                scanner.next();
            }
        }
    }
}