package PS_Level0.유한소수판별하기;

public class Solution {
    public int solution(int a, int b) {
        int n = b / getGCD(a, b);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return 2;
            }
        }

        return 1;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return getGCD(num2, num1 % num2);
    }
}
