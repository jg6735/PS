import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static long N, M, result;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (N >= M) {
            result = 0;
            return;
        }

        result = 1;
        for (int i = 1; i <= N; i++) {
            result = result * i % M;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
    }

    private static void print() throws IOException {
        out.write(Long.toString(result));
        out.flush();
    }
}