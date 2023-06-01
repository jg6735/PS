package PS_Level0.구슬을나누는경우의수;

import java.math.BigInteger;

public class Solution {
    public int solution(int balls, int share) {
        if (balls == share) {
            return 1;
        }

        return getFactorial(balls).divide(getFactorial(balls - share).multiply(getFactorial(share))).intValue();
    }

    private static BigInteger getFactorial(int n) {
        if (n == 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
    }
}
