package PS_Level2.뒤에있는큰수찾기;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/154539
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!deque.isEmpty()) {
                if (numbers[deque.peek()] >= numbers[i]) {
                    break;
                }

                answer[deque.pop()] = numbers[i];
            }

            deque.push(i);
        }

        while (!deque.isEmpty()) {
            answer[deque.pop()] = -1;
        }

        return answer;
    }
}