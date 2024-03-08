import java.io.*;

public class Main {

    private static int X;
    private static int[] dp, list;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            list[i] = i - 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                list[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                list[i] = i / 2;
            }
        }

        builder.append(dp[X]).append("\n");
        while (X > 0) {
            builder.append(X).append(" ");
            X = list[X];
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        X = Integer.parseInt(in.readLine());
        dp = new int[X + 1];
        list = new int[X + 1];
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}