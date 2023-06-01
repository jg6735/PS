package PS_Level1.가장가까운같은글자;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] alphabets = new int['z' + 1];
        Arrays.fill(alphabets, -1);

        int index = 0;
        for (char c : s.toCharArray()) {
            if (alphabets[c] == -1) {
                alphabets[c] = index;
                answer[index++] = -1;
            } else {
                answer[index] = index - alphabets[c];
                alphabets[c] = index++;
            }
        }

        return answer;
    }
}