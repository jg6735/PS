package PS_Level0.제곱수판별하기;

public class Solution {
    public int solution(int n) {
        int answer = 2;

        for (int i = 1; i <= 1000; i++) {
            if (i * i == n) {
                answer = 1;
                break;
            }
        }

        return answer;

        /*
        if (n % Math.sqrt(n) == 0) {
            return 1;
        } else {
            return 2;
        }
         */
    }
}
