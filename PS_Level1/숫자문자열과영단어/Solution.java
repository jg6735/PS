package PS_Level1.숫자문자열과영단어;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Solution {
    private static final String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        for (int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
