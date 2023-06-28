package PS_Level2.주식가격;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[deque.peek()] > prices[i]) {
                int index = deque.poll();
                answer[index] = i - index;
            }

            deque.push(i);
        }

        while (!deque.isEmpty()) {
            int index = deque.poll();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }
}