package PS_Level2.줄서는방법;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/12936
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        k--;
        int index = 0;
        while (n > 0) {
            factorial /= n--;
            int num = (int) (k / factorial);
            answer[index++] = list.get(num);
            list.remove(num);
            k %= factorial;
        }

        return answer;
    }
}