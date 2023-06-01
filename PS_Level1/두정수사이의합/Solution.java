package PS_Level1.두정수사이의합;

// https://school.programmers.co.kr/learn/courses/30/lessons/12912
public class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        if (a == b) {
            answer = a;
        }

        return answer;
    }
}
