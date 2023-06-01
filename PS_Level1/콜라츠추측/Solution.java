package PS_Level1.콜라츠추측;

public class Solution {
    public int solution(int num) {
        int answer = 0;

        if (num == 1) {
            return 0;
        }

        long n = num;
        while (n != 1) {
            answer++;
            if (answer == 500) {
                return -1;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }

        return answer;
    }
}
