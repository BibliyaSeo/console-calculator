package org.example.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private List<String> resultList;

    public Calculator() {
        resultList = new ArrayList<>();
    }

    public String calculate(int num1, int num2, char operator) {
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

        resultList.add(result);
        return result;
    }

    public List<String> getResultList() {
        return resultList;
    }

    public void updateResultList(int index, int updateResult) {
        resultList.set(index, String.valueOf(updateResult));
        System.out.println("값 수정이 완료되었습니다.\n새로운 값: " + resultList);
    }

    public void removeFirstResult() {
        resultList.remove(0);
        System.out.println("첫 번째 값 삭제가 완료되었습니다.\n새로운 값: " + resultList);
    }
}
