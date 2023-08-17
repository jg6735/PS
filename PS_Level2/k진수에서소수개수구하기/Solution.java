package PS_Level2.k진수에서소수개수구하기;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335
class Solution {
    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        List<String> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Long.toString(n, k), "0");
        while (st.hasMoreTokens()) {
            numbers.add(st.nextToken());
        }

        for (String number : numbers) {
            if (isPrime(Long.parseLong(number))) {
                answer++;
            }
        }

        return answer;
    }
}