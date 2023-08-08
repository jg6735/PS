package PS_Level2.캐시;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/17680
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            // cache hit
            if (queue.remove(city)) {
                answer++;
            // cache miss
            } else {
                answer += 5;
                if (queue.size() == cacheSize) {
                    queue.poll();
                }
            }

            queue.add(city);
        }

        return answer;
    }
}