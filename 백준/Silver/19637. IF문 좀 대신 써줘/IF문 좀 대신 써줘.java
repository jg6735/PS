import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static String[] names;
    private static int[] powers;

    private static BufferedReader in;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(in.readLine());
            int idx = binarySearch(power);
            builder.append(names[idx]).append("\n");
        }
    }

    private static int binarySearch(int key) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = powers[mid];

            if (val < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        names = new String[N];
        powers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            names[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() {
        System.out.print(builder);
    }
}