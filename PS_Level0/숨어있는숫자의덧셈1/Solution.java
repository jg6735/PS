package PS_Level0.숨어있는숫자의덧셈1;

public class Solution {
    public int solution(String my_string) {
        int answer = 0;

        for (int i = 0; i < my_string.length(); i++) {
            int number = my_string.charAt(i) - '0';
            if (number >= 1 && number <= 9) {
                answer += number;
            }
        }

        return answer;
    }
}
