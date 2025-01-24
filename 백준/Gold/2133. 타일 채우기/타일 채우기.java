import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        if (n % 2 != 0) {
            System.out.print(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.print(dp[n]);
    }
}