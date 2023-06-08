package PS_Level2.괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder builder = new StringBuilder(s);
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(builder.toString(), deque)) {
                answer++;
            }

            builder.append(builder.charAt(0)).deleteCharAt(0);
        }

        return answer;
    }

    private static boolean isCorrect(String s, Deque<Character> deque) {
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') {
                    return false;
                }

                deque.push(c);
                continue;
            }

            if (c == ')' && deque.peek() == '(') {
                deque.pop();
            } else if (c == '}' && deque.peek() == '{') {
                deque.pop();
            } else if (c == ']' && deque.peek() == '[') {
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        return deque.isEmpty();
    }
}