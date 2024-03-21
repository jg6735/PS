import java.io.*;

public class Main {

    private static int N, M, answer = 1;
    private static int[] dp;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int before = 0;
        for (int i = 0; i < M; i++) {
            int cur = Integer.parseInt(in.readLine());
            answer *= dp[cur - before - 1];
            before = cur;
        }

        answer *= dp[N - before];
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        dp = new int[41];
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}