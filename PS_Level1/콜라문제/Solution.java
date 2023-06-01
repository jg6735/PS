package PS_Level1.콜라문제;

// https://school.programmers.co.kr/learn/courses/30/lessons/132267
public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int bonus = (n / a) * b;
            answer += bonus;
            n = n % a + bonus;
        }

        return answer;
    }
}
