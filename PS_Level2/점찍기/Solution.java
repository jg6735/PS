package PS_Level2.점찍기;

// https://school.programmers.co.kr/learn/courses/30/lessons/140107
class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            double y = Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += Math.ceil(y / k) + (y % k == 0 ? 1 : 0);
        }

        return answer;
    }
}