import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int T, N, X, Y;
    private static double[] cars, result;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            cars = new double[N];
            result = new double[N];

            double min = Double.MAX_VALUE;
            int answer = -1;
            for (int i = 0; i < N; i++) {
                cars[i] = Integer.parseInt(st.nextToken());
                result[i] = X / cars[i];

                if (i == N - 1 && result[i] < min) {
                    answer = 0;
                }

                min = Math.min(min, result[i]);
            }

            if (answer == 0) {
                builder.append(answer).append("\n");
                continue;
            }

            int left = 0;
            int right = Y;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((X - mid) / cars[N - 1] + 1 >= min) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left > Y) {
                left = -1;
            }
            
            builder.append(left).append("\n");
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}