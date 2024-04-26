import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] sums;
    private static int[][] arr;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int start, end;
        for (int i = 0; i < M; i++) {
            start = arr[i][0];
            end = arr[i][1];

            builder.append(sums[end] - sums[start - 1]).append("\n");
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][2];
        sums = new int[N + 1];
        st = new StringTokenizer(in.readLine());
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            sum += Integer.parseInt(st.nextToken());
            sums[i] += sum;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}