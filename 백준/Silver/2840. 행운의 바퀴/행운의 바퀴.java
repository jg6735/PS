import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] alphabet;
    private static char[] arr;
    private static int N, K;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringTokenizer st;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        Arrays.fill(arr, '?');

        int idx = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int count = Integer.parseInt(st.nextToken());
            char s = st.nextToken().charAt(0);

            idx = (idx + N - (count % N)) % N;
            if (arr[idx] != s) {
                if (arr[idx] == '?' && !alphabet[s]) {
                    arr[idx] = s;
                    alphabet[s] = true;
                } else {
                    builder.append("!");
                    return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            builder.append(arr[(idx + i) % N]);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        alphabet = new boolean['Z' + 1];
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N];
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}