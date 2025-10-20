package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력
        String str = inputString();

        // 2. 숫자 추출
        extractNum(str);

    }

    /**
     * 문자열을 입력받습니다.
     */
    public static String inputString() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("입력 중 오류가 발생했습니다. : " + e.getMessage());
        }

        return str;
    }

    /**
     * 기본 구분자를 기준으로 숫자를 추출합니다.
     * @param str 입력받은 문자열
     */
    public  static void extractNum(String str) {

        // 구분자(쉼표, 콜론) 기준으로 나눈다
        String[] strArr = str.split("[,\\:]");

        // 숫자 하나씩 배열에 담는다
        List<Integer> numList = new ArrayList<>();

        for (String i : strArr) {
            int num = Integer.parseInt(i.trim());
            numList.add(num);
        }
    }
}