package PS_Level2.숫자블록;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/12923
class Solution {
    private static List<Integer> list;
    private static int count;

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        int index = 0;
        for (int i = (int) begin; i <= end; i++) {
            if (isPrimeAndGetDivisor(i)) {
                answer[index++] = 1;
            } else {
                answer[index++] = count;
            }
        }

        return answer;
    }

    private static boolean isPrimeAndGetDivisor(int number) {
        if (number <= 1) {
            return false;
        }

        list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                list.add(i);

                if (number / i <= 10000000) {
                    count = number / i;
                    return false;
                }
            }
        }

        if (!list.isEmpty()) {
            count = list.get(list.size() - 1);
            return false;
        }

        return true;
    }
}