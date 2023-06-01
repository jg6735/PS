package PS_Level0.피자나눠먹기2;

public class Solution {
    public int solution(int n) {
        int answer = 1;
        while (true) {
            if ((6 * answer) % n == 0) {
                break;
            }

            answer++;
        }

        return answer;
    }
}
