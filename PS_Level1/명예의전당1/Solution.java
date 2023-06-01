package PS_Level1.명예의전당1;

import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/138477
public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }

            answer[i] = queue.peek();
        }

        return answer;
    }
}
