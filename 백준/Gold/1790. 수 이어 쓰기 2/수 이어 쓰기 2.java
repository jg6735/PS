import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static long N, k;
    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        long number = 0;
        long idx = 1;

        long prev = k;
        while (k > 0) {
            prev = k;
            k -= (long) ((Math.pow(10, number)) * idx * 9);
            number++;
            idx++;
        }

        long idx2 = (prev - 1) / (idx - 1);
        long result = (long) Math.pow(10, --number) + idx2;
        if (result > N) {
            System.out.print(-1);
        } else {
            int ansIdx = (int) ((prev - 1) % (idx - 1));
            System.out.print(String.valueOf(result).charAt(ansIdx));
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
    }
}