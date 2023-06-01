package PS_Level0.배열의평균값;

public class Solution {
    public double solution(int[] numbers) {
        double answer = 0;

        for (int number : numbers) {
            answer += number;
        }

        return answer / numbers.length;
    }
}
