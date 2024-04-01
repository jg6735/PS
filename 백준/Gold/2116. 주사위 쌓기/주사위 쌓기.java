import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, result;
    private static int[][] dices;
    private static int[] arr = {5, 3, 4, 1, 2, 0};

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        result = Integer.MIN_VALUE;
        for (int i = 1; i <= 6; i++) {
            result = Math.max(result, dfs(0, i, 0));
        }
    }

    private static int dfs(int cnt, int bottom, int sum) {
        if (cnt == N) {
            return sum;
        }

        int max = 0;
        int next = 0;
        for (int i = 0; i < 6; i++) {
            if (bottom == dices[cnt][i]) continue;
            if (bottom == dices[cnt][arr[i]]) {
                next = dices[cnt][i];
                continue;
            }

            max = Math.max(max, dices[cnt][i]);
        }

        return dfs(cnt + 1, next, sum + max);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        dices = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(result));
        out.flush();
    }
}