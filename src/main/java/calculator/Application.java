package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력
        String originalStr = inputString();

        // 2. 구분자 추출
        ParsedResult result = parseInput(originalStr);

        // 3. 숫자 추출
        List<Integer> numList = extractNum(result.data(), result.delimiter());

        // 4. 숫자의 합 반환
        sumNum(numList);

    }

    /**
     * 문자열을 입력받습니다.
     * @return 입력받은 문자열
     */
    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return Console.readLine();
    }

    /**
     * 구분자를 기준으로 숫자를 추출합니다.
     * @param str 입력받은 문자열
     */
    public static List<Integer> extractNum(String str, String delimiter) {

        // 빈 문자열일 경우 빈 리스트 반환
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }

        // 구분자(쉼표, 콜론) 기준으로 나눈다
        String[] strArr = str.split(delimiter);

        // 숫자 하나씩 배열에 담는다
        List<Integer> numList = new ArrayList<>();

        for (String i : strArr) {
            try {
                int num = Integer.parseInt(i.trim());

                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }

                numList.add(num);
            }  catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }

        }

        return numList;
    }

    record ParsedResult(String delimiter, String data) {}

    /**
     * 원본 문자열에서 문자열과 구분자를 추출합니다.
     * @param originalStr 입력 받은 문자열
     * @return 숫자로만 구성된 리스트와 구분자
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

    /**
     * 추출한 숫자들의 합을 출력합니다.
     * @param numList 순수 숫자로만 구성된 배열
     */
    public static void sumNum(List<Integer> numList) {

        int sum = 0;

        for (Integer num : numList) {
            sum += num;
        }

        System.out.println("결과 : " + sum);
    }
}