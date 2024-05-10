import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            if (i < N) {
                st = new StringTokenizer(br.readLine());
            }

            for (int j = 0; j <= M; j++) {
                if (i < N && j < M) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

                if (i >= 1 && j >= 1) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + map[i - 1][j - 1];
                }
            }
        }

        System.out.print(dp[N][M]);
    }
}
