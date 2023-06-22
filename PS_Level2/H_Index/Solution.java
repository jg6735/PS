package PS_Level2.H_Index;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = citations.length; i >= 0; i--) {
            if (citations[citations.length - i] >= i) {
                return i;
            }
        }

        return answer;
    }
}