import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int n;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                answer = Math.max(answer, dfs(r, c));
            }
        }

        System.out.print(answer);
    }

    static int dfs(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 1;
        for (int d = 0; d < 4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < n) {
                if (map[nextR][nextC] > map[r][c]) {
                    dp[r][c] = Math.max(dp[r][c], dfs(nextR, nextC) + 1);
                }
            }
        }

        return dp[r][c];
    }
}