import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] cds;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        String input = "";
        StringTokenizer st;
        while (!(input = in.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cds = new int[N];

            for (int i = 0; i < N; i++) {
                cds[i] = Integer.parseInt(in.readLine());
            }

            int result = 0;
            for (int i = 0; i < M; i++) {
                int n = Integer.parseInt(in.readLine());
                if (binarySearch(n)) {
                    result++;
                }
            }

            builder.append(result).append("\n");
        }
    }

    private static boolean binarySearch(int number) {
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (cds[mid] == number) {
                return true;
            }

            if (cds[mid] > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
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