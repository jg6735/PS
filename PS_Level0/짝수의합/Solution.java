package PS_Level0.짝수의합;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int number = 1;
        while (number <= n) {
            if (number % 2 == 0) {
                answer += number;
            }

            number++;
        }

        return answer;
    }
}
