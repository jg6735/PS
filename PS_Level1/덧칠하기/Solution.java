package PS_Level1.덧칠하기;

// https://school.programmers.co.kr/learn/courses/30/lessons/161989
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;

        for (int num : section) {
            if (num > max) {
                answer++;
                max = num + m - 1;
            }
        }

        return answer;
    }
}