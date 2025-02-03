import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];
        for (int i = 1; i <= T; i++) {
            for (int j = 0; j <= W; j++) {
                int cur = arr[i];
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + (cur == 1 ? 1 : 0);
                    continue;
                }

                if (j % 2 == (cur - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= W; i++) {
            max = Math.max(max, dp[T][i]);
        }

        System.out.print(max);
    }
}