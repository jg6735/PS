import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int a, b, c;
    private static int[][][] dp;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        setDp();
        getAnswer();
    }

    private static void setDp() {
        dp = new int[101][101][101];
        for (int i = 0; i <= 70; i++) {
            for (int j = 0; j <= 70; j++) {
                for (int k = 0; k <= 70; k++) {
                    if (i <= 50 || j <= 50 || k <= 50) {
                        dp[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
    }

    private static void getAnswer() throws IOException {
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                return;
            }

            builder.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            if (a <= 0 || b <= 0 || c <= 0) {
                builder.append(1);
            } else if (a > 20 || b > 20 || c > 20) {
                builder.append(dp[70][70][70]);
            } else {
                builder.append(dp[a + 50][b + 50][c + 50]);
            }
            builder.append("\n");

        }
    }



    private static void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}