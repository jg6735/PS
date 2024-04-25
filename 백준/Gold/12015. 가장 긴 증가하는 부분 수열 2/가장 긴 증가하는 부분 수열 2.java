import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, len;
    private static int[] arr, lis;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            if (arr[i] > lis[len]) {
                lis[++len] = arr[i];
            } else {
                int pos = binarySearch(0, len, arr[i]);
                lis[pos] = arr[i];
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        lis = new int[N + 1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private static void print() throws IOException {
        out.write(Integer.toString(len));
        out.flush();
    }
}