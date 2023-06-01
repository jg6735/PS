package PS_Level1.햄버거만들기;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/133502
public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int num : ingredient) {
            stack.push(num);

            if (stack.size() < 4) {
                continue;
            }

            if (stack.get(stack.size() - 1) == 1
                    && stack.get(stack.size() - 2) == 3
                    && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 4) == 1
            ) {
                for (int i = 0; i < 4; i++) {
                    stack.pop();
                }

                answer++;
            }
        }

        return answer;
    }
}
