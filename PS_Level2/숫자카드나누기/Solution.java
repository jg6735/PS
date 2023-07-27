package PS_Level2.숫자카드나누기;

// https://school.programmers.co.kr/learn/courses/30/lessons/135807
class Solution {
    private static boolean isDivided(int[] array, int gcd) {
        for (int num : array) {
            if (num % gcd == 0) {
                return false;
            }
        }

        return true;
    }

    private static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGcd(b, a % b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);
            gcdB = getGcd(gcdB, arrayB[i]);
        }

        if (isDivided(arrayB, gcdA) && (answer < gcdA)) {
            answer = gcdA;
        }

        if (isDivided(arrayA, gcdB) && (answer < gcdB)) {
            answer = gcdB;
        }

        return answer;
    }
}