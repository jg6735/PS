package PS_Level0.저주의숫자3;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;

            while (answer % 3 == 0 || answer % 10 == 3 || answer / 10 == 3 || answer / 10 % 10 == 3) {
                answer++;
            }
        }

        return answer;
    }
}
