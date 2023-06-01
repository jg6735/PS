package PS_Level1.기사단원의무기;

// https://school.programmers.co.kr/learn/courses/30/lessons/136798
public class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;

        for (int i = 2; i <= number; i ++) {
            answer += getDivisorCount(i, limit, power);
        }

        return answer;
    }

    private static int getDivisorCount(int number, int limit, int power) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }

            if (count > limit) {
                return power;
            }
        }

        return count;
    }
}
