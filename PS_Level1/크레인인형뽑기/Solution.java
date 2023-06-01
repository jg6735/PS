package PS_Level1.크레인인형뽑기;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061
public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int location = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                int dollNumber = board[j][location];

                if (dollNumber == 0) {
                    continue;
                }

                if (!stack.isEmpty()) {
                    if (stack.peek() == dollNumber) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(dollNumber);
                    }
                } else {
                    stack.push(dollNumber);
                }

                board[j][location] = 0;
                break;
            }
        }

        return answer;
    }
}