package PS_Level2.롤케이크자르기;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        for (int top : topping) {
            mapB.put(top, mapB.getOrDefault(top, 0) + 1);
        }

        for (int top : topping) {
            mapA.put(top, mapA.getOrDefault(top, 0) + 1);

            int count = mapB.getOrDefault(top, 0);
            if (count > 1) {
                mapB.put(top, mapB.get(top) - 1);
            } else {
                mapB.remove(top);
            }

            if (mapA.size() == mapB.size()) {
                answer++;
            }
        }

        return answer;
    }
}