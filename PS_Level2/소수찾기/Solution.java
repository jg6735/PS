package PS_Level2.소수찾기;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
class Solution {
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void getPrime(int number, int[] numbers, boolean[] selected, Set<Integer> primes) {
        if (isPrime(number)) {
            primes.add(number);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (selected[i]) {
                continue;
            }

            int next = number * 10 + numbers[i];
            selected[i] = true;
            getPrime(next, numbers, selected, primes);
            selected[i] = false;
        }
    }

    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        int[] nums = new int[numbers.length()];

        int idx = 0;
        for (char c : numbers.toCharArray()) {
            nums[idx++] = c - '0';
        }

        getPrime(0, nums, new boolean[numbers.length()], primes);
        return primes.size();
    }
}