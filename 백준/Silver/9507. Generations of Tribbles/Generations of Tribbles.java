import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        long[] dp = new long[68];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 68; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }

        StringBuilder builder = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            builder.append(dp[n]).append("\n");
        }

        System.out.print(builder);
    }
}