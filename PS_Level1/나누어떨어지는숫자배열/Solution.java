package PS_Level1.나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12910
public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }

        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }

            Arrays.sort(answer);
        }

        return answer;
    }
}
