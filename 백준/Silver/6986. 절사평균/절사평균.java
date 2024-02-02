import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static double sum;
    private static double[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Arrays.sort(arr);

        double first = sum;
        double second = sum;
        for (int i = 0; i < K; i++) {
            first -= arr[i];
            first -= arr[N - i - 1];
        }

        for (int i = 0; i < K; i++) {
            second += arr[K] - arr[i];
            second += arr[N - K - 1] - arr[N - i - 1];
        }

        builder.append(String.format("%.2f", first / (N - K * 2) + 1e-8)).append("\n");
        builder.append(String.format("%.2f", second / N + 1e-8));
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new double[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(in.readLine());
            sum += arr[i];
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}