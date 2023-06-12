package PS_Level2.짝지어제거하기;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973
class Solution {
    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (deque.isEmpty()) {
                deque.push(s.charAt(i));
            } else if (deque.peek() == s.charAt(i)) {
                deque.pop();
            } else {
                deque.push(s.charAt(i));
            }
        }

        if (deque.isEmpty()) {
            return 1;
        }

        return 0;
    }
}