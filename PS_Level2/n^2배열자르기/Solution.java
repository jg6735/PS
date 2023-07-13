package PS_Level2.n제곱배열자르기;

// https://school.programmers.co.kr/learn/courses/30/lessons/87390
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) Math.max(left % n + 1, left / n + 1);
            left++;
        }

        return answer;
    }
}