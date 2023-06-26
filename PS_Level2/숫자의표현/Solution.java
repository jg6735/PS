package PS_Level2.숫자의표현;

// https://school.programmers.co.kr/learn/courses/30/lessons/12924
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            int sum = 0;
            int j = i;

            while (sum < n) {
                sum += ++j;

                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}