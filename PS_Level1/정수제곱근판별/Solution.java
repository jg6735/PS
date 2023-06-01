package PS_Level1.정수제곱근판별;

public class Solution {
    public long solution(long n) {
        if (n == Math.pow((int) Math.sqrt(n), 2)) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
    }
}
