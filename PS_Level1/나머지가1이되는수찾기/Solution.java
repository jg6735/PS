package PS_Level1.나머지가1이되는수찾기;

// https://school.programmers.co.kr/learn/courses/30/lessons/87389
public class Solution {
    public int solution(int n) {
        int answer = 2;

        while (n % answer != 1) {
            answer++;
        }

        return answer;
    }
}