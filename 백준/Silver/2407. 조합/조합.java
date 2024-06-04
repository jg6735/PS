import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[] dp = new BigInteger[Math.max(n, m) + 1];
        dp[0] = dp[1] = BigInteger.ONE;
        for (int i = 2; i <= Math.max(n, m); i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }

        System.out.print(dp[n].divide(dp[m].multiply(dp[n - m])));
    }
}