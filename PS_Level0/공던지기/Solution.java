package PS_Level0.공던지기;

public class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;

        for (int i = 0; i < k - 1; i++) {
            answer = (answer + 2) % numbers.length;
        }

        return numbers[answer];
    }
}
