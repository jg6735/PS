package PS_Level1.소수찾기;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] prime = new int[n + 1];
        prime[0] = prime[1] = 0;

        for (int i = 2; i <= n; i++) {
            prime[i] = i;
        }

        for (int i = 2; i < n; i++) {
            if (prime[i] == 0) {
                continue;
            }

            for (int j = 2 * i; j <= n; j += i) {
                prime[j] = 0;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] != 0) {
                answer++;
            }
        }

        return answer;
    }
}
