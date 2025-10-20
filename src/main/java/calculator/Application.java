package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력
        inputString();

    }

    /**
     * 문자열을 입력받습니다.
     */
    public static void inputString() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("입력 중 오류가 발생했습니다. : " + e.getMessage());
        }
    }
}