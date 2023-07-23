package PS_Level2.연속부분수열합의개수;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/131701
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int start = 1;
        while (start <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int num = 0;
                for (int j = i; j < i + start; j++) {
                    num += elements[j % elements.length];
                }

                set.add(num);
            }

            start++;
        }

        return set.size();
    }
}