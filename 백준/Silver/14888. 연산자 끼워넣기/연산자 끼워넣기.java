import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int MIN = Integer.MAX_VALUE;
    private static int MAX = Integer.MIN_VALUE;

    private static int N;
    private static int[] arr, op;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        dfs(1, arr[0]);
        builder.append(MAX).append("\n").append(MIN);
    }

    private static void dfs(int cnt, int sum) {
        if (cnt == N) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) {
                continue;
            }

            op[i]--;

            if (i == 0) {
                dfs(cnt + 1, sum + arr[cnt]);
            } else if (i == 1) {
                dfs(cnt + 1, sum - arr[cnt]);
            } else if (i == 2) {
                dfs(cnt + 1, sum * arr[cnt]);
            } else {
                dfs(cnt + 1, sum / arr[cnt]);
            }

            op[i]++;
        }

    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}