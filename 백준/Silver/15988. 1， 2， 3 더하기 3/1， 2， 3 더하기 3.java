import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int DIVISOR = 1_000_000_009;
    static final int MAX = 1_000_000;
    static long[] dp = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        setDP();

        while (T-- > 0) {
            int n = Integer.parseInt(in.readLine());
            builder.append(dp[n]).append("\n");
        }

        System.out.print(builder);
    }

    static void setDP() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % DIVISOR;
        }
    }
}