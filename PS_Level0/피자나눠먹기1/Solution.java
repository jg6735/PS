package PS_Level0.피자나눠먹기1;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        if (n % 7 == 0) {
            answer = n / 7;
        } else {
            answer = n / 7 + 1;
        }

        return answer;
    }
}
