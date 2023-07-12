package PS_Level2.숫자변환하기;

import static java.lang.Integer.MAX_VALUE;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        for (int i = x + 1; i <= y; i++) {
            int a = MAX_VALUE;
            int b = MAX_VALUE;
            int c = MAX_VALUE;

            if (i / 2 > 0 && i % 2 == 0 && i / 2 >= x) {
                a = dp[i / 2];
            }

            if (i / 3 > 0 && i % 3 == 0 && i / 3 >= x) {
                b = dp[i / 3];
            }

            if ((i - n) >= x) {
                c = dp[i - n];
            }

            int d = Math.min(Math.min(a, b), c);
            dp[i] = (d < MAX_VALUE) ? d + 1 : MAX_VALUE;
        }

        return dp[y] < MAX_VALUE ? dp[y] : -1;
    }
}