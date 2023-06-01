package PS_Level1.과일장수;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/135808
public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int count = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            count++;

            if (count == m) {
                answer += score[i] * m;
                count = 0;
            }
        }

        return answer;
    }
}