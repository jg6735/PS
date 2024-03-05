import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer;
    private static int[] arr;
    private static int[][] dp;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[2];
        }

        for (int i = 0; i < 3; i++) {
            answer = Math.min(dp[N][i], answer);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[3];
        dp = new int[N + 1][3];
        answer = Integer.MAX_VALUE;
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}