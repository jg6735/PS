import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += arr[j];
            }

            int mul = 1;
            for (int j = i; j < N - 3 + i; j++) {
                mul *= arr[j];
            }

            result[i] += mul;
            for (int j = N - 3 + i; j < N; j++) {
                result[i] += arr[j];
            }

            answer = Math.max(answer, result[i]);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}