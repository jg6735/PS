import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, answer;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int left = 0;
        int right = 0;
        int sum = 0;
        answer = 0;

        while (true) {
            if (sum >= M) {
                sum -= arr[left++];
            } else if (right == N) {
                break;
            } else if (sum < M) {
                sum += arr[right++];
            }

            if (sum == M) {
                answer++;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}