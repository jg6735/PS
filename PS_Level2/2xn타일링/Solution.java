package PS_Level2._2xn타일링;

// https://school.programmers.co.kr/learn/courses/30/lessons/12900
class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
        }

        return dp[n];
    }
}