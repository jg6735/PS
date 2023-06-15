package PS_Level2.영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/12981
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();

        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char prev = words[i - 1].charAt(words[i - 1].length() - 1);
            char cur = words[i].charAt(0);
            if (set.contains(words[i]) || prev != cur) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }

            set.add(words[i]);
        }

        return new int[]{0, 0};
    }
}