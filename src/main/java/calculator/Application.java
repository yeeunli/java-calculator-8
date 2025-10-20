package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력
        String originalStr = inputString();

        // 2. 구분자 추출
        ParsedResult result = parseInput(originalStr);

        // 3. 숫자 추출
        extractNum(result.data(), result.delimiter());

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
     * 구분자를 기준으로 숫자를 추출합니다.
     * @param str 입력받은 문자열
     */
    public static void extractNum(String str, String delimiter) {

        // 구분자(쉼표, 콜론) 기준으로 나눈다
        String[] strArr = str.split(delimiter);

        // 숫자 하나씩 배열에 담는다
        List<Integer> numList = new ArrayList<>();

        for (String i : strArr) {
            int num = Integer.parseInt(i.trim());
            numList.add(num);
        }
    }

    record ParsedResult(String delimiter, String data) {}

    /**
     * 원본 문자열에서 문자열과 구분자를 추출합니다.
     * @param originalStr
     * @return
     */
    public static ParsedResult parseInput(String originalStr) {

        // 디폴트 값으로 기본 구분자를 반환한다
        String delimiter = "[,\\:]";
        String data = originalStr;

        // 커스텀 구분자를 조건으로 추출한다
        if (originalStr.startsWith("//") && originalStr.contains("\\n")) {
            int position = originalStr.indexOf("\\n");
            delimiter = originalStr.substring(2, position);
            data = originalStr.substring(position + 2);
        }

        return new ParsedResult(delimiter, data);
    }
}