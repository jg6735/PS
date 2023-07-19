package PS_Level2.귤고르기;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        int sum = 0;
        for (int size : list) {
            answer++;
            sum += size;

            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}