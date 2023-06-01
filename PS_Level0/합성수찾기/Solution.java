package PS_Level0.합성수찾기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 4; i <= n; i++) {
            int num = i;
            int count = 0;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    count++;
                }

                if (count == 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
