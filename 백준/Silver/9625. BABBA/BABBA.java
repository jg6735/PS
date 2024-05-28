import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();
        int[][] dp = new int[k + 1][2];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        builder.append(dp[k][0]).append(" ").append(dp[k][1]);
        System.out.print(builder);
    }
}