package PS_Level2.시소짝꿍;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996
class Solution {
    private static long getAnswer(int weight, Map<Double, Integer> map) {
        long sum = 0;

        double a = (double) weight / 2;
        double b = (double) (weight * 2) / 3;
        double c = (double) (weight * 3) / 4;

        if (map.containsKey((double) weight)) {
            sum += map.get((double) weight);
        }

        if (map.containsKey(a)) {
            sum += map.get(a);
        }

        if (map.containsKey(b)) {
            sum += map.get(b);
        }

        if (map.containsKey(c)) {
            sum += map.get(c);
        }

        map.put((double) weight, map.getOrDefault((double) weight, 0) + 1);
        return sum;
    }

    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();

        Arrays.sort(weights);
        for (int weight : weights) {
            answer += getAnswer(weight, map);
        }

        return answer;
    }
}