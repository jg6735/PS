import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = -1;
        }

        dp[3] = 1;
        if (N >= 5) {
            dp[5] = 1;
        }

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != -1) {
                dp[i] = dp[i - 3] + 1;
            }

            if (dp[i - 5] != -1) {
                if (dp[i] == -1) {
                    dp[i] = dp[i - 5] + 1;
                } else {
                    dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
                }
            }
        }

        System.out.print(dp[N]);
    }
}