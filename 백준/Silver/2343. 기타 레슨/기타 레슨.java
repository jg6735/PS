import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, max, min, answer;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int l = min, r = max;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (isAvailable(mid)) {
                r = mid - 1;
                answer = mid;
            } else {
                l = mid + 1;
            }
        }
    }

    private static boolean isAvailable(int range) {
        int cnt = 0;
        int sum = 0;

        for (int n : arr) {
            sum += n;
            if (sum > range) {
                cnt++;
                sum = n;
            }
        }

        if (sum > 0) {
            cnt++;
        }

        return cnt <= M;
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
            max += arr[i];
            min = Math.max(min, arr[i]);
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}