import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String START = "1";
    private static int T, N;

    private static BufferedReader in;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (T-- > 0) {
            N = Integer.parseInt(in.readLine());
            search(1, 1, 0, 1, START);
            builder.append("\n");
        }
    }

    private static void search(int cnt, int num, int sum, int op, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (cnt == N) {
            sum += (num * op);
            if (sum == 0) {
                builder.append(sb).append("\n");
            }

            return;
        }

        search(cnt + 1, num * 10 + cnt + 1, sum, op, sb.append(" ").append(cnt + 1).toString());
        sb = new StringBuilder(str);
        search(cnt + 1, cnt + 1, sum + (num * op), 1, sb.append("+").append(cnt + 1).toString());
        sb = new StringBuilder(str);
        search(cnt + 1, cnt + 1, sum + (num * op), -1, sb.append("-").append(cnt + 1).toString());
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() {
        System.out.println(builder);
    }
}