package PS_Level1.약수의개수와덧셈;

// https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = getDivisorCount(i);

            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    private static int getDivisorCount(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        return count;
    }
}
