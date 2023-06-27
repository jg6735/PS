package PS_Level2.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(i);
        }

        int day = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int expiration = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);

            if (expiration > day) {
                if (day != 0) {
                    result.add(count);
                    count = 0;
                }

                day = expiration;
            }

            count++;
        }

        result.add(count);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}