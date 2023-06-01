package PS_Level0.분수의덧셈;

public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int beforeDenom = getLcm(denom1, denom2);
        int beforeNumer = numer1 * (beforeDenom / denom1) + numer2 * (beforeDenom / denom2);
        int gcd = getGcd(beforeNumer, beforeDenom);

        return new int[]{beforeNumer / gcd, beforeDenom / gcd};
    }

    private static int getGcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        return getGcd(num2, num1 % num2);
    }

    private static int getLcm(int num1, int num2) {
        return num1 * num2 / getGcd(num1, num2);
    }
}
