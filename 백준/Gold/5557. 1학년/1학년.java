import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[x][y] : x번째 숫자까지 고려했을 때, 합이 y가 되는 경우의 수
        long[][] dp = new long[N][21];
        // 첫 번째 숫자는 무조건 선택되므로 1로 초기화
        dp[0][arr[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j + arr[i] <= 20) {
                        dp[i][j + arr[i]] += dp[i - 1][j];
                    }

                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.print(dp[N - 2][arr[N - 1]]);
    }
}