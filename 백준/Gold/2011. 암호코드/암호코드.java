import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = in.readLine();
        // dp[x] = x번째 암호까지 고려했을 때 가능한 경우의 수
        int[] dp = new int[password.length() + 1];
        dp[0] = dp[1] = 1;
        if (password.charAt(0) == '0') {
            System.out.print(0);
            return;
        }

        for (int i = 2; i <= password.length(); i++) {
            int one = password.charAt(i - 1) - '0';
            int two = (password.charAt(i - 2) - '0') * 10 + one;

            if (one >= 1) {
                dp[i] = dp[i - 1];
            }

            if (two >= 10 && two <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1_000_000;
            }
        }

        System.out.println(dp[password.length()]);
    }
}