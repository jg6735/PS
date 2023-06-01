package PS_Level1.같은숫자는싫어;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[index++] = stack.pop();
        }

        return answer;
    }
}
