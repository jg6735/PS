package PS_Level1.없는숫자더하기;

// https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class Solution {
    public int solution(int[] numbers) {
        int answer = 45;

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}
