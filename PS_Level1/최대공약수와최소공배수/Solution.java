package PS_Level1.최대공약수와최소공배수;

public class Solution {
    public int[] solution(int n, int m) {
        return new int[]{getGcd(n, m), (n * m) / getGcd(n, m)};
    }

    private static int getGcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }

        return getGcd(m, n % m);
    }
}
