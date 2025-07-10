package org.example.lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private final List<String> resultList;

    public ArithmeticCalculator() {
        resultList = new ArrayList<>();
    }

    // 계산 후 리스트에 추가
    public String calculateAdd(T num1, T num2, OperatorType operator) {
        String result;

        try {
            double calcResult = CalculatorUtil.calculate(num1, num2, operator);
            result = String.valueOf(calcResult);
        } catch (ArithmeticException e) {
            result = "undefined"; // 근데 여기가 Infinity로 채워짐
        } catch (IllegalArgumentException e) {
            result = "잘못된 연산자입니다.";
        }

        resultList.add(result);
        return result;
    }

    // 리스트 가져오기
    public List<String> getResultList() {
        return resultList;
    }

    // 리스트 수정하기
    public void updateResultList(int index, T updateResult) {
        resultList.set(index, String.valueOf(updateResult));
        System.out.println("값이 수정되었습니다.\n새로운 값: " + resultList);
    }

    // 리스트의 제일 먼저 들어온 값 삭제하기
    public void removeFirstResult() {
        resultList.remove(0);
        System.out.println("첫 번째 값이 삭제되었습니다.\n새로운 값: " + resultList);
    }
}

