import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, answer;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int sum = 0;
        for (int i = 0; i < K + 1 && i < arr.length; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int left = i - 1 - K;
            int right = i + 1 + K;
            if (left >= 0) {
                sum -= arr[left];
            }

            if (right < arr.length) {
                sum += arr[right];
            }

            answer = Math.max(answer, sum);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}