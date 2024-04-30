import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, answer;
    private static int[] values;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = N - 1; i >= 0; i--) {
            int value = values[i];
            if (K >= value) {
                answer += K / value;
                K %= value;
            }

            if (K == 0) {
                break;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(in.readLine());
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}