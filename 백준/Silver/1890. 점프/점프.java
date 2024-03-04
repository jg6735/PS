import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long answer;
    private static int[][] arr;
    private static long[][] dp;
    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        answer = search(1, 1);
    }

    private static long search(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        if (r == N && c == N) {
            return 1;
        }

        dp[r][c] = 0;
        int nextR = r + arr[r][c];
        int nextC = c + arr[r][c];

        if (nextR > N && nextC > N) {
            return 0;
        }

        if (nextR <= N) {
            dp[r][c] = Math.max(dp[r][c], dp[r][c] + search(r + arr[r][c], c));
        }

        if (nextC <= N) {
            dp[r][c] = Math.max(dp[r][c], dp[r][c] + search(r, c + arr[r][c]));
        }

        return dp[r][c];
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
    }

    private static void print() {
        System.out.println(answer);
    }
}