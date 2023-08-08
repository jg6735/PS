package PS_Level2.예상대진표;

// https://school.programmers.co.kr/learn/courses/30/lessons/12985
class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while (Math.abs(a - b) != 1 || Math.max(a, b) % 2 != 0) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = a / 2 + 1;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else {
                b = b / 2 + 1;
            }

            answer++;
        }

        return answer;
    }
}