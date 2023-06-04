package PS_Level2.올바른괄호;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if (arr[0] == ')') {
            return false;
        }

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}