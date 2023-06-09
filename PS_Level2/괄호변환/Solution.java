package PS_Level2.괄호변환;

import java.util.ArrayDeque;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/60058 2020 KAKAO BLIND RECRUITMENT
class Solution {
    public String solution(String p) {
        return toCorrectString(p);
    }

    private static String toCorrectString(String s) {
        if (s.length() == 0) {
            return "";
        }

        int index = getBalancedString(s);
        String u = s.substring(0, index);
        String v = s.substring(index);

        if (isCorrectString(u)) {
            return u + toCorrectString(v);
        }

        return "(" + toCorrectString(v) + ")" + reverse(u.substring(1, u.length() - 1));
    }

    private static boolean isCorrectString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) {
                if (c == ')') {
                    return false;
                }

                deque.push(c);
                continue;
            }

            if (c == ')' && deque.peek() == '(') {
                deque.pop();
            } else {
                deque.push(c);
            }
        }

        return deque.isEmpty();
    }

    private static int getBalancedString(String s) {
        int open = 0;
        int close = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                index = i + 1;
                break;
            }
        }

        return index;
    }

    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                builder.append(')');
            } else {
                builder.append('(');
            }
        }

        return builder.toString();
    }
}